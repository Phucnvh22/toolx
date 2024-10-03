package org.example.demo;

public class Run {
    public static void main(String[] args) {
        User user1 = new User("EvitaMock37227", "iN5KtUOoyd0g", "31!fj5-h--03m!o64-6rq@mailforspam.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user2 = new User("songplatform_", "Pppp6868@", "nguyenthi121333@gmail.com", "https://ads.x.com/composer/18ce55lys3x/carousel");
        AutoPost autoPost1 = new AutoPost(user1, 0, 0);
        AutoPost autoPost2 = new AutoPost(user2, 800, 0);

        Thread thread1 = new Thread(autoPost1);
        Thread thread2 = new Thread(autoPost2);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Cả hai luồng đã hoàn thành.");

    }
}
