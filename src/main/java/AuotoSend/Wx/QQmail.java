package AuotoSend.Wx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class QQmail{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Emails emails = new Emails();
        int i=0;
        driver.get("https://wx.mail.qq.com/home/index?sid=zLZqQoxgV0Iu6W1yAP9PbQAA#/compose/new");

        emails.sendEmails(driver, i);




    }

}
class Emails{
    public void sendEmails(WebDriver driver,Integer integer) throws InterruptedException{
        Thread.sleep(1000);
        driver.switchTo().frame("//*[@id=\\\"mailMainApp\\\"]/div[2]/div/div[1]/div/ul/li[1]/a");//switch iframe

//        driver.findElement(By.xpath("//*[@id=\"mailMainApp\"]/div[2]/div/div[1]/div/ul/li[1]/a")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"mailMainApp\"]/div[3]/div/div/div[1]/div[1]/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr/td/div[1]/input")).sendKeys("merc0606@sohu.com"); //input reciepient's Email
        driver.findElement(By.xpath("//*[@id=\"mailMainApp\"]/div[3]/div/div/div[1]/div[1]/div[6]/div[2]/input")).sendKeys("Test" +integer); //subject
        driver.findElement(By.xpath("//*[@id=\"mailMainApp\"]/div[3]/div/div/div[1]/div[1]/div[7]/div[3]/div")).sendKeys("Test" +integer); //content
        driver.findElement(By.xpath("//*[@id=\"mailMainApp\"]/div[3]/div/div/div[1]/div[2]/div[2]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mailMainApp\"]/div[3]/div/div[1]/div[4]/button[2]")).click();


    }
}
