package Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        //Broken URL
        //Step 1 is to get all Urls tied up to the links using Selenium
        // Java methods will call URL's and gets you the status code
        //if Status code >400 then that Url is not Working -> link which tied to url is broken
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String link = driver.findElement(By.cssSelector("a[href*='soupui']")).getAttribute("href");


    }
}
