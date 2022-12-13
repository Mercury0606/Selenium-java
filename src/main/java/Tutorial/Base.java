package Tutorial;

import org.checkerframework.checker.units.qual.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {
    public static void main(String[] args) throws InterruptedException {

        //expected array
        String[] itemNeeded={"Cucumber" ,"Brocolli"};
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        Or you can use
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Declair the Explicit Wait Globally
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        addItem(driver, itemNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //Explicit Wait
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
//        System.out.println(">> "+driver.findElement(By.cssSelector("promoInfo")).getText());
//        driver.findElement(By.cssSelector("promoInfo")).getText().equals("Code applied ..!");

//        driver.findElement(By.);
    }



    public static void addItem(WebDriver driver,String[] itemNeeded){
        //Convert Array to Arraylist for easy search
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j=0;
        List itemNeededList = Arrays.asList(itemNeeded);
        //Check whether name you extracted is present in arrayList or not


        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            //name[0]-Broccoli
            //format it to get actual vegetable name
            //convert array into array list for easy search
            //check whether name you extracted is present in arrayList or not

            if (itemNeededList.contains(formattedName)){
                driver.findElements(By.xpath("//div[@class='product-action']/button" )).get(i).click();
//                Thread.sleep(5000);
                System.out.println("item " + i + " is selected");
                j++;
                if (j==itemNeededList.size()) break;
                // Once found veggie ,break
            }
        }

    }
}
