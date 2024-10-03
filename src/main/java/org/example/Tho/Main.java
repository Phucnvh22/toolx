package org.example.Tho;

import org.checkerframework.checker.units.qual.A;
import org.example.demo.User;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        User user1 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55na57k/carousel");

        AutoPost autoPost = new AutoPost();
        List<String> urlList = autoPost.autoPost("4", user1);


        ShareAuto shareAuto = new ShareAuto();

        // Tạo một ExecutorService với 2 luồng
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Gửi hai nhiệm vụ autoShare để thực hiện đồng thời
        executor.submit(() -> {
            try {
                shareAuto.autoShare(urlList, "2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
                shareAuto.autoShare(urlList, "3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        // Tắt ExecutorService
        executor.shutdown();

        // Đợi cho đến khi tất cả các nhiệm vụ hoàn thành hoặc timeout sau 1 giờ
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("All sharing tasks completed.");
    }
}


