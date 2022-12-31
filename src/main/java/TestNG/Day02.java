package TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day02 {
    @Test
    public  void validT(){
        System.out.println("Day 2 Make sure ");
    }
    @BeforeTest
    public void prerequiste(){
        System.out.println(">> Before Test Annotation");
    }
}
