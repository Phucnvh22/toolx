package org.example.Tho;

import org.example.demo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<User> userList = new ArrayList<>();
        User user1 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user2 = new User("fernand39814094", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user3 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user4 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user5 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user6 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user7 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user8 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user9 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user10 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        User user11 = new User("UrreyA77612", "dVs4iUe1CHz", "franzengeorgette1306@hotmail.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);
        userList.add(user9);
        userList.add(user10);
        userList.add(user11);
        AutoPost autoPost = new AutoPost();
        System.out.println("Danh sách tài khoản đăng bài");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println((i + 1) + ". " + userList.get(i).getUsername());
        }
        System.out.print("Chọn số tương ứng với người muốn đăng bài (1-" + userList.size() + "): ");
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > userList.size()) {
                    System.out.print("Số không hợp lệ. Vui lòng chọn lại (1-" + userList.size() + "): ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập một số hợp lệ (1-" + userList.size() + "): ");
            }
        }
        int i = choice - 1;
        User selectedUser = userList.get(i);
        System.out.println("Bạn đã chọn người dùng: " + selectedUser.getUsername());

        List<String> urlList = autoPost.autoPost(String.valueOf(choice), selectedUser);

       ShareAuto shareAuto = new ShareAuto();
//        String link1 = "";
//        String link2 = "";
//        String link3 = "";
//
//        List<String> urlList = new ArrayList<>();
//        urlList.add(link1);
//        urlList.add(link2);
//        urlList.add(link3);
//            // Tạo một ExecutorService với 2 luồng
            ExecutorService executor = Executors.newFixedThreadPool(10);

            // Gửi hai nhiệm vụ autoShare để thực hiện đồng thời


//            executor.submit(() -> {
//                try {
//                    shareAuto.autoShare(urlList, "2");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//
//            executor.submit(() -> {
//                try {
//                    shareAuto.autoShare(urlList, "3");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        executor.submit(() -> {
//            try {
//                shareAuto.autoShare(urlList, "4");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executor.submit(() -> {
//            try {
//                shareAuto.autoShare(urlList, "5");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executor.submit(() -> {
//            try {
//                shareAuto.autoShare(urlList, "6");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executor.submit(() -> {
//            try {
//                shareAuto.autoShare(urlList, "7");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        executor.submit(() -> {
//            try {
//                shareAuto.autoShare(urlList, "8");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executor.submit(() -> {
//            try {
//                shareAuto.autoShare(urlList, "9");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executor.submit(() -> {
//            try {
//                shareAuto.autoShare(urlList, "10");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });



            // Tắt ExecutorService
            executor.shutdown();

            // Đợi cho đến khi tất cả các nhiệm vụ hoàn thành hoặc timeout sau 1 giờ
            executor.awaitTermination(1, TimeUnit.HOURS);

            System.out.println("All sharing tasks completed.");
        }

    }



