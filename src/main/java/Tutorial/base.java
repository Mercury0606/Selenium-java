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
    public static void main(String[] args) throws InterruptedException {
        //expected array
        String[] veggies={"Cucumber" ,"Brocolli"};
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j=0;
        //Convert Array to Arraylist for easy search
        List itemNeededList = Arrays.asList(veggies);
        //Check whether name you extracted is present in arrayList or not


        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            //name[0]-Brocolli
            //format it to get actual vegetable name
            //comvert array into array list for easy search
            //check whether nmae you extracted is present in arrayList or not

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
