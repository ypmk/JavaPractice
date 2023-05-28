package com.company;

//Простое решение. Быстро, но лучше не использовать т.к. не ленивая инициализация
public class Singleton_1 {
        private static final Singleton_1 INSTANCE = new Singleton_1();

        private Singleton_1() {
        }

        public static Singleton_1 getInstance() {
            return INSTANCE;
        }
}
