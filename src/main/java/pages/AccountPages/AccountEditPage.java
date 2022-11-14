package pages.AccountPages;

import helper.javaScript.JavaScriptHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;

public class AccountEditPage extends BPage {
    public AccountEditPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    public WebElement myaccountInformationHeadingtext;

    @FindBy(name = "firstname")
    public WebElement firstNameBox;
    @FindBy(xpath = "//*[@id=\"AccountFrm_lastname\"]")
    public WebElement lastNameBox;

    @FindBy(id = "AccountFrm_email")
    public WebElement emailBox;
    @FindBy(css = "#AccountFrm_telephone")
    public WebElement telephoneBox;
    @FindBy(css = "#AccountFrm_fax")
    public WebElement faxBox;
    @FindBy(xpath = "//*[@id=\"AccountFrm\"]/div[2]/div/button")
    public static WebElement continueEditBtn;


    public boolean validateUserOnAccountEditPageIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        return isDisplayed(getDriver(), myaccountInformationHeadingtext);
    }
    public void enterFirstNameBox(String FirstName) throws Exception {
        sendKeys(firstNameBox, FirstName);
    }

    public void enterLastNameBox(String Lastname) throws Exception {
        sendKeys(lastNameBox, Lastname);

    }
    public void enterFreshEmailBox() throws Exception {
        //emailBox.clear();
        String email = System.currentTimeMillis() + "@gmail.com";
        sendKeys(emailBox, email);

    }

    public void enterTelephoneBox(String Telephone) throws Exception {
        sendKeys(telephoneBox, Telephone);

    }

    public void enterFaxBox(String Fax) throws Exception {
        sendKeys(faxBox, Fax);

    }

    public AccountPage clickOnContinueEditBtn() throws IOException, InterruptedException {
        new JavaScriptHelper(getDriver()).scrollToElement(continueEditBtn);
        click(getDriver(), continueEditBtn);
        return new AccountPage();

    }

    public void updatingProfileDetails(String firstname, String lastname, String telephone, String fax) throws Exception {
        log.info("editing Profile Details....");
        enterFirstNameBox(firstname);
        enterLastNameBox(lastname);
        enterFreshEmailBox();
        enterTelephoneBox(telephone);
        enterFaxBox(fax);
        log.info("editing Profile Details....");

    }

}
