package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartPhonePage extends BasePage {

    public SmartPhonePage() {
        super();
    }

    @FindBy(xpath = "//input[@name='facet-filter-brand']")
    private WebElement txtBrandSearch;

    @FindBy(xpath = "//input[@name='facet-filter-storage']")
    private WebElement txtStorageSearch;

    @FindBy(xpath = "//span[contains(text(), 'Check it out')]")
    private WebElement btnStaffPick;

    public void sendKeysSelectedFilterValue(String option, String filter) {

        switch(filter)  {
            case "Brand":
                sendKeysByWebElement(txtBrandSearch, option);
                clickFIlterSearchResultOption(option);
                break;
            case "Storage":
                sendKeysByWebElement(txtStorageSearch, option);
                clickFIlterSearchResultOption(option);
                break;
            default:
                System.out.println("Filter Section is not available in the page");
        }
    }
    public void clickSelectedFilterOption(String option, String filter) {
        clickFIlterSearchResultOption(option);
    }
    public void clickFIlterSearchResultOption(String option) {

        WebElement filteroption = getDriver().findElement(By.xpath("//input[" +
                "contains(@id, '"+ option +"') and " +
                "contains(@data-test, '" + option + "')]/following-sibling::label/div"));
        filteroption.click();
    }
    public WebElement setBtnStaffPick() {return btnStaffPick;}


}
