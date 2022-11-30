package Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().fullscreen();// Open the window in fullscreen mode
        driver.manage().window().maximize();// Maximize the screen
        driver.get("http://www.google.com");
        driver.navigate().to("http://rahulshettyacademy.com");
        driver.navigate().back();
        driver.navigate().forward();

    }
}
