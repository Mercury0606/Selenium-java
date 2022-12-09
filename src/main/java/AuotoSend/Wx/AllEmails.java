package AuotoSend.Wx;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Scanner;

public class AllEmails {
    public static void main(String[] args) throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Emails emails = new Emails(2);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://wx.mail.qq.com/home/index?sid=zLZqQoxgV0Iu6W1yAP9PbQAA#/compose/new");
        if (emails.confirmation()==true){
            for (int i = 0; i < emails.EmailCount; i++) {
                Thread.sleep(500);
                emails.sendEmails(driver, i);

            }

        }
        driver.get("https://mail.sohu.com/fe/#/login");//update
        driver.findElement(By.xpath("//input[@placeholder='请输入您的邮箱']")).sendKeys("merc0606@");
        driver.findElement(By.xpath("//input[@placeholder='请输入您的邮箱']")).sendKeys(Keys.RETURN); //press return
        driver.findElement(By.xpath("//input[@placeholder='请输入您的密码']")).sendKeys("A123456.");
        driver.findElement(By.xpath("//input[@type='submit']")).click();  //click on the log-in butotn
        Thread.sleep(3000);
//        if (driver.findElement(By.xpath("///li[contains(@ui-sref,'unread')]")).isEnabled()) {
//        }
//        else {
//            System.out.println(">> Failed to log in.");
//            Assert.assertTrue(false);
//
//        }

            driver.findElement(By.xpath("//li[@ui-sref='unread']")).click();


        System.out.println(">> Handle of this Window: " + driver.getWindowHandle());
//        driver.switchTo().window(driver.getWindowHandle());
            emails.ReadAll(driver);


    }

}











class Emails{

    int EmailCount= 5; //How many Emails I want to send

    public Emails( int emailCount) {

        EmailCount = emailCount;
    }

    public boolean confirmation() throws InterruptedException {
        System.out.println(">> Please scan the QR code,\n>> and input 'Confirm' after you finished");
        Scanner scanner = new Scanner(System.in);
        String Text = scanner.nextLine();
        String confirmText = "Confirm";
        if (Text.equals(confirmText)){
//            for (int i = 0; i < EmailCount; i++) {
//                this.sendEmails(driver,i);
//            }
            System.out.println(">> Successfully logged in");
            return true;
        }
        else {
            System.out.println(">> Failed to log in");
        }
        return false;
    }
    public void sendEmails(WebDriver driver,Integer integer) throws InterruptedException{
//        Thread.sleep(1000);
        //driver.switchTo().frame("//*[@id=\\\"mailMainApp\\\"]/div[2]/div/div[1]/div/ul/li[1]/a");//switch iframe

        driver.findElement(By.className("sidebar_nav_item_link")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//*[@id=\"mailMainApp\"]/div[3]/div/div/div[1]/div[1]/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr/td/div[1]/input")).sendKeys("merc0606@sohu.com"); //input reciepient's Email
        driver.findElement(By.xpath("//*[@id=\"mailMainApp\"]/div[3]/div/div/div[1]/div[1]/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr/td/div[1]/input")).sendKeys(Keys.RETURN);
        driver.findElement(By.xpath("//*[@id=\"mailMainApp\"]/div[3]/div/div/div[1]/div[1]/div[6]/div[2]/input")).sendKeys("Test" +integer); //subject
        driver.switchTo().frame(driver.findElement(By.className("editor_iframe")));
        driver.findElement(By.className("rooster-content-body")).sendKeys("Test" +integer); //content
        driver.switchTo().defaultContent();
        driver.findElement(By.className("xmail_sendmail_btn")).click();//click send button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/button[2]")).click();




    }
    @Test
    public void ReadAll(@NotNull WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("dt.ckbox")).click();
        driver.findElement(By.className("gb-layer")).click();
        driver.findElement(By.xpath("//span[@ng-click='tools.chooseAll()']")).click();
        driver.findElement(By.xpath("//div[@ng-hide='toolsActionConfig.mark.hide']/dt")).click();
        driver.findElement(By.xpath("//span[@ng-show=\"toolsActionConfig.mark.hasRead && !toolsBarService.detail\"]")).click();//set selected emails as hasRead



    }
}
