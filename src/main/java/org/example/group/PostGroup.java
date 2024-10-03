package org.example.group;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.io.File;

public class PostGroup {
    public static void main(String[] args) throws InterruptedException {
        // Đường dẫn đến ChromeDriver đã được cấu hình sẵn
        String chromeDriverPath = "C:\\Users\\ACER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        // Đường dẫn đến thư mục chứa profile Chrome
        String userDataDir = "C:\\Users\\ACER\\AppData\\Local\\Google\\Chrome\\User Data\\User 4";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userDataDir);
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            // Điều hướng đến trang tin nhắn cụ thể
            driver.get("https://x.com/messages/1809827634731483254");
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

            String message = "\uD83E\uDD8AHIT MY CLIENT\uD83E\uDD8A\n" +
                    "   ——I NEVER SKIP——\n" +
                    "@alicekemone\n" +
                    "\n" +
                    "@alicekemone\n" +
                    "\n" +
                    "@alicekemone\n" +
                    "\n" +
                    "\n" +
                    "\uD83D\uDCA5DONT HIT ME\uD83D\uDCA5\n" +
                    " add me to other ISO  50ᴋ-100k ﹢ ɢʀᴏᴜᴘs \uD83D\uDE4F";

            // dc rồi k đổi nữa nhé
            WebElement chatInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("div[data-testid='dmComposerTextInput']")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].innerText = arguments[1];", chatInput, message);


            WebElement gifElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[2]/div/div/aside/div[2]/div[1]/button[2]/div")));
            gifElement.click();




            System.out.println("Tin nhắn đã được gửi thành công!");

        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {
//             Thread.sleep(5000);
//             driver.quit();
        }
    }

    private static boolean isLoggedIn(WebDriver driver) {
        try {
            driver.findElement(By.cssSelector("a[data-testid='AppTabBar_Profile_Link']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}