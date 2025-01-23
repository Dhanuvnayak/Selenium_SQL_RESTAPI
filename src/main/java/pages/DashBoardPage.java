package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage {
    @FindBy(xpath = "//h1[text()='Dashboard']")
    private WebElement dashboardHeader;

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardDisplayed() {
        return dashboardHeader.isDisplayed();
    }
}
