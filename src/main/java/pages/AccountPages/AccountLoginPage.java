package pages.AccountPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BPage;
import utils.Global_Vars;

import java.io.IOException;
import java.time.Duration;

public class AccountLoginPage extends BPage {
    public AccountLoginPage() throws IOException {
    super();
    }

    @FindBy(id = "loginFrm_loginname")
    public WebElement loginNameTxtField;

    @FindBy(css = "#loginFrm_password")
    public WebElement passwordTxtField;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/fieldset[1]/button[1]")
    public WebElement loginBtn;

    // successful Login Variables declaration //
    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div[1]")
    public WebElement loginWithBlanksCredentialsTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div[1]/text()")
    public WebElement loginWithBadPasswordTxt;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    public WebElement errorIncorrectLoginOrPasswordProvidedTxt;

    // Registration Variables declaration //

    @FindBy(xpath = "//div[contains(text(),'By creating an account you will be able to shop fa')]")
    public WebElement createAnAccountTxt;

    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    public WebElement returningCustomerTxt;

    @FindBy(xpath = "//a[contains(text(),'Forgot your passwordErrorTxt?')]")
    public WebElement forgotYourPasswordLink;

    // Unsuccessful Login attempts Variables declaration //
    @FindBy(xpath = "//a[contains(text(),'Forgot your Login?')]")
    public WebElement forgotYourLoginLink;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[1]/label[1]")
    public WebElement registerAccountCheckBoxTxt;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/button[1]")
    public WebElement continueRegisterAccountBtn;

    @FindBy(xpath = "//h2[contains(text(),'I am a new customer.')]")
    public WebElement newCustomerTxt;

    public String getCreateAnAccountTxt() {
        return createAnAccountTxt.getText();
    }


    // Forget Password Variable declaration //

    @FindBy(xpath = "//*[@id='email_create']")
    public WebElement registrationEmailAddress;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/button[1]")
    public WebElement registerAccountContinueBtn;


    public void enterLoginName(String LoginName) throws Exception {
        sendKeysToWebElement(loginNameTxtField,LoginName);
    }
    public void enterPassword(String Password) throws Exception {
        //sendKeys(passwordTxtField, Password);
        sendKeysToWebElement(passwordTxtField, Password);
    }
    public AccountPage clickOnLoginBtn() throws IOException, InterruptedException {
        click(getDriver(), loginBtn);
        Thread.sleep(2000);
        return new AccountPage();
    }

    public boolean isLoginBtnEnabled() {
        return isEnabled(getDriver(), loginBtn);
    }

    public void goToLoginPageEnterLoginNameAndPasswordThenClickOnLoginBtn(String loginName, String password) throws Exception {
        enterLoginName(loginName);
        enterPassword(password);
        clickOnLoginBtn();
    }

    public void clickForgetYourLogin() {
        waitForWebElementAndClick(forgotYourLoginLink);
    }

    public void clickForgetYourPassword() {
       waitForWebElementAndClick(loginWithBadPasswordTxt);
    }

    public boolean verifyForgotYourPasswordTxtLink() {
        return isDisplayed(getDriver(), forgotYourPasswordLink);
    }

    public boolean verifyingForgotYourLogin() {
        return isDisplayed(getDriver(),forgotYourLoginLink);
    }

    public String errorIncorrectLoginPasswordProvidedConfirmationMessage(String arg0) {
        waitFor(errorIncorrectLoginOrPasswordProvidedTxt);
        /*WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        this.wait.until(ExpectedConditions.visibilityOf(errorIncorrectLoginOrPasswordProvidedTxt));*/
        return errorIncorrectLoginOrPasswordProvidedTxt.getText();
    }

    public boolean validateErrorIncorrectLoginPasswordProvidedConfirmationMessage() {
        waitFor(errorIncorrectLoginOrPasswordProvidedTxt);
        /*WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        this.wait.until(ExpectedConditions.visibilityOf(errorIncorrectLoginOrPasswordProvidedTxt));*/
        return isDisplayed(getDriver(), errorIncorrectLoginOrPasswordProvidedTxt);
    }
    public String currentPageTitle(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        this.wait.until(ExpectedConditions.visibilityOf(errorIncorrectLoginOrPasswordProvidedTxt));
        return getDriver().getTitle();
    }


  public boolean verifyReturningCustomerTxtIsDisplayed() {
      return  isDisplayed(getDriver(), returningCustomerTxt);
  }

    public boolean verifyRegisterAccountTextCheckBoxIsDisplayed() {
        return isDisplayed(getDriver(), registerAccountCheckBoxTxt);
    }

    public boolean validateNewCustomerTxtIsDisplayed() {
        return isDisplayed(getDriver(),newCustomerTxt);
    }

    public AccountCreatePage clickOnContinueRegisterAccountBtn() throws IOException, InterruptedException {
        waitAndClickElement(continueRegisterAccountBtn);
        return new AccountCreatePage();
    }


}
