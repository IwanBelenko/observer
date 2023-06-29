package ru.geekbrains.lesson7.observer;

public class Freelancer implements Observer {
    private String name;


    private double minSalary;

    private boolean foundJob;

    public void setFoundJob(boolean foundJob) {
        this.foundJob = foundJob;
    }

    public String getName() {
        return name;
    }

    public Freelancer(String name) {
        this.name = name;
        minSalary = 60000;
    }

    @Override
    public void receiveOffer(String companyName, double salary) {

    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        double salary = vacancy.getSalary();
        if (minSalary <= salary) {
            System.out.printf("Фрилансер %s (%f) >>> Мне нужна эта работа! [%s - %f]\n",
                    name, minSalary, vacancy.getTitle(), salary);
            minSalary = salary;
        } else {
            System.out.printf("Фрилансер %s >>> Я найду работу получше (%f)! [%s - %f]\n",
                    name, minSalary, vacancy.getTitle(), salary);

            if (foundJob) {
                System.out.printf("%s (%f) >>> Я уже нашел работу! [%s - %f]\n",
                        getName(), minSalary, vacancy.getTitle(), vacancy.getSalary());
                System.out.println("Игнорировать");

            }
        }
    }
}
