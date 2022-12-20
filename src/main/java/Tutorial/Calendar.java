package Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.path2usa.com/travel-companion/");
        //April 14
        driver.findElement(By.className("flatpickr-next-month")).click();

        List<WebElement> dates = driver.findElements(By.className("flatpickr-day "));
        for (int i = 0; i < dates.size(); i++) {
            boolean assertion=dates.get(i).getText().equals(25);
            if (assertion){
                System.out.println(">> Click on 25 ");
                dates.get(i).click();
                break;
            }
        }
        driver.close();


    }
}
