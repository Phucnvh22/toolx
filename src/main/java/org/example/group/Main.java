package org.example.group;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(() -> {
            try {
                PostGroup.postGroup(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
