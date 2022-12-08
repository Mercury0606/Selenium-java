package Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class base {
    public static void main(String[] args) {
        //expected array
        String[] veggies={"Cucumber","Brocolli"};
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        //Convert Array to Arraylist for easy search
        List itemNeededList = Arrays.asList(veggies);
        //Check whether name you extracted is present in arrayList or not
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            //format it to get actual vegetable name
            //comvert array into array list for easy search
            //check whether nmae you extracted is present in arrayList or not

            if (itemNeededList.contains(name)){
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
            }
        }
    }
}
