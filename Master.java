package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Master implements Observer {

    private static final Random random = new Random();

    private final String name;

    private double minSalary;

    private boolean foundJob;

    public void setFoundJob(boolean foundJob) {
        this.foundJob = foundJob;
    }

    public String getName() {
        return name;
    }

    public Master(String name) {
        this.name = name;
        minSalary = random.nextDouble(60000, 80000);
    }

    @Override
    public void receiveOffer(String companyName, double salary) {
        if (minSalary <= salary){
            System.out.printf("Рабочий %s (%f) >>> Мне нужна эта работа! [%s - %f]\n",
                    name, minSalary, companyName, salary);
            minSalary = salary;
        }
        else {
            System.out.printf("Рабочий %s >>> Я найду работу получше (%f)! [%s - %f]\n",
                    name, minSalary, companyName, salary);
        }
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (foundJob) {
            System.out.printf("%s (%f) >>> Я уже нашел работу! [%s - %f]\n",
                    getName(), minSalary, vacancy.getTitle(), vacancy.getSalary());
            System.out.println("Игнорировать");
        }
    }

}