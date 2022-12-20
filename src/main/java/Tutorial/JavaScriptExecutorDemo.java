package Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");//scroll the page
        Thread.sleep(3000);

        js.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0,500)");
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop");
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");

        List<WebElement> values = driver.findElements(By.cssSelector("div.tableFixHead td:nth-child(4)"));
       int sum=0;
        for (int i = 0; i < values.size(); i++) {
           sum+=Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        String countText = driver.findElement(By.cssSelector(".totalAmount")).getText();
        String[] split = countText.split(":");
        int count = Integer.parseInt(split[1].trim());
        System.out.println(count);
    }

}
