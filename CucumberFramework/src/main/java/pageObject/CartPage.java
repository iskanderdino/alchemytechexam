package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    // use this constructor to call on the BasePage method inside the BasePage constructor
    public CartPage() {
        super();
    }
    private String totalPrice;
    @FindBy(xpath = "//a[@data-test='title']")
    public WebElement lblProductTitle;
    @FindBy(xpath = "//div[@data-test='cart-product']//p[@data-test='grade']")
    public WebElement lblProductCondition;
    @FindBy(xpath = "//div[@data-test='price']")
    public WebElement lblProductPrice;
    @FindBy(xpath="//div[@data-qa='insurance']/div[contains(text(), 'Damage Cover')]")
    public WebElement lblInsuranceType;
    @FindBy(xpath="//div[@data-qa='insurance']/div[2]")
    public WebElement lblInsurancePrice;
    @FindBy(xpath="//div[@id='__layout']//div[1]/div[2]/div[@class='ml-6']")
    public WebElement lblSubtotalPrice;
    @FindBy(xpath="//div[@data-qa='service-fee']")
    public WebElement lblQAFee;
    @FindBy(xpath="//div[@data-qa='price-after-discount']")
    public WebElement lblTotalPrice;
    public void clickWarrantyByElementText(String warranty) {
        waitAndClickElementsUsingByLocator(By.xpath("//div[@data-test='insurances']//span[contains(text(),'" + warranty + "')]"));
    }
    public String calculateProductTotalPriceWithInsurance(String insurance) {
        String txtSubtotal = lblSubtotalPrice.getText().replace("£","");
        String txtQAFee = lblQAFee.getText().replace("£","");
        //convert prices to integer to get total
        float intSubtotal = Float.parseFloat(txtSubtotal);
        float intQAFee = Float.parseFloat(txtQAFee);
        float total = intSubtotal + intQAFee;
        //convert back to string and return value
        totalPrice = String.format("%.2f", total);
        return totalPrice;
    }
    public String setTotalPrice() {
        return totalPrice = lblTotalPrice.getText();

    }
}
