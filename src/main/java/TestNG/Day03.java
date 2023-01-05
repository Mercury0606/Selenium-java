package TestNG;

import org.testng.annotations.*;

public class Day03 {
    @BeforeSuite
    public void BfSuite(){
        System.out.println("I am No.1");
    }
    @AfterSuite
    public void AfSuite(){
        System.out.println("I am the last 1");
    }
    @BeforeMethod
    public void BeforeEvery(){
        System.out.println(">> Before Every Method in Day03.class");
    }
    @AfterMethod
    public void AfterEvery(){
        System.out.println(">> After Every Method in Day03.class");
    }
    @Parameters({"URL"})
    @Test(groups = {"Smoke"},enabled = false)
    public void webLogin(String urlName){
        //Selenium
        System.out.println("webLoginCar"+urlName);
    }

    @Test(timeOut = 4000)
    public void mobileLogin(){
        //Appium
        System.out.println("mobileLoginCar");
    }
    @Test
    public void loginAPIcarLoan(){
//        Rest API automation
        System.out.println("LoginAPIcarLoan");
    }
    @Test(dependsOnMethods = {"mobileLogin","loginAPIcarLoan"})
    public void APICarLoan(){
        System.out.println("APILoginCar");
    }
}
