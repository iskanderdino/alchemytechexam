package stepDefinitions;


import io.cucumber.java.en.When;
import pageObject.BasePage;
import pageObject.SmartPhonePage;

public class SmartPhonePage_Steps extends BasePage {
    public SmartPhonePage smartPhonePage;
    public SmartPhonePage_Steps(SmartPhonePage smartPhonePage) {
        this.smartPhonePage = smartPhonePage;
    }

    @When("I enter {string} in the {string} search filter textbox")
    public void i_enter_in_the_search_filter_textbox(String option, String filter) {
        smartPhonePage.sendKeysSelectedFilterValue(option, filter);
    }
    @When("I click {string} in the {string} search filter section")
    public void i_click_in_the_search_filter_section(String option, String filter) {
        smartPhonePage.clickSelectedFilterOption(option, filter);
    }
    @When("I click {string} option in the {string} filter section")
    public void i_click_option_in_the_filter_section(String option, String filter) {
        smartPhonePage.clickFIlterSearchResultOption(option);
    }

    @When("I click the Staff pick product in the webpage")
    public void i_click_the_staff_pick_product_in_the_webpage() {
        smartPhonePage.actionMoveAndClick(smartPhonePage.setBtnStaffPick());
        smartPhonePage.clickLinkElementByWebElement(smartPhonePage.setBtnStaffPick());
    }

}

