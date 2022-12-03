package Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class End2end {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();// To select the current date

        //To check return date if Enabled
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){         //style=0.5 means disabled style=1 means abled
            System.out.println("Return date is enabled");
            Assert.assertTrue(false);

        }
        else {
            Assert.assertTrue(true);
        }
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//*[@id=\"hrefIncAdt\"]")).click();
        }
        System.out.println(driver.findElement(By.id("spanAudlt")).getText()+"Adult");        //Assert.assertEquals(actual,expected),if equal ,test will pass
        Assert.assertEquals(driver.findElement(By.id("spanAudlt")).getText()+"Adult", "4Adult");

        driver.findElement(By.id("btnclosepaxoption")).click();
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();



    }
}
