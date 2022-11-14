package pages.OrderPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class OrderConfirmationPage extends BPage {

    public OrderConfirmationPage() throws IOException {
        super();
    }

    @FindBy(id="cart-print-link")
    public WebElement printIcon;

    @FindBy(xpath="//h3[contains(text(),'Order Summary')]")
    public WebElement summaryOrder;

    @FindBy(xpath="//h1[contains(text(),'Thank you')]")
    public WebElement thankYouTxt;

    @FindBy(xpath="//*[@id=\"checkout-app\"]/div/div/div/section/p[1]")
    public WebElement yourOrderNumberTxt;

    @FindBy(xpath="//span[contains(text(),'Your Orders')]")
    public WebElement yourOrdersLinkTxt;

    @FindBy(xpath="//h3[contains(text(),'Order Summary')]")
    public WebElement orderSummaryTxt;

    @FindBy(css=".cart-priceItem.optimizedCheckout-contentPrimary.cart-priceItem--total")
    public WebElement totalAmountTxt;

    @FindBy(xpath="//h3[contains(text(),'Items')]")
    public WebElement totalItems;

    @FindBy(xpath="//span[contains(text(),'Shipping')]")
    public WebElement shippingPrice;

    @FindBy(xpath="//button[contains(text(),'Continue Shopping »')]")
    public WebElement continueShoppingBtn;


}
