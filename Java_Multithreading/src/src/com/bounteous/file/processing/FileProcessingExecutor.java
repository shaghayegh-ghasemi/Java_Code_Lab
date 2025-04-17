package com.bounteous.file.processing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FileProcessingExecutor {

    public void run(String dir){
        long startTime = System.nanoTime();

        List<Path> files = getFiles(dir);

        if (files.isEmpty()){
            System.out.println("The specified directory does not contain a .txt file.");
            return;
        }
        // use up to 2 threads per core for better I/O performance
        // but don't exceed the number of input files
        int nThreads = Math.min(files.size(), Runtime.getRuntime().availableProcessors()*2);
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        List<Reader> fileReaders = new ArrayList<>();
        List<Future<List<Double>>> result = new ArrayList<>();
        double globalSum = 0.0;
        int count = 0;
        double globalAvg = 0.0;

        // creating readers for each file inside the directory
        for(Path p : files){
            fileReaders.add(new Reader(p));
        }

        // submitting tasks to executor service
        for(Reader task : fileReaders){
            result.add(executorService.submit(task));
        }

        // calculating result
        for (int i = 0; i < result.size(); i++){
            try {
                List<Double> numbers = result.get(i).get(); // blocking call
                double fileSum = 0.0;
                for (Double num : numbers) fileSum += num;

                System.out.println("\nResults for file [" + files.get(i) + "]");
                System.out.println("Total: " + fileSum);
                System.out.println("Average: " + fileSum/numbers.size());

                globalSum += fileSum;
                count += numbers.size();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        globalAvg = globalSum / count;

        System.out.println("\nGrand Total Sum: " + globalSum);
        System.out.println("Overall Average: " + globalAvg);

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution Time: " + executionTime + " ms");
        executorService.shutdown();
    }

    // get all files in a directory
    private List<Path> getFiles(String dir){
        try {
            return Files.list(Paths.get(dir))
                    .filter(Files::isRegularFile) // avoid subdirectories, symbolic links
                    .filter(path -> path.toString().endsWith(".txt"))
                    .collect(Collectors.toList());
        } catch (IOException e){
            System.err.println("Failed to list files in the directory: " + dir);
            e.printStackTrace();
            return List.of(); // returns empty list
        }
    }
}
