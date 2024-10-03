package org.example.finall;

import java.util.concurrent.*;

public class ConcurrentTaskManager {
    private final ExecutorService executor;
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public ConcurrentTaskManager(int threadCount) {
        this.executor = Executors.newFixedThreadPool(threadCount);
        this.startSignal = new CountDownLatch(1);
        this.doneSignal = new CountDownLatch(threadCount);
    }

    public void addTask(Runnable task) {
        executor.submit(() -> {
            try {
                startSignal.await(); // Đợi tín hiệu bắt đầu
                task.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                doneSignal.countDown();
            }
        });
    }

    public void startAndWait() throws InterruptedException {
        startSignal.countDown(); // Cho phép tất cả các task bắt đầu
        doneSignal.await(); // Đợi tất cả các task hoàn thành
    }

    public void shutdown() {
        executor.shutdown();
    }
}