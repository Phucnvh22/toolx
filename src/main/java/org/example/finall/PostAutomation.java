package org.example.finall;

import org.example.demo.User;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

public class PostAutomation {
    private User user;
    private int x;
    private int y;

    public PostAutomation(User user, int x, int y) {
        this.user = user;
        this.x = x;
        this.y = y;
    }
    public static String AutomationPostX(User user, int x, int y) {
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
            sub.sendKeys("Part " + a);

            // Input headline
            WebElement untitled = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")));
            untitled.sendKeys("Click here to watch full video!!");

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
}
