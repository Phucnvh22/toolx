package org.example.finall;

import org.example.demo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LikeAndShare {

    private WebDriver driver;
    private WebDriverWait wait;

    public LikeAndShare() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(User user) throws InterruptedException {
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
    }

    public void likeAndSharePosts(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='tweet']")));

        List<WebElement> tweets = driver.findElements(By.cssSelector("[data-testid='tweet']"));
        int interactionCount = 0;

        for (WebElement tweet : tweets) {
            if (interactionCount >= 3) break;

            try {
                // Like the tweet
                WebElement likeButton = tweet.findElement(By.cssSelector("[data-testid='like']"));
                if (likeButton != null && likeButton.isDisplayed()) {
                    likeButton.click();
                    System.out.println("Liked tweet " + (interactionCount + 1));
                }

                // Share (Retweet) the tweet
                WebElement retweetButton = tweet.findElement(By.cssSelector("[data-testid='retweet']"));
                if (retweetButton != null && retweetButton.isDisplayed()) {
                    retweetButton.click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Retweet')]"))).click();
                    System.out.println("Retweeted tweet " + (interactionCount + 1));
                }

                interactionCount++;
            } catch (Exception e) {
                System.out.println("Failed to interact with tweet " + (interactionCount + 1) + ": " + e.getMessage());
            }
        }
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        LikeAndShare bot = new LikeAndShare();
        try {
            User user1 = new User("EvitaMock37227", "iN5KtUOoyd0g", "31!fj5-h--03m!o64-6rq@mailforspam.com", "https://ads.x.com/composer/18ce55lys3q/carousel");
            bot.login(user1);
            bot.likeAndSharePosts("https://x.com/kiensam2103");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //bot.close();
        }
    }
}