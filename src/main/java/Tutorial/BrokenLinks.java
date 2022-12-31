package Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver =new ChromeDriver();
        //Broken URL
        //Step 1 is to get all Urls tied up to the links using Selenium
        // Java methods will call URL's and gets you the status code
        //if Status code >400 then that Url is not Working -> link which tied to url is broken
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement link:links) {
            String url = link.getAttribute("href");
            HttpURLConnection urlConn = (HttpURLConnection) new URL(url).openConnection(); //We can use this way to open a connection
            urlConn.setRequestMethod("HEAD");
            urlConn.connect();
            int responseCode = urlConn.getResponseCode();
            System.out.println(link.getText()+":"+responseCode);
            if (responseCode>400){
                System.out.println(">> The link with Text\" " + link.getText() + " \"is broken with code: " + responseCode);
                softAssert.assertTrue(false);
            }
        }
        softAssert.assertAll();
    }
}

