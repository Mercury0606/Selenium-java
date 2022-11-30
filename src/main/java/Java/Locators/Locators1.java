package Java.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators1 {
    public static void main(String[] args) throws InterruptedException {
//        implicit wait - 2seconds time out
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("asddyga001");
        driver.findElement(By.name("inputPassword")).sendKeys("i547m4");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());          //CSS Selector -> tagname.classname
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);//let the page slide fully can be replaced by explicitWait()

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("341@dasda.com");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();//clear the text box
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("2341234123");
        driver.findElement(By.xpath("//form/input[3]")).click();//click on phone number text box

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.xpath("//form/p")).getText());
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        Thread.sleep(1000);//let the page slide fully can be replaced by explicitWait()

        //Go back to the left page and send password to the password key box
        //'*' after "type" means contains
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxTwo")).click();

        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        driver.close();

    }
}
