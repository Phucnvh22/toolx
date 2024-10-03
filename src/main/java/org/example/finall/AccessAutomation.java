package org.example.finall;

import org.example.demo.User;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccessAutomation {
    public synchronized void shareMetheo(List<String> url, int x, int y, User user) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().setPosition(new Point(x, y));

        try {
            driver.get("https://x.com/i/flow/login");

            // Quy trình đăng nhập
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("text"))).sendKeys(user.getUsername() + Keys.ENTER);

            // Nhập email nếu có yêu cầu từ hệ thống
            try {
                WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
                emailField.sendKeys(user.getEmail() + Keys.RETURN);
            } catch (Exception e) {
                System.out.println("No email verification step required.");
            }

            // Nhập mật khẩu
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys(user.getPassword() + Keys.ENTER);
            Thread.sleep(10000); // Thời gian chờ để trang tải

            for (String postUrl : url) {
                driver.get(postUrl);
                Thread.sleep(2000); // Thời gian chờ để trang tải
                System.out.println(url);

                // Thực hiện các hành động trên bài đăng
                clickElement(wait, driver, By.cssSelector("[data-testid='like']"));
                clickElement(wait, driver, By.cssSelector("[data-testid='retweet']"));
                clickElement(wait, driver, By.xpath("//*[contains(text(), 'Đăng lại')]"));

            }
            // Điều hướng đến URL quảng cáo

            System.out.println("All actions completed successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt sau khi thực hiện (bỏ chú thích nếu muốn)
            // driver.quit();
        }
    }

    // Hàm click vào phần tử sau khi cuộn tới nó
    public void clickElement(WebDriverWait wait, WebDriver driver, By by) {
        try {
            // Chờ phần tử có mặt trong DOM
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

            // Cuộn tới phần tử
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Thêm thời gian chờ để đảm bảo phần tử có thể được click
            Thread.sleep(500); // Thời gian chờ có thể điều chỉnh

            // Chờ phần tử có thể click và click vào nó
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            System.out.println("Không thể click vào phần tử: " + by.toString());
            e.printStackTrace();
        }
    }
}
