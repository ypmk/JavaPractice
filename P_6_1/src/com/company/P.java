package com.company;

//Фабричный метод
public class P {
    public static void main(String[] args) {
    SportsmanFactory sportsmanFactory=createSportsmanBySpeciality("run");
    Sportsman sportsman = sportsmanFactory.createSportsman();

    sportsman.winTheMedal();
    }

    static SportsmanFactory createSportsmanBySpeciality(String speciality){
        if(speciality.equalsIgnoreCase("swim")){
            return new SwimmerFactory();
        }
        else if (speciality.equalsIgnoreCase("run")){
            return new RunnerFactory();
        }
        else{
            throw new RuntimeException(speciality+"неизвесная специальность.");
        }
    }


}

