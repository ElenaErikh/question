package ru.geekbrains.something;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.method1();
        new Thread(() -> counter.countValues()).start();
        new Thread(() -> counter.countValues()).start();
        counter.method2();

    }


}
