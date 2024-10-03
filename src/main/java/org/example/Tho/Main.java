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
        User user1 = new User("EvitaMock37227", "iN5KtUOoyd0g", "31!fj5-h--03m!o64-6rq@mailforspam.com", "https://ads.x.com/composer/18ce55lys3q/carousel");

        AutoPost autoPost = new AutoPost();
        List<String> urlList = autoPost.autoPost("1", user1);


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
        executor.submit(() -> {
            try {
                shareAuto.autoShare(urlList, "4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(() -> {
            try {
                shareAuto.autoShare(urlList, "5");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(() -> {
            try {
                shareAuto.autoShare(urlList, "6");
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


