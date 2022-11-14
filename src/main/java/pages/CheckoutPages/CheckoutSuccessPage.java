package pages.CheckoutPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;
import pages.HomePages.HomePage;
import pages.HomePages.InvoiceOrderPage;

import java.io.IOException;

public class CheckoutSuccessPage extends BPage {

    public CheckoutSuccessPage() throws IOException {
        super();
    }

    public String orderSuccessPageUrl = "https://automationteststore.com/index.php?rt=checkout/success";

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/h1/span[1]")
    private WebElement yourOrderHasBeenProcessedHeadingTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[2]")
    private WebElement OrderNumberText;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]")
    private WebElement viewInvoiceText;

    @FindBy(xpath = "//p[contains(text(),'Thank you for shopping with us!')]")
    private WebElement thankYouForShoppingWithUsText;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]")
    private WebElement invoicePageLink;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/a")
    private WebElement continueCheckoutSuccessBtn;

    public String validateOrderSuccessPageUrl() {
        return orderSuccessPageUrl;
    }

    public boolean validateYourOrderHasBeenProcessedHeadingTxt() {
        return isDisplayed(getDriver(), yourOrderHasBeenProcessedHeadingTxt);
    }

    public boolean validateOrderNumberText() {
        return isDisplayed(getDriver(), OrderNumberText);
    }

    public boolean validateViewInvoiceText() {
        return isDisplayed(getDriver(), viewInvoiceText);
    }

    public boolean validateThankYouForShoppingWithUsText() {
        return isDisplayed(getDriver(), thankYouForShoppingWithUsText);
    }

    public InvoiceOrderPage clickOnInvoicePageLink() throws IOException {
        waitForWebElementAndClick(invoicePageLink);
        return new InvoiceOrderPage();
    }

    public HomePage clickOnContinueCheckoutSuccessBtn() throws IOException {
        waitForWebElementAndClick(continueCheckoutSuccessBtn);
        return new HomePage();
    }

}
