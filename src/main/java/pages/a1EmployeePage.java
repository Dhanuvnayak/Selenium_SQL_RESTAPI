package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class a1EmployeePage {
    @FindBy(id = "UserName")
    public WebElement usernameField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"MenusDashboard\"]/li[2]/a/text()")
    public WebElement employee;

    @FindBy(xpath = "//*[@id=\"MenusDashboard\"]/li[2]/ul/li[1]/a")
    public WebElement create;
    @FindBy(id = "FirstName")
    public WebElement firstname ;
    @FindBy(id = "Lastname")
    public WebElement lastname;
    @FindBy(id ="EmailId")
    public WebElement emailid;
    @FindBy(id = "MobileNo")
    public WebElement mobileno;
    @FindBy (id = "DOB")
    public WebElement dob;
    @FindBy(id = "rdbFemale")
    public WebElement gender;
    @FindBy(id="Address")
    public WebElement address;
    @FindBy(id="CountryId")
    public WebElement countrylist;
    @FindBy(id="CityId")
    public WebElement citylists;
    @FindBy(id = "chkSkill_1")
    public WebElement skill;
    @FindBy(tagName = "button")
    public WebElement savebutton;
WebDriver driver;
    public a1EmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void login(String u, String p) throws InterruptedException {
        usernameField.sendKeys(u);
        passwordField.sendKeys(p);
        loginButton.click();
        Thread.sleep(3000);
    }

    public String fillTheEmployeeForm() throws InterruptedException {

        Thread.sleep(4000);
        employee.click();
        create.click();
        firstname.sendKeys("dhanu");
        lastname.sendKeys("v");
        emailid.sendKeys("dhanu@gmail.com");
        mobileno.sendKeys("123456");
        dob.sendKeys("20/12/2000");
        address.sendKeys("Banglore");
        Select country= new Select(countrylist);
        country.selectByVisibleText("India");
        Select city = new Select(citylists);
        city.selectByVisibleText("Hyderabad");
        skill.click();
        savebutton.click();
        Thread.sleep(3000);
        WebElement succesMsg = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div[1]"));
        return succesMsg.getText();
    }
}
