package ru.geekbrains.lesson7.observer;

public class Vacancy {
    private String title;
    private String description;
    private double salary;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getSalary() {
        return salary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Vacancy(String title, String description, double salary) {
        this.title = title;
        this.description = description;
        this.salary = salary;
    }
}
