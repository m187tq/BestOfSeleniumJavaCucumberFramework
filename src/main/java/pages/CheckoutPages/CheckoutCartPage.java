package pages.CheckoutPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AccountPages.AccountLoginPage;
import pages.BPage;
import pages.HomePages.HomePage;

import java.io.IOException;

public class CheckoutCartPage extends BPage {

    public CheckoutCartPage() throws IOException {
        super();
    }

    @FindBy(xpath="//input[@id='coupon_coupon']")
    private WebElement couponBox;

    @FindBy(css="#apply_coupon_btn")
    private WebElement applyCouponBtn;

    @FindBy(css="#estimate_country")
    private WebElement estimateCountryDropdown;

    @FindBy(css="#estimate_country_zones")
    private WebElement countryZonesDropdown;

    @FindBy(xpath="//input[@id='estimate_postcode']")
    WebElement estimatePostcodeBox;

    @FindBy(xpath="//tbody/tr[2]/td[1]/div[1]/form[1]/div[2]/div[1]/span[1]/button[1]")
    private WebElement estimateCalculatorBtn;

    @FindBy(xpath="//select[@id='shippings']")
    private WebElement FlatRateShipmentsDropdown;

    @FindBy(xpath="//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[7]/a/i")
    private WebElement removeItemBtn;

    @FindBy(id="cart_update")
    private WebElement updateBtn;

    @FindBy(xpath="//*[@id=\"cart\"]/div/div[3]/div/a[1]")
    private WebElement continieShippingBtn;

    @FindBy(css="i.btn.btn-orange.pull-right")
    private WebElement checkoutBtn;

    @FindBy(css=".maintext")
    private WebElement shoppingCartTxt;


    public boolean validateShoppingCartTxt() {
        return isDisplayed(getDriver(), shoppingCartTxt);
    }

    public void EnterCouponNumberOnCouponBox(String CouponNumber) throws Exception {
        sendKeysToWebElement(couponBox, CouponNumber);
    }

    public void clickOnApplyCouponBtn() {
        waitForWebElementAndClick(applyCouponBtn);
    }

    public void selectEstimateCountryDropdown(String countryName) {
        selectByVisibleText(countryName, estimateCountryDropdown);
    }

    public void selectCountryZonesDropdown(String countryZonesName) {
        selectByVisibleText(countryZonesName, countryZonesDropdown) ;
    }

    public void enterOnEstimatePostcodeBox(String postCode) throws Exception {
        sendKeysToWebElement(estimatePostcodeBox, postCode);
    }

    public void clickOnEstimateCalculatorBtn() {
        waitForWebElementAndClick(estimateCalculatorBtn);
    }

    public void selectFlatRateShipmentsDropdown(String flatRateShipment) {
        selectByVisibleText(flatRateShipment, FlatRateShipmentsDropdown);
    }

    public boolean validateRemoveIconBtn() {
        return isEnabled(getDriver(), removeItemBtn);
    }

    public void clickOnRemoveIconBtn() {
        waitForWebElementAndClick(removeItemBtn);
    }

    public void clickOnUpdateBtn() {
        waitForWebElementAndClick(updateBtn);
    }

    public HomePage clickOnContinieShippingBtn() throws IOException {
        waitForWebElementAndClick(continieShippingBtn);
        return new HomePage();
    }

    public AccountLoginPage clickOnCheckoutBtn() throws IOException {
        waitForWebElementAndClick(checkoutBtn);
        return new AccountLoginPage();
    }


}
