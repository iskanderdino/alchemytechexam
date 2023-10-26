package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.BasePage;
import pageObject.MainPage;

public class MainPage_Steps extends BasePage {

    public MainPage mainPage;
    public MainPage_Steps(MainPage mainPage) {
        this.mainPage = mainPage;
    }
    @Given("^I visit Back Market website$")
    public void i_visit_back_market_website() {
        mainPage.navigateToMainPage();
    }

    @Given("I close cookie modal on the webpage")
    public void i_close_cookie_modal_on_the_webpage() {
        mainPage.clickLinkElementByWebElement(mainPage.btnCookieAccept);
    }

    @When("I click {string} menu in the webpage")
    public void i_click_menu_on_the_webpage(String linkText) {
        mainPage.clickLinkElementByLinkText(linkText);
    }
    @Then("I should be redirected to {string} webpage")
    public void i_should_be_redirected_to_webpage(String currentPage) {
        Assert.assertTrue(mainPage.lblBreadcrumbs.getText().contains(currentPage));
    }
}
