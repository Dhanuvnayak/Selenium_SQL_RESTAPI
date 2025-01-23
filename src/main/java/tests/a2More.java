package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class a2More {
    WebDriver  driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magnus.jalatechnologies.com/Home/Tabs");

    }
    @Test
    public void multitab() throws InterruptedException {
        driver.findElement(By.xpath("///*[@id=\"frmTabs\"]/div/div/div/div/ul/li[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"frmTabs\"]/div/div/div/div/ul/li[2]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"frmTabs\"]/div/div/div/div/ul/li[3]/a")).click();

    }
}
