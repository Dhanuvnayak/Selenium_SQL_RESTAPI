package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
    WebDriver driver;
    @FindBy(xpath="/html/body/div[2]/div[2]/div/a[2]")
    public WebElement admin ;
    @FindBy(id="UserName")
    public WebElement username;
    @FindBy(id="Password")
    public WebElement password;
    @FindBy(id="btnLogin")
    public WebElement signin;
    @FindBy(id="spMessage")
    public WebElement error;
    @FindBy(xpath = "//*[@id=\"frmLogin\"]/div[4]/div[1]/a")
    public WebElement back;
    public AdminLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String adminButton() throws InterruptedException {
        System.out.println(admin.isDisplayed());
        System.out.println(admin.isEnabled());
        admin.click();
        Thread.sleep(4000);
        return driver.getTitle();
    }

    public void enterValid(String u, String p){
 username.sendKeys(u);
 password.sendKeys(p);
 signin.click();
    }
    public String errorMsg() throws InterruptedException {
        Thread.sleep(4000);
        return error.getText();
    }

    public String goBack() throws InterruptedException {
        System.out.println(back.isDisplayed());
        System.out.println(back.isEnabled());
        back.click();
        Thread.sleep(4000);
        return driver.getTitle();
    }
}
