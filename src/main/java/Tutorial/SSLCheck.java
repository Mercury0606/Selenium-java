package Tutorial;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;

import java.util.HashMap;

public class SSLCheck {
    public static void main(String[] args) {
        ChromeOptions options =new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
       options.setCapability("proxy", proxy);
        options.setAcceptInsecureCerts(true);//Telling my Chrome whenever you come across these kind of certifications, accept connection certifitions
//        options.addExtensions("");
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory","/Users/ts-chongyuan.zhong/Documents");

        WebDriver driver =new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
