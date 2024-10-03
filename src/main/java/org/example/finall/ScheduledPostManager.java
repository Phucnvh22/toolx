package org.example.finall;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class ScheduledPostManager {
    public static void schedulePost(Runnable task, LocalDateTime executionTime) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        long delay = ChronoUnit.SECONDS.between(LocalDateTime.now(), executionTime);

        scheduler.schedule(() -> {
            try {
                task.run();
            } finally {
                scheduler.shutdown();
            }
        }, delay, TimeUnit.SECONDS);

        System.out.println("Task scheduled to run at: " + executionTime);
    }

    public static void main(String[] args) {
        LocalDateTime executionTime = LocalDateTime.now().plusMinutes(5); // Ví dụ: chạy sau 5 phút

        schedulePost(() -> {
            // Đặt logic của bạn ở đây
            System.out.println("Executing scheduled task at: " + LocalDateTime.now());
            // Ví dụ: PostAutomation.AutomationPostX(user1, 0, 0);
        }, executionTime);
    }
}