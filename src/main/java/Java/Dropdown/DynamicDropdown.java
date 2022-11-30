package Java.Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

/**
 * Dynamic dropdowns are loaded based upon user's option45
 */
public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        //One specific element in the dynamic Dropdown won't be found until the dropdown is selected
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();//click on  'FROM' dropdown
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

/**
 * Two elements can be found as //a[@value='MAA']
 * Selenium will automatically go to the TOP LEFT one
 * so we need to use
 * (//a[@value='MAA'])[2]
 */
        Thread.sleep(2000L);
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

//        Parent and child xpath
//        div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();// To select the current date



    }
}
