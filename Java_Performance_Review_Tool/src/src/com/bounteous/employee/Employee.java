package com.bounteous.employee;

public class Employee <T> {
    private Integer id;
    private String name;
    private Double performanceRating;
    private T department;

    Employee(Integer id, String name, Double performanceRating, T department){
        this.id = id;
        this.name = name;
        this.performanceRating = performanceRating;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(Double performanceRating) {
        this.performanceRating = performanceRating;
    }

    public T getDepartment() {
        return department;
    }

    public void setDepartment(T department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", performanceRating=" + performanceRating +
                ", department=" + department +
                '}';
    }
}
