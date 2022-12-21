package Tutorial;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;


public class Miscelleanous {
    public static void main(String[] args) throws IOException {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().minimize();
        driver.manage().deleteAllCookies();
//        driver.manage().deleteCookieNamed("sessionKey");
        //click on any link
            //login page: verigy login url
        driver.get("http://google.com");


        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("/Users/ts-chongyuan.zhong/DeskTop/ChroScreenSchots/screenshot.png"));

    }
}
