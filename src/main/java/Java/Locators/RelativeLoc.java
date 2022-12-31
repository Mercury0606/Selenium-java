package Java.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLoc {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.cssSelector("input[name='name']"));
        String label = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
        System.out.println(label);

        WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
        WebElement icecreamLabel = driver.findElement(with(By.xpath("//label[text()='Check me out if you Love IceCreams!']")));
        driver.findElement(with(By.className("form-check-input")).toLeftOf(icecreamLabel)).click();

        WebElement radioBtn01 = driver.findElement(By.id("inlineRadio1"));
        String label1 = driver.findElement(with(By.tagName("label")).toRightOf(radioBtn01)).getText();
        System.out.println(label1);

    }
}
