package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.BasePage;
import pageObject.CartPage;

public class CartPage_Steps extends BasePage {
    public CartPage cartPage;

    public CartPage_Steps(CartPage cartPage) {
        this.cartPage = cartPage;
    }
    @Then("the phone memory should display {string} GB")
    public void the_phone_memory_should_display_gb(String memory) {
        Assert.assertTrue(cartPage.lblProductTitle.getText().contains(memory));
    }
    @Then("the phone condition should display {string}")
    public void the_phone_condition_should_display(String condition) {
        Assert.assertEquals(cartPage.lblProductCondition.getText(), condition);
    }
    @When("I tick {string} Damage Cover in the coverage option")
    public void i_tick_damage_cover_in_the_coverage_option(String warranty) {
        cartPage.clickWarrantyByElementText(warranty);
    }
    @Then("the Summary section should display {string} Damage Cover warranty")
    public void the_summary_section_should_display_damage_cover_warranty(String insurance) {
    }
    @Then("the Total Price should display updated the price with {string} Damage Cover warranty")
    public void the_total_price_should_display_updated_price_with_damage_cover_warranty(String insurance) {
        cartPage.clickWarrantyByElementText(insurance);
        System.out.println("Expected Total Price: " + cartPage.setTotalPrice());
        System.out.println("Actual Total Price: " + cartPage.calculateProductTotalPriceWithInsurance(insurance));
        Assert.assertTrue(cartPage.setTotalPrice().contains(cartPage.calculateProductTotalPriceWithInsurance(insurance))) ;
    }
}
