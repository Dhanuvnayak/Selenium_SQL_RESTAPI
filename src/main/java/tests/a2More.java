package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class a2More {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magnus.jalatechnologies.com");
        Thread.sleep(5000);
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(5000);

    }

    @Test(priority = 2)
    public void multitab() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/a")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"frmTabs\"]/div/div/div/div/ul/li[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"frmTabs\"]/div/div/div/div/ul/li[2]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"frmTabs\"]/div/div/div/div/ul/li[3]/a")).click();

    }

    @Test(priority = 3)
    public void menu() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MenusDashboard\"]/li[2]/a")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[2]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"frmMenu\"]/div/div/div/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"tab_2\"]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"selbtn\"]")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"label\"]")).getText());
    }

    @Test(priority = 4)
    public void collapsibleContent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[4]/a")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        driver.findElement(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"headingOne\"]/h4/a")).click();
        System.out.println(driver.findElement((By.xpath("//*[@id=\"collapseOne\"]/div"))).getText());
    }

    @Test(enabled = false,priority = 5)
    public void image() throws AWTException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[5]/a")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        driver.findElement(By.xpath("//*[@id=\"file\"]")).click();
        Robot rbt = new Robot();
        rbt.delay(2000); // Wait for the file dialog to appear
        for( int i=1; i<=8;i++) {
            Thread.sleep(2000);
            rbt.keyPress(KeyEvent.VK_TAB);
        }

        for(int i=1; i<=6;i++) {
            Thread.sleep(2000);
            rbt.keyPress(KeyEvent.VK_DOWN);
        }

        Thread.sleep(2000);
        rbt.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        rbt.keyPress(KeyEvent.VK_TAB);

        for(int i=1; i<=12;i++) {
            Thread.sleep(2000);
            rbt.keyPress(KeyEvent.VK_DOWN);
        }
        Thread.sleep(2000);
        rbt.keyPress(KeyEvent.VK_ENTER);
    }
@Test(priority = 6)
public void slider(){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[6]/a")));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    element.click();
    Actions act = new Actions(driver);
    WebElement slider = driver.findElement(By.xpath("//*[@id=\"blue\"]/div[1]/div[4]"));
    act.clickAndHold(slider).moveByOffset(350, 0).release().perform();
    System.out.println(driver.findElement(By.xpath("//*[@id=\"ex6CurrentSliderValLabel\"]")).getText());
}
@Test(priority = 7)
    public void tooltips(){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[7]/a")));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    element.click();
    driver.findElement(By.xpath("//*[@id=\"btnTooltip\"]")).click();

}
@Test(priority = 8)
    public void popUps() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[8]/a")));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    element.click();
    driver.findElement(By.id("btn-one")).click();
    String w1 = driver.getWindowHandle();
    Set<String> s = driver.getWindowHandles();
    for (String w : s) {
        if (!w.equals(w)) {
            driver.switchTo().window(w);
            System.out.println(driver.getWindowHandle());
            // Perform actions in the new window
            driver.findElement(By.id("newWindowElement")).click();

            // Close the new window
            driver.close();
        }
    }
    driver.switchTo().window(w1);
}
@Test(priority = 9)
        public void iframe(){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//*[@id=\"MenusDashboard\"]/li[3]/ul/li[11]/a")));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    element.click();
    WebElement frame2 = driver.findElement(By.id("iframe2"));
    driver.switchTo().frame(frame2);
    driver.getTitle();
    }
}

