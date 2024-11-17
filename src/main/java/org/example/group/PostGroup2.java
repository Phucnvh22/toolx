package org.example.group;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class PostGroup2 {
    public static Random random = new Random();
   public void postGroup(int number) throws InterruptedException {
       // Đường dẫn đến ChromeDriver đã được cấu hình sẵn
       String chromeDriverPath = "D:\\DriverChrome\\chromedriver-win64\\chromedriver.exe";
       System.setProperty("webdriver.chrome.driver", chromeDriverPath);

       // Đường dẫn đến thư mục chứa profile Chrome
       String data = "C:\\Users\\PC\\AppData\\Local\\Google\\Chrome\\User Data\\User ";
       String userDataDir = data + number;

       // Thông tin proxy
       String proxyUsername = "fsxkjdir";
       String proxyPassword = "4ba59j79ey2d";
       String proxyHost = "142.111.48.253";
       String proxyPort = "7030";

// Cấu hình Proxy với authentication
       Proxy proxy = new Proxy();
// Định dạng: username:password@host:port
       String proxyString = String.format("%s:%s@%s:%s",
               proxyUsername,
               proxyPassword,
               proxyHost,
               proxyPort
       );
       proxy.setHttpProxy(proxyString);
       proxy.setSslProxy(proxyString);

       ChromeOptions options = new ChromeOptions();
       options.setProxy(proxy);
       options.addArguments("user-data-dir=" + userDataDir);
       options.addArguments("--no-first-run");
       options.addArguments("--no-default-browser-check");
       options.addArguments("--disable-notifications");

// Thêm extension để xử lý proxy authentication
       String encodedAuth = Base64.getEncoder().encodeToString(
               String.format("%s:%s", proxyUsername, proxyPassword).getBytes()
       );
       options.addArguments(
               "--load-extension=" + System.getProperty("user.dir") + "\\proxy_auth_extension"
       );

// Tạo manifest cho extension
       createProxyAuthExtension(proxyHost, proxyPort, proxyUsername, proxyPassword);

       WebDriver driver = new ChromeDriver(options);
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

       String url1 = "https://x.com/messages/1837197900075385035";
       String url3 = "https://x.com/messages/1797998024347586713";
       String url4 = "https://x.com/messages/1789998595812270578";
       String url5 = "https://x.com/messages/1835956315681947798";
       String url6 = "https://x.com/messages/1836435012863865017";
       String url7 = "https://x.com/messages/1757229978586894433";
       String url8 = "https://x.com/messages/1831374618092769504";
       String url9 = "https://x.com/messages/1820437601414709500";
       String url10 = "https://x.com/messages/1808163253597393037";
       String url11 = "https://x.com/messages/1689384925802172416";
       String url12 = "https://x.com/messages/1731398862424953026";
       String url13 = "https://x.com/messages/1818289107459867023";
       String url14 = "https://x.com/messages/1810231002234855464";
       String url15 = "https://x.com/messages/1785263439348470124";
       String url16 = "https://x.com/messages/1837098187380728248";
       String url17 = "https://x.com/messages/1804040855952789622";
       String url18 = "https://x.com/messages/1808978270932848711";
       String url19 = "https://x.com/messages/1795801717927301390";
       String url20 = "https://x.com/messages/1818654490373005498";
       String url21 = "https://x.com/messages/1798530795159855605";
       String url22 = "https://x.com/messages/1799345000318152806";
       String url23 = "https://x.com/messages/1738472636231930357";
       String url24 = "https://x.com/messages/1769372244961026427";
       String url25 = "https://x.com/messages/1756885758479102272";
       String url26 = "https://x.com/messages/1815851882788839792";
       String url27 = "https://x.com/messages/1827441385802494432";
       String url28 = "https://x.com/messages/1778372824874230083";
       String url29 = "https://x.com/messages/1809827634731483254";
       String url30 = "https://x.com/messages/1808597500409823241";
       String url31 = "https://x.com/messages/1808978270932848711";
       String url32 = "https://x.com/messages/1839585025798422725";
       String url33 = "https://x.com/messages/1792566273320067212";
       String url34 = "https://x.com/messages/1825789751774896423";
       String url35 = "https://x.com/messages/1791573605676982447";
       String url36 = "https://x.com/messages/1782422287951810733";
       String url37 = "https://x.com/messages/1797762908321132831";

       Set<String> urlList = new HashSet<>();
       urlList.add(url1);
       urlList.add(url3);
       urlList.add(url4);
       urlList.add(url5);
       urlList.add(url6);
       urlList.add(url7);
       urlList.add(url8);
       urlList.add(url9);
       urlList.add(url10);
       urlList.add(url11);
       urlList.add(url12);
       urlList.add(url13);
       urlList.add(url14);
       urlList.add(url15);
       urlList.add(url16);
       urlList.add(url17);
       urlList.add(url18);
       urlList.add(url19);
       urlList.add(url20);
       urlList.add(url21);
       urlList.add(url22);
       urlList.add(url23);
       urlList.add(url24);
       urlList.add(url25);
       urlList.add(url26);
       urlList.add(url27);
       urlList.add(url28);
       urlList.add(url29);
       urlList.add(url30);
       urlList.add(url31);
       urlList.add(url32);
       urlList.add(url33);
       urlList.add(url34);
       urlList.add(url35);
       urlList.add(url36);
       urlList.add(url37);

       try {
           for (String link : urlList) {
               // Điều hướng đến trang tin nhắn cụ thể
               driver.get(link);
               wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

               String[] messages = {
                       "✨HIT CLIENT NOT ME ✨\u2028",
                       "@CHICAMAPAT",
                       "@CHICAMAPAT",
                       "✨ADD TO 200K+ GRPS PLS✨",
                       "✨ QUEEN ✨"
               };
                String mess1 = "✨HIT CLIENT NOT ME ✨\u2028";
                String mess2 = "@CHICAMAPAT";
                String mess3 = "@CHICAMAPAT";
                String mess4 = "✨ADD TO 200K+ GRPS PLS✨";
                String mess5 = "✨ QUEEN ✨";
               List<String> messageList = new ArrayList<>();
               messageList.add(mess1);
               messageList.add(mess2);
               messageList.add(mess3);
               messageList.add(mess4);
               messageList.add(mess5);



               WebElement chatInput = wait.until(ExpectedConditions.elementToBeClickable(
                       By.cssSelector(".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr")));
               chatInput.click();

               Actions actions = new Actions(driver);
               for (String message : messageList) {
                   chatInput.sendKeys(message);
                   actions.keyDown(Keys.SHIFT)
                           .sendKeys(Keys.ENTER)
                           .keyUp(Keys.SHIFT)
                           .perform();
               }
               chatInput.sendKeys(Keys.ENTER);
               Thread.sleep(randomDelay()); // Tạm dừng sau khi gửi


               System.out.println("Tin nhắn đã được gửi thành công!");

               // Cuộn trang ngẫu nhiên trước khi chuyển URL
               ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -300)");
               randomDelay();

           }
       }catch (Exception e) {
           System.out.println("Đã xảy ra lỗi: " + e.getMessage());
           e.printStackTrace();
       }
       finally {

//             driver.quit();
       }
   }

    private static void createProxyAuthExtension(String host, String port, String username, String password) {
        String manifestJson = """
            {
                "version": "1.0.0",
                "manifest_version": 2,
                "name": "Proxy Auth",
                "permissions": [
                    "proxy",
                    "tabs",
                    "webRequest",
                    "webRequestBlocking",
                    "<all_urls>"
                ],
                "background": {
                    "scripts": ["background.js"]
                }
            }
        """;

        String backgroundJs = String.format("""
            var config = {
                mode: "fixed_servers",
                rules: {
                    singleProxy: {
                        scheme: "http",
                        host: "%s",
                        port: %s
                    }
                }
            };
            chrome.proxy.settings.set({value: config, scope: "regular"}, function() {});
            function callbackFn(details) {
                return {
                    authCredentials: {
                        username: "%s",
                        password: "%s"
                    }
                };
            }
            chrome.webRequest.onAuthRequired.addListener(
                callbackFn,
                {urls: ["<all_urls>"]},
                ['blocking']
            );
        """, host, port, username, password);

        try {
            // Tạo thư mục extension
            File extensionDir = new File("proxy_auth_extension");
            extensionDir.mkdirs();

            // Tạo manifest.json
            FileWriter manifestWriter = new FileWriter(new File(extensionDir, "manifest.json"));
            manifestWriter.write(manifestJson);
            manifestWriter.close();

            // Tạo background.js
            FileWriter backgroundWriter = new FileWriter(new File(extensionDir, "background.js"));
            backgroundWriter.write(backgroundJs);
            backgroundWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long randomDelay() throws InterruptedException {
        int delay = random.nextInt(2000) +1000; // Tạo thời gian trễ từ 1-3 giây
        Thread.sleep(delay);
        return 0;
    }

    private static void typeLikeHuman(WebElement element, String text) throws InterruptedException {
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            Thread.sleep(random.nextInt(300) + 100); // Thời gian trễ giữa mỗi ký tự
        }
    }
}
