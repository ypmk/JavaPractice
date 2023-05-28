package com.company;

public class BugTracker {
    private  boolean activeSprint;

    public boolean isActiveSprint(){
        return activeSprint;
    }

    public void startSprint(){
        System.out.println("Спринт активен");
        activeSprint=true;
    }

    public void finishSprint(){
        System.out.println("Спринт не активен");
        activeSprint=false;
    }

}
