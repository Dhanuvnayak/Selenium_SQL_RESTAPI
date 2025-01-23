package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage  {
    @FindBy(id = "UserName")
    public WebElement usernameField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;


WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
public String getTitle(){
       return driver.getTitle();

}
    public void login(String username, String password) throws InterruptedException {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        Thread.sleep(3000);
        loginButton.click();
    }

    public String getErrorMessage() {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div")) ;
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                (By.xpath("//*[@id=\"toast-container\"]/div")));
        System.out.println(errorMessage.getText());
        return errorMessage.getText();

    }
}
