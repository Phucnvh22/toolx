package org.example.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

public class AutoPost implements Runnable {
    private User user;
    private int x;
    private int y;

    public AutoPost(User user, int x, int y) {
        this.user = user;
        this.x = x;
        this.y = y;
    }

    public synchronized String AutomationPostX(User user, int x, int y) {
        Random random = new Random();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().setPosition(new Point(x, y));
        // Đặt kích thước cho cửa sổ
        String linkShare = "";

        try {
            driver.get("https://x.com/i/flow/login");

            // Login process
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("text"))).sendKeys(user.getUsername() + Keys.ENTER);

            // Input email if had request from system
            try {
                WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
                emailField.sendKeys(user.getEmail() + Keys.RETURN);

            } catch (Exception e) {
                System.out.println("No email verification step required.");
            }
            // Input password
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys(user.getPassword() + Keys.ENTER);
            Thread.sleep(3000);

            // Go to url ads
            driver.get(user.getUrl());

            // Wait for page to fully load after the click
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
            Thread.sleep(1000);
            // Press the ESC key to turn off report!
            new Actions(driver).sendKeys(Keys.ESCAPE).perform();

            // Click "Single media" element
            By singleFileElement = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/span[2]");
            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", singleFileElement);
            wait.until(ExpectedConditions.elementToBeClickable(singleFileElement)).click();

            // Click "sigle" button
            By addMedia = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[8]/button[1]/span[1]");
            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addMedia);
            wait.until(ExpectedConditions.elementToBeClickable(addMedia)).click();

            // Get file from computer
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
            int video = random.nextInt(4);
            String filePath = "C:\\Users\\ACER\\Downloads\\" + (video +1) +".mp4"; // Thay đổi đường dẫn này
            System.out.println("đã chọn ảnh số" +(video + 1));
            fileInput.sendKeys(filePath);

            // Click back button
            WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

            WebElement divElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style, 'blob:')]")));
            //Thread.sleep(15000);
            // Select Website
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/button[1]"))).click();
            WebElement websiteOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]//button[text()='Website']")));
            websiteOption.click();

            // Input sub
            WebElement sub = driver.findElement(By.cssSelector(".TweetTextInput-editor.is-empty"));

            int a = random.nextInt(90000) + 1000;
            sub.sendKeys("Episode " + a);

            // Input headline
            WebElement untitled = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")));
            untitled.sendKeys("XXX 18+");

            // Input link
            WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='https://']")));
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
            link.sendKeys("http://buzoz.samsunglaga.com/Aphuc/PhucV.php");


            // CLick post button
            WebElement post = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", post);

            // Lưu lại handle của tab hiện tại
            String originalTab = driver.getWindowHandle();


            // Click tweet view
            WebElement tweet = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='View Tweet']")));
            tweet.click();

            // Chờ cho đến khi tab mới xuất hiện
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            // Lấy tất cả các handle của các tab đang mở
            Set<String> allTabs = driver.getWindowHandles();

            // Chuyển qua tab mới
            for (String tab : allTabs) {
                if (!tab.equals(originalTab)) {
                    driver.switchTo().window(tab);
                    break;
                }
            }

            linkShare = driver.getCurrentUrl();
            System.out.println(linkShare);


            System.out.println("All actions completed successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Uncomment the next line if you want to close the browser after execution
            // driver.quit();
        }
        return linkShare;
    }

    public void shareMetheo(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().setPosition(new Point(x, y));

        try {
            driver.get("https://x.com/i/flow/login");

            // Quy trình đăng nhập
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("text"))).sendKeys("songplatform_" + Keys.ENTER);

            // Nhập email nếu có yêu cầu từ hệ thống
            try {
                WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
                emailField.sendKeys("nguyenthi121333@gmail.com" + Keys.RETURN);
            } catch (Exception e) {
                System.out.println("No email verification step required.");
            }

            // Nhập mật khẩu
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Pppp6868@" + Keys.ENTER);
            Thread.sleep(2000); // Thời gian chờ để trang tải

            // Điều hướng đến URL quảng cáo
            driver.get(url);
            Thread.sleep(2000); // Thời gian chờ để trang tải
            System.out.println(url);

            // Thực hiện các hành động trên bài đăng
            clickElement(wait, driver, By.cssSelector("[data-testid='like']"));
            clickElement(wait, driver, By.cssSelector("[data-testid='retweet']"));
            clickElement(wait, driver, By.xpath("//*[contains(text(), 'Đăng lại')]"));

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


    @Override
    public void run() {

        String url = AutomationPostX(user, x, y);
        System.out.println(url);
        shareMetheo(url);
    }
}

