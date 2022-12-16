package Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector("a.blinkingText")).click();
        Set<String> windowHandles = driver.getWindowHandles();//[parent id,child id]
        Iterator<String> iterator = windowHandles.iterator();
        String  parentId =  iterator.next();
        String  childId =  iterator.next();
        driver.switchTo().window(childId);
        String emailAddress =driver.findElement(By.cssSelector("p.im-para.red strong")).getText();
        System.out.println(">> "+emailAddress);

        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailAddress);


    }
}
