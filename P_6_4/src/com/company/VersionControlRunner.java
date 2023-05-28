package com.company;

//Паттерн Прототип
public class VersionControlRunner {
    public static void main(String[] args){
        Project master = new Project(1,"SuperProject", "https...");

        System.out.println(master);

        ProjectFactory factory = new ProjectFactory(master);
        Project masterClone = factory.cloneProject();

        System.out.println("\n***************************\n");
        System.out.println(masterClone);

    }


}
