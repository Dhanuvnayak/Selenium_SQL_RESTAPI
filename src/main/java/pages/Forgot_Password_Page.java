package pages;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgot_Password_Page {
    public WebDriver driver;

@FindBy(linkText="Forgot Password")
    public WebElement forgot ;
@FindBy(xpath="/html/body/div[2]/div[2]/p")
    public WebElement headerText ;
@FindBy(id="Email")
    public WebElement email;
@FindBy(id="btnForgotPassword")
    public WebElement getPass ;
@FindBy(css="div[class=\"toast toast-error\"]")
    public WebElement errorMsg ;
@FindBy(xpath="//*[@id=\"frmForgotPassword\"]/div[2]/div[1]/a")
    public WebElement back ;
@FindBy(xpath="//*[@id=\"toast-container\"]/div")
    public WebElement error ;

    public Forgot_Password_Page(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String forgotclick() throws InterruptedException {
        Thread.sleep(3000);
     forgot.isDisplayed();
     forgot.isEnabled();
     forgot.click();
        Thread.sleep(5000);
     return driver.getTitle();

 }
 public void enterEmailandGetPass(String Email) throws InterruptedException {
     Thread.sleep(3000);
     email.sendKeys(Email);
     getPass.isDisplayed();
     getPass.isEnabled();
     getPass.click();
     Thread.sleep(3000);
 }
 public String getErrorMsg() throws InterruptedException {
     Thread.sleep(3000);
     return errorMsg.getText();
 }
 public String getError() throws InterruptedException {
     Thread.sleep(3000);
     return  error.getText();
 }
 public String backClick() throws InterruptedException {
     Thread.sleep(3000);
     back.isDisplayed();
     back.isEnabled();
     back.click();
     return driver.getTitle();
 }
}

