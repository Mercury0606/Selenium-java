package Java.Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
//TestNG is a testing framework

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");

//        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertFalse( driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());//Pass only return false,expecting false
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());//Pass only return true
//        Count the number of all the Checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("There are "+checkboxes.size()+" checkboxes");


        driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).click();
        Thread.sleep(2000L);

        System.out.println(driver.findElement(By.id("spanAudlt")).getText()+"Adult");

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//*[@id=\"hrefIncAdt\"]")).click();
        }
        System.out.println(driver.findElement(By.id("spanAudlt")).getText()+"Adult");        //Assert.assertEquals(actual,expected),if equal ,test will pass
        Assert.assertEquals(driver.findElement(By.id("spanAudlt")).getText()+"Adult", "4Adult");

        driver.findElement(By.id("btnclosepaxoption")).click();


        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        //To check return date if Enabled
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            System.out.println("Return date is enabled");
            Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
        }
        else {
            Assert.assertTrue(false);
        }


    }
}
