package com.company;

public class Developer {
    public void doJobBeforeDeadLine(BugTracker bugTracker){
        if(bugTracker.isActiveSprint()){
            System.out.println("Разработчик фиксит проблемы...");
        }
        else {
            System.out.println("Разработчик читает статьи на хабре...");
        }
    }

}
