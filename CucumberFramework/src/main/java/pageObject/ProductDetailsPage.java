package pageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage() {
        super();
    }

    @FindBy(xpath = "//button[@data-id='product-page-buy-button-desktop']")
    public WebElement btnBuy;
    @FindBy(xpath = "//button[@data-test='user-no']")
    public WebElement btnTradeInModalNo;
    @FindBy(xpath = "//button[@data-qa='continue-shopping']")
    public WebElement btnGoToCart;

    @FindBy(xpath = "//span[@id='modalTitle']")
    public WebElement modalTradeinTitle;

    public void clickBtnTradeinModal() {
        try {
            if (modalTradeinTitle.isDisplayed()) {
                clickBtnElementByBtnWebElement(btnTradeInModalNo);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Trade-in modal is not visible, skipping this step!");
        }
    }

}
