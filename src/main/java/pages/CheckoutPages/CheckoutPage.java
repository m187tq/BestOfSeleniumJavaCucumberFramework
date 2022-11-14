package pages.CheckoutPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class CheckoutPage extends BPage {


public CheckoutPage() throws IOException {
    super();
}

    @FindBy(xpath="//h2[contains(text(),'Customer')]")
    public WebElement customerHeadingTxt;

    @FindBy(css=".product-column.product-figure")
    public WebElement itemImage;

    @FindBy(xpath="//button[contains(text(),'Sign Out')]")
    public WebElement signOutBtn;

    @FindBy(xpath="//*[@id=\"checkout-app\"]/div/div/div/div/ol/li[3]/div/a/div[3]/button")
    public WebElement billingAddrEditBtn;

    @FindBy(xpath="//body/div[@id='checkout-app']/div[1]/div[1]/div[1]/div[1]/ol[1]/li[2]/div[1]/a[1]/div[3]/button[1]")
    public WebElement ShippingAddressEditBtn;

    @FindBy(css=".checkout-step.optimizedCheckout-checkoutStep.checkout-step--customer")
    public WebElement fullCustomerHeadingTxt;

    @FindBy(id="addressToggle")
    public WebElement shippingAddressTxt;

    @FindBy(xpath="//label[contains(text(),'My billing address is the same as my shipping addr')]")
    public WebElement MyBillingAddressSameShippingAddressTxt;

    @FindBy(xpath="//h2[contains(text(),'Customer')]")
    public WebElement shippingMethodTxt;

    @FindBy(css="#checkout-shipping-continue")
    public WebElement customerContinueBtn;

    @FindBy(xpath="//h3[contains(text(),'Order Summary')]")
    public WebElement orderSummaryTxt;

    @FindBy(css="#cart-edit-link")
    public WebElement editCartLinkTxt;

    @FindBy(xpath="//*[@id=\"checkout-app\"]/div/div/div/aside/article/section[3]/div/div")
    public WebElement totalPrice;

    public boolean isCustomerHeadingTxtDisplayed() {
        return isDisplayed(getDriver(), customerHeadingTxt);
    }

    public boolean isItemImageDisplayed() {
        return isDisplayed(getDriver(), itemImage);
    }

    public void clickOnSignOutBtn() {
        click(getDriver(), signOutBtn);

    }

    public boolean isSignOutBtnEnabled() {
        return isEnabled(getDriver(), signOutBtn);

    }

    public void clickOnBillingAddrEditBtn() {
        click(getDriver(), billingAddrEditBtn);

    }

    public void isBillingAddrEditBtnEnabled() {
        isEnabled(getDriver(), billingAddrEditBtn);
    }

    public void isBillingAddrEditBtnDisplayed() {
        isDisplayed(getDriver(), billingAddrEditBtn);
    }

    public boolean isShippingAddrEditBtnDisplayed() {
        return isDisplayed(getDriver(), ShippingAddressEditBtn);
    }

    public boolean isFullCustomerHeadingTxtDisplayed() {
        return isDisplayed(getDriver(), fullCustomerHeadingTxt);

    }
    public boolean isShippingAddressTxtDisplayed() {
        return isDisplayed(getDriver(), shippingAddressTxt);
    }
    public boolean isMyBillingAddressSameShippingAddressTxtDisplayed() {
        return isDisplayed(getDriver(), MyBillingAddressSameShippingAddressTxt);
    }
    public boolean isShippingMethodTxtDisplayed() {
        return isDisplayed(getDriver(), shippingMethodTxt);
    }

    public void clickOnCustomerContinueBtn() {
        click(getDriver(),customerContinueBtn);
    }
    public boolean isOrderSummaryTxtDisplayed() {
        return isDisplayed(getDriver(), orderSummaryTxt);

    }
    public void clickOnEditCartLinkTxt() {
        click(getDriver(), editCartLinkTxt);
    }

    public boolean isEditCartLinkTxtDisplayed() {
       return isDisplayed(getDriver(), editCartLinkTxt);
    }

    public boolean isTotalPriceDisplay() {
       return isDisplayed(getDriver(),totalPrice);
    }


}
