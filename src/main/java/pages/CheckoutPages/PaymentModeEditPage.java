package pages.CheckoutPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class PaymentModeEditPage extends BPage {

    public PaymentModeEditPage() throws IOException {
        super();
    }

    @FindBy(css = ".paymentProviderHeader-name")
    private WebElement testGatewayTxt;

    @FindBy(css = "#ccNumber")
    private WebElement ccNumberBox;





}
