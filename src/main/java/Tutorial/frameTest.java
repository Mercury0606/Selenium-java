package Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        System.out.println(">> "+driver.findElements(By.tagName("iframe")).size()+" frames found in the web site");


        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        source.click();
//        actions.dragAndDropBy(source,160,16).build().perform();
        actions.dragAndDrop(source, target).build().perform();
        
    }
}
