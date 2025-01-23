package tests;

import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Forgot_Password_Page;

import java.time.Duration;

public class Forgot_Password_Test {
    public WebDriver driver ;
   Forgot_Password_Page f;
    @BeforeMethod
    public void openUrl() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://magnus.jalatechnologies.com/");
        f = new Forgot_Password_Page(driver);
    }

   @Test
public  void clickForgot() throws InterruptedException {
        Thread.sleep(3000);
        f.forgotclick();
        Assert.assertEquals(f.forgotclick(),"Forgot your password?", "Incorrect page title");
    }
    @Test
    public  void enterInvalidEmail() throws InterruptedException {
        f.enterEmailandGetPass("dhanu@gmail.com");

        Assert.assertEquals(f.getErrorMsg(),"Your email address not exist.\n"+"Error!",
                "Error message not showing");
    }
    @Test
    public  void enterValidEmail() throws InterruptedException {
        f.enterEmailandGetPass("training@jalaacademy.com");
        Assert.assertEquals(f.getErrorMsg(),"Oops! Something went wrong email sending fail.\n"+"Error!",
                "Message not displayed");
    }
    @Test
    public  void clickOnBack() throws InterruptedException {
       f.backClick();
        Assert.assertEquals(f.backClick(),"Login","Invalid page");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
