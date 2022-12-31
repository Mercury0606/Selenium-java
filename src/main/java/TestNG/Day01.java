package TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day01 {
    @AfterTest
    public void aftTest(){
        System.out.println(">> After Test Annotation");
    }
    @Test
    public void demo(){
        System.out.println("Hello");
    }
    @BeforeMethod
    public void beforeEvery(){
        System.out.println(">> I'll run before every method in day 1 class");
    }
    @Test
    public  void secTest(){
        System.out.println("Bye");
    }
    @AfterSuite
    public void aftSuite(){
        System.out.println(">>After Suite Annotation");
    }

}
