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
            String chromeDriverPath = "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            String data = "C:\\Users\\Admin\\AppData\\Local\\Google\\Chrome\\User Data\\Profile ";
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
                int video = random.nextInt(9);
                String filePath = "C:\\Users\\Admin\\Downloads\\RDCMan\\p\\" +(video+1) + ".mp4";
                System.out.println("Đã chọn video số " + (video + 1));
                fileInput.sendKeys(filePath);
                randomDelay();
                Thread.sleep(10000);

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
                int a = random.nextInt(9000) + 1000;
                sub.sendKeys("Episode  " + a);

                randomDelay();


                WebElement untitled = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")));
                Test.typeHumanLikeWithMistakes(untitled,"xxx");

                randomDelay();

                WebElement checkbox1 = driver.findElement(By.cssSelector("span[data-test-id='promotedOnlyCheckbox']"));
                checkbox1.click();

                randomDelay();


                WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='https://']")));
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                Test.typeHumanLikeWithMistakes(link, "https://masaribananaae.blogspot.com");

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

                //driver.close();
                driver.switchTo().window(originalTab);

            }
            driver.get(user.getUrl());

            randomDelay();
            new Actions(driver).sendKeys(Keys.ESCAPE).perform();

            randomDelay();

            By singleFileElement1 = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/span[2]");
            wait.until(ExpectedConditions.elementToBeClickable(singleFileElement1)).click();

            randomDelay();


            By addMedia1 = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[8]/button[1]/span[1]");
            wait.until(ExpectedConditions.elementToBeClickable(addMedia1)).click();
            randomDelay();


            WebElement fileInput1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
            int video1 = random.nextInt(9);
            String filePath1 = "C:\\Users\\Admin\\Downloads\\configschange\\p a\\" +(video1+1) + ".png";
            System.out.println("Đã chọn video số " + (video1 + 1));
            fileInput1.sendKeys(filePath1);
            randomDelay();

            Thread.sleep(5000);
            WebElement element1 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
            randomDelay();




            //WebElement divElement1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style, 'blob:')]")));

            randomDelay();


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/button[1]"))).click();
            WebElement websiteOption1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]//button[text()='Website']")));
            websiteOption1.click();
            randomDelay();


            WebElement sub1 = driver.findElement(By.cssSelector(".TweetTextInput-editor.is-empty"));
            int a1 = random.nextInt(9000) + 1000;
            sub1.sendKeys("Episode  " + a1);

            randomDelay();


            WebElement untitled1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")));
            Test.typeHumanLikeWithMistakes(untitled1,"xxx");

            randomDelay();


            WebElement link1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='https://']")));
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
            Test.typeHumanLikeWithMistakes(link1, "https://sawanicatiis15ssaea.blogspot.com/");

            randomDelay();

            WebElement checkbox = driver.findElement(By.cssSelector("span[data-test-id='promotedOnlyCheckbox']"));
            checkbox.click();

            randomDelay();


            WebElement post1 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", post1);

            String originalTab1 = driver.getWindowHandle();

            randomDelay();


            WebElement tweet1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='View Tweet']")));
            tweet1.click();

            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            String originalTab2 = driver.getWindowHandle();

            Set<String> allTabs1 = driver.getWindowHandles();

            for (String tab : allTabs1) {
                if (!tab.equals(originalTab2)) {
                    driver.switchTo().window(tab);
                    break;
                }
            }
            Thread.sleep(5000);

            linkShare = driver.getCurrentUrl();
            System.out.println("URL obtained: " + linkShare);
            urlList.add(linkShare);

            //driver.close();
            driver.switchTo().window(originalTab2);
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