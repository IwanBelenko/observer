package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Student implements Observer {

    private static final Random random = new Random();
    private final String name;

    private double minSalary;


    public Student(String name) {
        this.name = name;
        minSalary = random.nextDouble(2000, 4000);
    }

    public String getName() {
        return name;
    }

    private boolean foundJob;

    public void setFoundJob(boolean foundJob) {
        this.foundJob = foundJob;
    }

    @Override
    public void receiveOffer(String companyName, double salary) {
        if (minSalary <= salary) {
            System.out.printf("Студент %s (%f) >>> Мне нужна эта работа! [%s - %f]\n",
                    name, minSalary, companyName, salary);
            minSalary = salary;
        } else {
            System.out.printf("Студент %s >>> Я найду работу получше (%f)! [%s - %f]\n",
                    name, minSalary, companyName, salary);
        }
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        double salary = vacancy.getSalary();
        if (minSalary <= salary) {
            System.out.printf("Студент %s (%f) >>> Мне нужна эта работа! [%s - %f]\n",
                    name, minSalary, vacancy.getTitle(), salary);
            minSalary = salary;
        } else {
            System.out.printf("Студент %s >>> Я найду работу получше (%f)! [%s - %f]\n",
                    name, minSalary, vacancy.getTitle(), salary);
        }
        if (foundJob) {
            System.out.printf("%s (%f) >>> Я уже нашел работу! [%s - %f]\n",
                    getName(), minSalary, vacancy.getTitle(), vacancy.getSalary());
            System.out.println("Игнорировать");
        }
    }

}
