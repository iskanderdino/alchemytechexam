package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
    @FindBy(xpath = "//button[@data-qa='accept-cta']")
    public WebElement btnCookieAccept;

    @FindBy(xpath = "//nav[@aria-label='Breadcrumb']")
    public WebElement lblBreadcrumbs;

    public MainPage() {
        super();
    }

    public void navigateToMainPage() {navigateToPage("https://www.backmarket.co.uk/");}
}
