package com.bounteous.employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Processor {

    // this function read the employee records from the file
    public static <T> List<Employee<T>> read(String sourceFile, Function<String, T> deptParser){
        List<Employee<T>> employees = new ArrayList<>();

        try (Stream<String> records = Files.lines(Paths.get(sourceFile))){
            records.forEach(record -> {
                String[] info = record.split(",");
                if (info.length == 4) {
                    Integer id = Integer.parseInt(info[0].trim());
                    String name = info[1].trim();
                    Double performanceRating = Double.parseDouble(info[2].trim());
                    T departement = deptParser.apply(info[3].trim());
                    employees.add(new Employee<>(id, name, performanceRating, departement));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // extract employees with performance higher than a specific rating
    public static <T> List<Employee<T>> extractHigherRating(List<Employee<T>> employees, Double rating){
        return employees.stream().filter(employee -> employee.getPerformanceRating() > rating)
                .sorted(Comparator.comparing(Employee<T>::getPerformanceRating).reversed())
                .collect(Collectors.toList());
    }

    public static <T> void write(List<Employee<T>> employees, String outputFile){
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))){
            for (Employee<T> emp : employees) {
                writer.write(String.format("%d,%s,%.1f,%s\n",
                                emp.getId(),
                                emp.getName(),
                                emp.getPerformanceRating(),
                                emp.getDepartment())
                        );
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // this function prints the employee record
    public static <T> void print(List<Employee<T>> employees){
        employees.forEach(employee -> System.out.println(employee));
    }
}
