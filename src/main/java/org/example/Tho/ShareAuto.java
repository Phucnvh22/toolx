package org.example.Tho;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ShareAuto extends Test{
    private final Random random = new Random();

    public void autoShare(List<String> urlList, String number) throws InterruptedException {
        //String chromeDriverPath = "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver.exe"; //Tho
        String chromeDriverPath = "C:\\Users\\PC\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        //String data = "C:\\Users\\Admin\\AppData\\Local\\Google\\Chrome\\User Data\\Profile";
        String data = "C:\\Users\\PC\\AppData\\Local\\Google\\Chrome\\User Data\\User ";

        String userDataDir = data + number;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userDataDir);
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            for (String url : urlList) {
                driver.get(url);
                randomWait(); // Thêm thời gian chờ ngẫu nhiên
                System.out.println("Accessing: " + url);



                // Thực hiện các hành động trên bài đăng
                clickElement(wait, driver, By.cssSelector("[data-testid='like']"));

                clickElement(wait, driver, By.cssSelector("[data-testid='retweet']"));
                randomWait();

                clickElement(wait, driver, By.xpath("//*[contains(text(), 'Đăng lại') or contains(text(), 'Repost')]"));
                System.out.println(" đã click được vào nút đăng lại");
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            randomWait();
            //driver.close();
        }
    }

    public void clickElement(WebDriverWait wait, WebDriver driver, By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

            // Di chuyển chuột đến phần tử một cách từ từ
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();

            // Cuộn tới phần tử
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Thêm thời gian chờ ngẫu nhiên
            // Chờ phần tử có thể click và click vào nó
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            System.out.println("Không thể click vào phần tử: " + by.toString());
            e.printStackTrace();
        }
    }

    private void randomWait() throws InterruptedException {
        int randomTime = 500 + random.nextInt(2000); // Tạo thời gian chờ ngẫu nhiên từ 500ms đến 2500ms
        Thread.sleep(randomTime);
    }

    private void randomScroll(WebDriver driver) {
        int scrollValue = random.nextInt(400) - 200; // Cuộn ngẫu nhiên từ -200px đến +200px
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + scrollValue + ")");
    }

    private void randomMouseMovement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        int offsetX = random.nextInt(10) - 5; // Dịch chuyển chuột theo trục X
        int offsetY = random.nextInt(10) - 5; // Dịch chuyển chuột theo trục Y
        actions.moveToElement(element, offsetX, offsetY).perform();
    }
}
