package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class ShippingReturnsPage extends BPage {

    public ShippingReturnsPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//h1[contains(text(),'Shipping & Returns')]")
    private WebElement shippingReturnsHeadingTxt;

    public boolean getShippingReturnsHeadingTxt() {
        return isDisplayed(getDriver(), shippingReturnsHeadingTxt);
    }
}
