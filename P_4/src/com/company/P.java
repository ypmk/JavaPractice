package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class P {

    //Создадим класс, реализующий Runnable. Объекты этого класса будут задачами для ExecutorService.
    public static class Task implements Runnable {
        int taskNumber;

        public Task(int taskNumber) {
            this.taskNumber = taskNumber;
        }

        //Блокируем поток на 2 секунды, имитируя нагрузку, и выводим номер текущей задачи и имя потока, на котором выполняем данную задачу.
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Обработан запрос пользователя №" + taskNumber + " на потоке " + Thread.currentThread().getName());
        }

    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task(i));
        }
        executorService.shutdown();
    }



}
