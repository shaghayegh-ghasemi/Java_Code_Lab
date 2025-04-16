package com.bounteous.employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
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

    public static <T> void print(List<Employee<T>> employees){
        employees.forEach(employee -> {
            System.out.println(
                    employee.getId() + "," + employee.getName() + "," + employee.getPerformanceRating() + "," + employee.getDepartment()
            );
        });
    }
}
