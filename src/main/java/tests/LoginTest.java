package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest {
   public WebDriver driver;
    public LoginPage loginPage;
    public DashBoardPage dashboardPage;

    public LoginTest(WebDriver driver) {
        this.driver=driver;
    }


    @BeforeMethod
    public void openUrl() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("http://magnus.jalatechnologies.com/");
    loginPage = new LoginPage(driver);
    dashboardPage = new DashBoardPage(driver);
    }
    @Test
    public void title(){
    loginPage.getTitle();
    Assert.assertEquals(loginPage.getTitle(),"Login", "Invalid URl");
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        loginPage.login("training@jalaacademy.com", "jobprogram");
        Thread.sleep(1000);
        Assert.assertEquals(dashboardPage.isDashboardDisplayed(), "Magnus");
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {
        loginPage.login("invalid@jalaacademy.com", "wrongpassword");
        Thread.sleep(1000);
        Assert.assertEquals(loginPage.getErrorMessage(), "×\n" +
                "Invalid Email address or Password.\n" +
                "Error!",
                "Error message is not correct.");
    }

   @Test
    public void testBlankLogin() throws InterruptedException {
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessage(),"×\n" +
                        "Please fill all the required field\n" +
                        "Error!",
                "Error message for blank login is not correct.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
