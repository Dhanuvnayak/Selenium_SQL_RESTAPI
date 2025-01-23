package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage{
    @FindBy(xpath = "//h1[text()='Dashboard']")
    public WebElement dashboardHeader;
WebDriver driver;
    public DashBoardPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String isDashboardDisplayed() {
        return driver.getTitle();
    }
}
