package de.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Считывает сообщения из командной строки и добавляет в очередь
public class SupplierTask implements Runnable {

    private final SingleStringQueue queue;

    public SupplierTask(SingleStringQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null && !line.equals("exit")) {
                queue.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
