package com.company;

public class SwimmerFactory implements SportsmanFactory{

    @Override
    public Sportsman createSportsman() {
        return new Swimmer();
    }
}
