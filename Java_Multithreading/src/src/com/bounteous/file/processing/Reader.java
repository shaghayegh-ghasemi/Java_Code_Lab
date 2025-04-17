package com.bounteous.file.processing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class Reader implements Callable<List<Double>> {
    private final Path path;

    public Reader(Path path) {
        this.path = path;
    }

    @Override
    public List<Double> call() throws Exception {
        long startTime = System.nanoTime();

        List<Double> numericalData = new ArrayList<>();
        try(Stream<String> stream = Files.lines(this.path);) {
            stream.forEach(
                    line -> {
                        numericalData.add(Double.parseDouble(line.trim()));
                    }
            );
        } catch (IOException e){
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("[" + this.path + "] processed in " + executionTime + "ms.");
        return numericalData;
    }
}
