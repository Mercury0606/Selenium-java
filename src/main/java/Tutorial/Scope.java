package Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
//        Give me the count of links on the page.
//        tag <a> for anchor is a link
//        count for the
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(">> "+driver.findElements(By.tagName("a")).size()+" tags found");

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));         // search for <a> only in the footer area.
        System.out.println(footerDriver.findElements(By.tagName("a")).size());// footer as a WebElement can use the methods of drivers.
//      3-
        WebElement colomnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(colomnDriver.findElements(By.tagName("a")).size());

//       4- click on each link in the colomn and check if the pages are not opening-
        for (int i = 0; i < colomnDriver.findElements(By.tagName("a")).size(); i++) {

            String clickonlinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
            colomnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);

        }
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            driver.switchTo().window( iterator.next());
            System.out.println(">> "+driver.getTitle());
        }


//        driver.close();
    }
}
