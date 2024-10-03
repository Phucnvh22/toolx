package org.example.finall;

import org.example.demo.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("EvitaMock37227", "iN5KtUOoyd0g", "31!fj5-h--03m!o64-6rq@mailforspam.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user2 = new User("songplatform_", "Pppp6868@", "nguyenthi121333@gmail.com", "ushttps://ads.x.com/composer/18ce55lys3x/caroel");
        User user3 = new User("ClaryMigda80832", "c6Ks87f80Djj", "|--3eubpwm8aqta7-!c-b7@mailforspam.com", "--3eubpwm8aqta7-!c-b7@mailforspam.com");
        User user4 = new User("StephaniaS16250", "JqwF5jnmj2jF", "qp&164-j6-3cl0ua!6o1!r-@mailforspam.com", "https://ads.x.com/composer/18ce55lys3x/carousel");
        User user5 = new User("ShanaeOliv43891", "O3PMlul4Sa2D", "rp8j&9280b1!3-876o75@mailforspam.com", "https://ads.x.com/composer/18ce55lys3x/carousel");

        LocalDateTime executionTime = LocalDateTime.now().plusSeconds(3); // Ví dụ: chạy sau 1 giờ

        ScheduledPostManager.schedulePost(() -> {
            try {
                ConcurrentTaskManager postManager = new ConcurrentTaskManager(1);

                postManager.addTask(() -> {
                    System.out.println("Task 1 started");
                    String postUrl = PostAutomation.AutomationPostX(user1, 0, 0);
                    DataStorage.postUrl1 = postUrl;
                });

                postManager.startAndWait();

                List<String> postUrls = Arrays.asList(DataStorage.postUrl1);

                ConcurrentTaskManager shareManager = new ConcurrentTaskManager(4);

                shareManager.addTask(() -> {
                    System.out.println("Task 3 started");
                    AccessAutomation accessAutomation = new AccessAutomation();
                    accessAutomation.shareMetheo(postUrls, 50, 0, user2);
                });



                shareManager.addTask(() -> {
                    System.out.println("Task 4 started");
                    AccessAutomation accessAutomation = new AccessAutomation();
                    accessAutomation.shareMetheo(postUrls, 200, 0, user5);
                });


                shareManager.startAndWait();

                postManager.shutdown();
                shareManager.shutdown();
                System.out.println("All tasks have completed their execution.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executionTime);
    }
}