package org.example.group;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        PostGroup1 postGroup1 = new PostGroup1();
        PostGroup2 postGroup2 = new PostGroup2();
        PostGroup3 postGroup3 = new PostGroup3();
        executor.submit(() -> {
            try {
                postGroup1.postGroup(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                postGroup2.postGroup(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                postGroup3.postGroup(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
