package Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelDriver {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

            driver.get("http://www.baidu.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}
