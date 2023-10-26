package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObject.BasePage;
import pageObject.MainPage;
import pageObject.ProductDetailsPage;

public class ProductDetailsPage_Steps extends BasePage {

    ProductDetailsPage productDetailsPage;
    public ProductDetailsPage_Steps(ProductDetailsPage productDetailsPage) {
        this.productDetailsPage = productDetailsPage;
    }
    @When("I click Buy button in the Product Details page")
    public void i_click_buy_button_in_the_product_details_page() {
        productDetailsPage.clickBtnElementByBtnWebElement(productDetailsPage.btnBuy);
    }
    @And("I click Go to cart button in the Product Details page")
    public void iClickGoToCartButtonInTheProductDetailsPage() {
        productDetailsPage.clickBtnElementByBtnWebElement(productDetailsPage.btnGoToCart);
    }

    @And("I click No button in the Trade-in offer modal")
    public void iClickNoButtonInTheTradeInOfferModal() {
        productDetailsPage.clickBtnElementByBtnWebElement(productDetailsPage.btnTradeInModalNo);
    }
}
