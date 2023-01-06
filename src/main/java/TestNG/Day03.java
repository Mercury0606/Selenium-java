package TestNG;

import org.testng.annotations.*;

import java.util.Iterator;

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
    @Parameters({"URL","APIKey/username"})
    @Test(groups = {"Smoke"},enabled = true)
    public void webLogin(String urlName,String key){
        //Selenium
        System.out.println("webLoginCar + "+urlName+" + "+key );
    }

    @Test(timeOut = 4000)
    public void mobileLogin(){
        //Appium
        System.out.println("mobileLoginCar");
    }

    @Test(dataProvider = "getData")
    public void loginAPIcarLoan(String userName,String password){
//        Rest API automation
        System.out.println("LoginAPIcarLoan");
        System.out.println(userName + " + " + password);
    }
    @Test(dependsOnMethods = {"mobileLogin","loginAPIcarLoan"})
    public void APICarLoan(){
        System.out.println("APILoginCar");
    }
    @DataProvider
    public Object[][] getData(){
        //1st combination - username password - good credit history
        //2nd conbination -username password -no credit history
        //3rd conbination -username password - fraudulent credit history
        Object[][] data =new Object[3][2];
//        First set data
        data[0][0]="firstSetUserName";
        data[0][1]="123456";
//        colomns in the row are nothing but values for that particular combination
        data[1][0]="secondSetUserName";
        data[1][1]="67890";
        data[2][0]="thirdSetUserName";
        data[2][1]="1234567890";
        return data;
    }
}
