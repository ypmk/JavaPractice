package com.company;

//Singleton holder. Можно ипользовать всегда, когда нужна многопоточность
// и есть гарантия, что объект синглтон класса будет создан без проблем.
public class Singleton_3 {

    private Singleton_3() {
    }

    private static class SingletonHolder {
        public static final Singleton_3 HOLDER_INSTANCE = new Singleton_3();
    }

    public static Singleton_3 getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}