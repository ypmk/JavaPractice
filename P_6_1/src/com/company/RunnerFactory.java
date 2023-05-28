package com.company;

public class RunnerFactory implements SportsmanFactory{

    @Override
    public Sportsman createSportsman() {
        return new Runner();
    }
}
