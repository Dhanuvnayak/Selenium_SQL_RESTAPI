package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
import utils.WebDriverManager;

import java.time.Duration;

public class AdminTest {
    WebDriver driver;
    AdminLoginPage a;
    @BeforeMethod
    public void openUrl(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://magnus.jalatechnologies.com/");
        a= new AdminLoginPage(driver);
    }
    @Test
    public void checkAdmin() throws InterruptedException {
        a.adminButton();
        Assert.assertEquals(a.adminButton(),"Admin Login","Invalid Title");
    }
    @Test
    public void adminLogin() throws InterruptedException {
        a.enterValid("training@jalaacademy.com","jobprogram");
        Assert.assertEquals(a.errorMsg(),"Invalid Email and Password.","Error msg not showing");
    }
    @Test
    public void goToBack() throws InterruptedException {
        a.goBack();
        Assert.assertEquals(a.goBack(),"Login", "Invalid Title");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
