package org.example.Tho;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Test {
    private static final Random random = new Random();
    private static WebDriver driver;
    private static JavascriptExecutor js;
    private static Actions actions;

    public static void main(String[] args) {
        String chromeDriverPath = "C:\\Users\\ACER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        String userDataDir = "C:\\Users\\ACER\\AppData\\Local\\Google\\Chrome\\User Data\\User 6";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userDataDir);
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.x.com");

        // Simulate random scrolling
 //       randomScroll();

//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
//        typeHumanLikeWithMistakes(element, "professional2211@gmail.com");
//        WebElement elementPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
//        elementPassword.sendKeys("Pppp6868" + Keys.ENTER);


        // More random scrolling after typing
//        randomScroll();


  //      randomMouseMovements();
    //    randomMouseMovements();


    }

    public static void typeHumanLikeWithMistakes(WebElement element, String text) {
        StringBuilder currentText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (random.nextInt(5) == 0) { // 10% chance to make a mistake
                char wrongChar = getRandomChar();
                element.sendKeys(String.valueOf(wrongChar));
                currentText.append(wrongChar);
                randomDelay();

                // Delete the wrong character
                element.sendKeys(Keys.BACK_SPACE);
                currentText.setLength(currentText.length() - 1);
                randomDelay();
            }

            element.sendKeys(String.valueOf(c));
            currentText.append(c);
            randomDelay();
        }
    }

    public static void randomDelay() {
        try {
            Thread.sleep(50 + random.nextInt(150)); // Random delay between 50-200ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static char getRandomChar() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return chars.charAt(random.nextInt(chars.length()));
    }

    public static void randomScroll() {
        for (int i = 0; i < random.nextInt(5) + 1; i++) { // 1 to 5 random scrolls
            int scrollAmount = random.nextInt(1000) - 250; // Random scroll between -250 and 250 pixels
            js.executeScript("window.scrollBy(0, " + scrollAmount + ")");
            randomDelay();
        }
    }

    private static void randomMouseMovements() {
        int numMovements = random.nextInt(5) + 3; // 3 to 7 random movements
        Dimension size = driver.manage().window().getSize();
        int maxWidth = size.getWidth();  // Full width of the window
        int maxHeight = size.getHeight();  // Full height of the window

        // Start from the center of the window
        int currentX = maxWidth / 2;
        int currentY = maxHeight / 2;

        for (int i = 0; i < numMovements; i++) {
            // Generate random movements
            int moveX = random.nextInt(200) - 100;  // Move between -100 and 100 pixels horizontally
            int moveY = random.nextInt(200) - 100;  // Move between -100 and 100 pixels vertically

            // Calculate new positions ensuring they stay within window bounds
            currentX = Math.max(0, Math.min(maxWidth - 1, currentX + moveX));
            currentY = Math.max(0, Math.min(maxHeight - 1, currentY + moveY));

            // Move the mouse to the new position
            actions.moveToElement(driver.findElement(By.tagName("body")), currentX, currentY).perform();
            randomDelay();

            // Sometimes perform a click
            if (random.nextInt(5) == 0) { // 20% chance to click
                actions.click().perform();
                randomDelay();
            }
        }
    }


}
