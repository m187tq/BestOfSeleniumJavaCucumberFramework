package pages.AccountPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class AccountSuccessPage extends BPage {
    public AccountSuccessPage() throws IOException {
        super();
    }


    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h2[1]/span[1]")
    public WebElement myAccountText;
    @FindBy(css = ".btn.btn-default.mr10")
    public WebElement continueAccountSuccessBtn;

    @FindBy(xpath = "//*[@id=\"customer_menu_top\"]/li/a/div")
    public WebElement accountHasBeenCreatedHeadingTxt;


    public boolean validateMyAccountTxtIsDisplayed() {
        waitFor(myAccountText);
        return isDisplayed(getDriver(), myAccountText);
    }
    public String accountHasBeenCreatedHeadingTxt(String arg1) {
        waitFor(accountHasBeenCreatedHeadingTxt);
        String result = getText(accountHasBeenCreatedHeadingTxt);
        log.info("See the text: "+ result);
        return result;
    }

    public AccountPage clickOnContinueAccountSuccessBtn() throws IOException {
        waitFor(continueAccountSuccessBtn);
        click(getDriver(), continueAccountSuccessBtn);
        return new AccountPage();

    }


}
