package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day04 {
    @Test
    public void webLogin(){
        //Selenium
        System.out.println("webLoginHome");
    }
    @Parameters({"URL"})
    @Test
    public void monbileLogin(String urlName){
        //Appium
        System.out.println("mobileLoginHome + "+urlName);
    }
    @Parameters
    @Test
    public void loginAPIHomeLoan(){
//        Rest API automation
        System.out.println("LoginAPIHomeLoan");
    }
}
