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

public class AutoPost extends Test{
    public List<String> autoPost(String number, User user) {
        Random random = new Random();
        String linkShare = "";
        List<String> urlList = new ArrayList<>();
        WebDriver driver = null;
        try {
            String chromeDriverPath = "C:\\Users\\ACER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            String data = "C:\\Users\\ACER\\AppData\\Local\\Google\\Chrome\\User Data\\User ";
            String userDataDir = data + number;

            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=" + userDataDir);
            options.addArguments("--no-first-run");
            options.addArguments("--no-default-browser-check");
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            for (int i = 0; i < 2; i++) {
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
                int video = random.nextInt(4);
                String filePath = "C:\\Users\\ACER\\Downloads\\" + (video + 1) + ".mp4";
                System.out.println("Đã chọn ảnh số " + (video + 1));
                fileInput.sendKeys(filePath);
                randomDelay();

                WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                randomDelay();


                WebElement divElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style, 'blob:')]")));

                randomDelay();


                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/button[1]"))).click();
                WebElement websiteOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]//button[text()='Website']")));
                websiteOption.click();
                randomDelay();


                WebElement sub = driver.findElement(By.cssSelector(".TweetTextInput-editor.is-empty"));
                int a = random.nextInt(90000) + 1000;
                sub.sendKeys("Part " + a);

                randomDelay();


                WebElement untitled = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")));
                Test.typeHumanLikeWithMistakes(untitled,"Click to watch full video!");

                randomDelay();


                WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='https://']")));
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                Test.typeHumanLikeWithMistakes(link, "adadadadadadadadad.com");

                randomDelay();


                WebElement post = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", post);

                String originalTab = driver.getWindowHandle();

                randomDelay();


                WebElement tweet = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='View Tweet']")));
                tweet.click();

                wait.until(ExpectedConditions.numberOfWindowsToBe(2));

                Set<String> allTabs = driver.getWindowHandles();

                for (String tab : allTabs) {
                    if (!tab.equals(originalTab)) {
                        driver.switchTo().window(tab);
                        break;
                    }
                }
                Thread.sleep(5000);

                linkShare = driver.getCurrentUrl();
                System.out.println("URL obtained: " + linkShare);
                urlList.add(linkShare);

                driver.close();
                driver.switchTo().window(originalTab);
            }
            System.out.println("Final URL list: " + urlList);
            System.out.println("All actions completed successfully.");
        }
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (driver != null) {
                //driver.quit();
                System.out.println("WebDriver closed.");
            }
        }
        return urlList;
    }
}