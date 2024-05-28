package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
   @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
    //login

       driver.findElement(By.xpath("//a[@class='ico-login']")).click();
       String expected="Welcome, Please Sign In!";
       String actual= driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();
       System.out.println(actual);
       Assert.assertEquals(expected,actual);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //click on login and find email and pass and verify with the expected
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("000@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("axaxaaxaxaxaxaxax@1234");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String Expected="Log out";
        String Actual= driver.findElement(By.xpath("//a[text()='Log out']")).getText();
        Assert.assertEquals(Expected,Actual);

        //I have checked and its running but bcoz of security reasons i will not provide legal email and password.


    }
    @Test
    public  void verifyTheErrorMessage(){
        //click on login and find email and pass and verify with the expected
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("prime1@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1111");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String expected="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actual=driver.findElement(By.xpath("//div[contains(text(),'Login')]")).getText();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);

    }

    @After
    public void tearDown(){
        //closeBrowser();

    }
}
