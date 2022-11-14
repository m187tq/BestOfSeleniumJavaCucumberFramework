package pages.HomePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class InvoiceOrderPage extends BPage {

    public InvoiceOrderPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    private WebElement orderDetailsHeadingTxt;

    @FindBy(xpath = "a.btn.btn-default.mr10.mb20")
    private WebElement continuBtn;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div/div[4]/div/a[2]")
    private WebElement printBtn;

}
