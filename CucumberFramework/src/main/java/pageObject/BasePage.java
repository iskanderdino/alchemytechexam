package pageObject;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BasePage {

    public BasePage() {
        // Use this method to initialize all Page Objects we declared in the Page Object class
        PageFactory.initElements(getDriver(), this);
    }

    // use this method to use webdriver "getDriver" method in DriverFactory class
    public WebDriver getDriver() {return DriverFactory.getDriver();}
    public void navigateToPage(String url) {getDriver().get(url);}
    public WebDriverWait webdriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    public void sendKeysBy(By by, String textValue) {
        webdriverWait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textValue);
    }
    public void sendKeysByWebElement(WebElement element, String textValue) {
        webdriverWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(textValue);
    }
    public void clickElementByXpath(By by) {
        webdriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }
    public void clickLinkElementByWebElement(WebElement element) {
        webdriverWait.until(ExpectedConditions.visibilityOf(element)).click();
    }
    public void clickLinkElementByLinkText(String linkText) {
        waitAndClickElementsUsingByLocator(By.linkText(linkText));
    }
    public void clickBtnElementByBtnWebElement(WebElement element) {
        webdriverWait.until(ExpectedConditions.visibilityOf(element));
        webdriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    // generate random data
    public String generateRandomNumber(int length) {return RandomStringUtils.randomNumeric(length);}
    public String generateRandromString(int length) {return RandomStringUtils.randomAlphabetic(length);}

    /**********************************************************************************
     **ACTION METHODS
     **********************************************************************************/

    public void actionMoveAndClick(WebElement element) {
        Actions ob = new Actions(getDriver());
        try {
            webdriverWait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            ob.moveToElement(element).click().build().perform();
            System.out.println("Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = element;
            Boolean elementPresent = webdriverWait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
            if (elementPresent == true) {
                ob.moveToElement(elementToClick).click().build().perform();
                System.out.println("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
        } catch (Exception e) {
            System.out.println("Unable to Action Move and Click on the WebElement, using locator: " + "<" + element.toString() + ">");
            System.out.println("Unable to Action Move and Click on the WebElement, Exception: " + e.getMessage());

        }
    }

    /**********************************************************************************
     **CLICK METHODS
     * @throws IOException
     **********************************************************************************/
    public void waitAndClickElement(WebElement element) throws InterruptedException, IOException {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                //wait until element can be mouse clicked
                this.webdriverWait.until(ExpectedConditions.visibilityOf(element));
                this.webdriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
                System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                System.out.println("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }

    public void waitAndClickElementsUsingByLocator(By by) {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                this.webdriverWait.until(ExpectedConditions.elementToBeClickable(by)).click();
                System.out.println("Successfully clicked on the element using by locator: " + "<" + by.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());
                System.out.println("Unable to wait and click on the element using the By locator, element: " + "<"+ by.toString() + ">");
            }
            attempts++;
        }
    }
}
