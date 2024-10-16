package org.example.Tho;

import org.example.demo.User;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AutoPost extends Test {
    public List<String> autoPost(String number, User user, String ip) {
        Random random = new Random();
        String linkShare = "";
        List<String> urlList = new ArrayList<>();
        WebDriver driver = null;
        try {
            // String chromeDriverPath = "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver.exe"; //Tho
            String chromeDriverPath = "C:\\Users\\ACER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            String data = "C:\\Users\\ACER\\AppData\\Local\\Google\\Chrome\\User Data\\User ";
           //String data = "C:\\Users\\Admin\\AppData\\Local\\Google\\Chrome\\User Data\\Profile "; //Tho
            String userDataDir = data + number;

            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=" + userDataDir);
            options.addArguments("--no-first-run");
            options.addArguments("--no-default-browser-check");
            options.addArguments("--disable-notifications");

            // Thêm cấu hình proxy
            Proxy proxy = new Proxy();
            proxy.setHttpProxy(ip);
            proxy.setSslProxy(ip);
            options.setCapability("proxy", proxy);

            driver = new ChromeDriver(options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            for (int i = 0; i < 3; i++) {
                System.out.println("Starting iteration " + (i + 1));
                driver.get(user.getUrl());

                randomDelay();
                new Actions(driver).sendKeys(Keys.ESCAPE).perform();

                randomDelay();

                By singleFileElement = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/span[2]");
                wait.until(ExpectedConditions.elementToBeClickable(singleFileElement)).click();

                randomDelay();

                By addMedia = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[8]/button[1]/span[1]");
                wait.until(ExpectedConditions.elementToBeClickable(addMedia)).click();
                randomDelay();

                WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
                String filePath;
                if (i < 2) {
                    int video = random.nextInt(4);
                    filePath = "C:\\Users\\ACER\\Downloads\\" + (video + 1) + ".mp4";
                    System.out.println("Đã chọn video số " + (video + 1));
                } else {
                    int image = random.nextInt(2);
                    filePath = "C:\\Users\\ACER\\Downloads\\anh\\" + (image + 1) + ".PNG";
                    System.out.println("Đã chọn ảnh số " + (image + 1));
                }
                fileInput.sendKeys(filePath);
                randomDelay();


                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@aria-label, 'Loading')]")));

                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                randomDelay();

                WebElement websiteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/button[1]")));
                websiteButton.click();

                WebElement websiteOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[1]//button[text()='Website']")));
                websiteOption.click();
                randomDelay();

                WebElement sub = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".TweetTextInput-editor.is-empty")));
                int a = random.nextInt(90000) + 1000;
                sub.sendKeys("Episode  " + a);

                randomDelay();

                WebElement untitled = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")));
                Test.typeHumanLikeWithMistakes(untitled, "xxx");

                randomDelay();

                WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-test-id='promotedOnlyCheckbox']")));
                checkbox.click();

                randomDelay();

                WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='https://']")));
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                String linkUrl = (i < 2) ? "https://masaribananaae.blogspot.com" : "https://sawanicatiis15ssaea.blogspot.com/";
                Test.typeHumanLikeWithMistakes(link, linkUrl);

                randomDelay();

                WebElement post = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", post);

                String originalTab = driver.getWindowHandle();

                randomDelay();

                // Chờ đợi nút "View Tweet" xuất hiện và click
                WebElement tweet = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View Tweet']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tweet);

                // Chờ cho đến khi tab mới xuất hiện
                wait.until(ExpectedConditions.numberOfWindowsToBe(2));

                // Lấy tất cả các handle của các tab đang mở
                Set<String> allTabs = driver.getWindowHandles();

                // Chuyển qua tab mới
                for (String tab : allTabs) {
                    if (!tab.equals(originalTab)) {
                        // Chuyển sang tab mới
                        driver.switchTo().window(tab);
                        // Thực hiện các thao tác cần thiết trên tab mới
                        linkShare = driver.getCurrentUrl();
                        System.out.println(linkShare);
                        urlList.add(linkShare);
                        // Đóng tab hiện tại
                        driver.close();
                        // Quay lại tab ban đầu
                        driver.switchTo().window(originalTab);

                    }
                }


            }
                System.out.println("All actions completed successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                //driver.quit();
                System.out.println("WebDriver closed.");
            }
        }
        return urlList;
    }
}