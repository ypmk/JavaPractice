package com.company;

//Паттерн Строитель
public class P {
    public static void main(String[] args){
        Person person = new PersonBuilderImpl().setName("Mike").setAge(22).setWeight(75.5).build();
        person.print();
    }
}


