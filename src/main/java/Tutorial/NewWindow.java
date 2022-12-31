package Tutorial;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException {
        WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        List<WebElement> elements = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
        String theFirstCourse = elements.get(1).getText();
        driver.switchTo().window(parentWindow);
        WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(theFirstCourse);
        File screenshot = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("/Users/ts-chongyuan.zhong/DeskTop/ChroScreenSchots/screenshotForName.png"));
        //how to take partial screenshot

    }
}
