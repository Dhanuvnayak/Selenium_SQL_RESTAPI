package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.a1EmployeePage;

import java.time.Duration;

public class a1EmployeeFormTest {
    a1EmployeePage e ;
    WebDriver driver;


    @BeforeMethod
    public void openUrl() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://magnus.jalatechnologies.com/");
        e= new a1EmployeePage(driver);

    }
    @Test
    public void loginPage() throws InterruptedException {
        e.login("training@jalaacademy.com", "jobprogram");
    }
    @Test
    public void fillTheForm() throws InterruptedException {
        e.fillTheEmployeeForm();
        Assert.assertEquals(e.fillTheEmployeeForm(),"Employee details saved successfully\n"+"Success!", "fill the details");
    }
}
