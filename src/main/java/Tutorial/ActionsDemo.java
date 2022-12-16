package Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement move =driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        actions.moveToElement(move)
                .contextClick() //right click
                .build()       //build means the process is ready
                .perform();   // perform means to do
        actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
                .click()
                .keyDown(Keys.SHIFT)    // press and hold  shift button
                .sendKeys("qwerTYUIO") // result: QWERTYUIO
                .doubleClick()        // Select the Word
                .build()
                .perform();
    }
}
