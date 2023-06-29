package ru.geekbrains.lesson7.observer;

public interface Observer {

    void receiveOffer(String companyName, double salary);

        void receiveOffer(Vacancy vacancy);
    }



