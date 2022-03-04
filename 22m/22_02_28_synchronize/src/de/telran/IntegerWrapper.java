package de.telran;

public class IntegerWrapper {
    private int number;

    // объект, играющий роль мьютекса, обязан быть final
    private final Object mu = new Object();

    public void increment() {
        // Mutex (mutual exclusion - взаимное исключение) это специальный механизм для синхронизации потоков.
        // В Java является частью каждого объекта.
        // Фактически, мьютекс - это переключаетель с двумя положениями: закрыт/открыт (занят/свободен).

        // Задачей мьютекса состоит в том, чтобы обеспечить доступ в одно и то же время к одному или нескольким блокам
        // кода только одному из потоков.

        // Монитор - это "инфраструктура" для мьютекса, которая обеспечивает его корректную работу для синхронизации
        // кода

        synchronized (mu) {
            number++;
        }
    }

    public void decrement() {
        synchronized (mu) {
            number--;
        }
    }

    public int getNumber() {
        return number;
    }
}
