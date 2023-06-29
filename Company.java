package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Company {

    private static final Random random = new Random();
    private final String companyName;
    private final double maxSalary;

    private final Publisher jobAgency;


    public Company(String companyName, double maxSalary, Publisher jobAgency) {
        this.companyName = companyName;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
    }

    public void needEmployee() {
        double salary = random.nextDouble(3000, maxSalary);
        Vacancy vacancy = new Vacancy(companyName, "Описание вакансии", salary);

    }

}
