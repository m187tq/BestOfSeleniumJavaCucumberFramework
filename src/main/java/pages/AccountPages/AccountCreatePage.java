package pages.AccountPages;


import helper.assertion.VerificationHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;
import java.util.List;

public class AccountCreatePage extends BPage {
   // Logger log = LoggerHelper.getLogger(AccountCreatePage.class);
    public AccountCreatePage() throws IOException {
        super();

    }

    // URL, LOGO, TEXTS//
    public final String URL = "https://automationteststore.com/index.php?rt=account/create";
    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/h1/span[1]/text()")
    public WebElement yourAccountHasBeenCreatedTxt;
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement registerLinkText;
    @FindBy(css = ".heading1")
    public WebElement createAccountTxt;
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]")
    public WebElement ifYouAlreadyHaveAnAccountWithUs;
    @FindBy(xpath = "//h4[contains(text(),'Your Personal Details')]")
    public WebElement yourPersonalDetailsTxt;
    @FindBy(xpath = "//input[@id='AccountFrm_firstname']")
    public WebElement firstNameTextBox;

    //**************Your Personal Details**************//
    @FindBy(xpath = "//input[@id='AccountFrm_lastname']")
    public WebElement lastNameTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_email']")
    public WebElement emailTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_telephone']")
    public WebElement telephoneTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_fax']")
    public WebElement faxTextBox;
    @FindBy(xpath = "//h4[contains(text(),'Your Address')]")
    public WebElement yourAddressText;
    @FindBy(css = "#AccountFrm_company")
    public WebElement companyTextBox;

    //**************Your Address*****************//
    @FindBy(css = "#AccountFrm_address_1")
    public WebElement address1TextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_address_2']")
    public WebElement address2TextBox;
    @FindBy(css = "#AccountFrm_city")
    public WebElement cityTextBox;
    @FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
    public WebElement regionStateDropdownBtn;
    @FindBy(xpath = "//input[@id='AccountFrm_postcode']")
    public WebElement zipCodeTextBox;
    @FindBy(xpath = "//select[@id='AccountFrm_country_id']")
    public WebElement countryDropdownBtn;
    @FindBy(xpath = "//h4[contains(text(),'Login Details')]")
    public WebElement loginDetailsSectionText;
    @FindBy(css = "#AccountFrm_loginname")
    public WebElement loginNameTextBox;

    //**************Login Details**************//
    @FindBy(css = "#AccountFrm_password")
    public WebElement passwordTextBox;
    @FindBy(css = "#AccountFrm_confirm")
    public WebElement passwordConfirmTextBox;
    @FindBy(xpath = "//h4[contains(text(),'Newsletter')]")
    public WebElement newsletterText;
    @FindBy(css = "#AccountFrm_newsletter1")
    public WebElement subscribeYesRadioButton;

    //**************Newsletter**********************//
    @FindBy(css = "#AccountFrm_newsletter0")
    public WebElement subscribeNORadioButton;
    @FindBy(css = "#AccountFrm_agree")
    public WebElement agreeToPrivacyPolicyButton;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/label[1]")
    public WebElement agreeToPrivacyPolicyText;
    // Summit button //
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/div[1]/button[1]")
    public WebElement continueBtn;
    @FindBy(css = "#AccountFrm_firstname")
    public WebElement firstNameErrorTxt;
    @FindBy(css = "#AccountFrm_lastname")
    public WebElement lastNameErrorTxt;

    //**********ERRORS ********************//
    @FindBy(css = "#AccountFrm_email")
    public WebElement emailErrorTxt;
    @FindBy(css = "#AccountFrm_address_1")
    public WebElement address1ErrorTxt;
    @FindBy(css = "#AccountFrm_city")
    public WebElement cityErrorTxt;
    @FindBy(css = "#AccountFrm_zone_id")
    public WebElement regionStateErrorTxt;
    @FindBy(css = "#AccountFrm_postcode")
    public WebElement zipCodeErrorTxt;
    @FindBy(css = "#AccountFrm_password")
    public WebElement passwordErrorTxt;
    @FindBy(xpath = "//b[contains(text(),'Privacy Policy')]")
    public WebElement privacyPolicyErrorTxt;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    public WebElement youMustAgreeToThePrivacyPolicyErrorTxt;
    @FindBy(xpath = "//span[contains(text(),'')]")
    public List<WebElement> allHighlightedWarningRedMessageErrorTxt;
    @FindBy(xpath = "//span[contains(text(),'First Name must be between 1 and 32 characters!')]")
    public WebElement firstNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    public WebElement lastNameRedMessages;

    //**********RED WARNING MESSAGES**********//
    @FindBy(xpath = "//span[contains(text(),'Email Address does not appear to be valid!')]")
    public WebElement emailRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Address 1 must be between 3 and 128 characters!')]")
    public WebElement address1RedMessages;
    @FindBy(xpath = "//span[contains(text(),'City must be between 3 and 128 characters!')]")
    public WebElement cityRedMessages;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/fieldset[1]/div[6]/span[1]")
    public WebElement zipCodeRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Please select a region / state!')]")
    public WebElement StateProvinceRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Login name must be alphanumeric only and between 5')]")
    public WebElement loginNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Password must be between 4 and 20 characters!')]")
    public WebElement passwordRedMessages;
    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div[1]")
    public WebElement agreeToPrivacyPolicyRedMessages;
    String email = System.currentTimeMillis() + "P";

    public String createAccountText() throws InterruptedException {
        return getText(createAccountTxt);
    }

    public boolean verifyIfYouAlreadyHaveAnAccountWithUsIsDisplayed() {
        return isDisplayed(getDriver(), ifYouAlreadyHaveAnAccountWithUs);
    }
    public boolean verifyYourPersonalDetailsTxtIsDisplayed() {
        return isDisplayed(getDriver(), yourPersonalDetailsTxt);
    }

    public void enterFirstName(String firstName) {
        type(firstNameTextBox, firstName);
    }

    public void enterLastName(String lastName) {
        type(lastNameTextBox, lastName);
    }

    public void enterEmailAddress() {
        String email = System.currentTimeMillis() + "@gmail.com";
        sendKeys(emailTextBox, email);
    }

    public void enterTelephoneNumber(String telephone) {
        type(telephoneTextBox, telephone);
    }

    public void enterFaxNumber(String fax) {
        type(faxTextBox, fax);
    }

    public void enterYourPersonalDetailsSection(String firstName, String lastName, String telephone, String fax) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmailAddress();
        enterTelephoneNumber(telephone);
        enterFaxNumber(fax);

    }

    public boolean verifyYourAddressTextIsDisplayed() {
        return isDisplayed(getDriver(), yourAddressText);
    }
    public void enterCompanyName(String companyName) {
        type(companyTextBox, companyName);
    }
    public void enterAddress1(String address1) {
        type(address1TextBox, address1);
    }
    public void enterAddress2(String address2) {
        type(address2TextBox, address2);
    }
    public void enterCity(String cityName) {
        type(cityTextBox, cityName);
    }

    public void selectRegionState(String regionOrStateName) {
        selectByVisibleText(regionOrStateName, regionStateDropdownBtn);
    }
    public void enterZipCode(String ZipCode) {
        type(zipCodeTextBox, ZipCode);
    }

    public void selectCountry(String countryName) {
        selectByVisibleText(countryName, countryDropdownBtn);
 
    }

    public boolean verifyLoginDetailsSectionTextIsDisplayed() throws IOException {
        return new VerificationHelper(getDriver()).isDisplayed(loginDetailsSectionText);
    }

    public void enterLoginName() {
        type(loginNameTextBox, email);

    }
    public void enterPassword(String password) {
        type(passwordTextBox, password);


    }
    public void enterPasswordConfirm(String passwordConfirm) {
        type(passwordConfirmTextBox, passwordConfirm);
    }

    public boolean verifyNewsletterTextIsDisplayed() throws IOException {
        return new VerificationHelper(getDriver()).isDisplayed(newsletterText);

    }

    public void tickOnSubscribeAsYes() {
        waitForWebElementAndClick(subscribeYesRadioButton);

    }

    public boolean validateSubscribeYesTicked() {
        return isSelected(getDriver(),subscribeYesRadioButton);

    }

    public void clickOnSubscribeAsNo() {
        waitForWebElementAndClick(subscribeNORadioButton);

    }

    public void checkOnIAgreeToPrivacyPolicyRadioButton() {
        
        waitForWebElementAndClick(agreeToPrivacyPolicyButton);
    }

    public void clickOnIAgreeToPrivacyPolicyRadioButton() {
        waitForWebElementAndClick(agreeToPrivacyPolicyButton);
    }

    public AccountSuccessPage clickOnContinueButton() throws IOException {
        waitFor(continueBtn);
        click(getDriver(), continueBtn);
        return new AccountSuccessPage();
    }

    //******************SETTERS for Error*****************************//

    public void getFirstNameRedErrorTxt() throws Exception {
        // basePage.sendKeysToWebElement("    ");
    }

    public void getLastNameRedErrorTxt() throws Exception {
        // sendKeysToWebElement(lastNameErrorTxt,"    ");
    }

    public void getEmailRedErrorTxt() throws Exception {
        // sendKeysToWebElement(emailErrorTxt,"    ");
    }

    public void getAddress1RedErrorTxt() throws Exception {
        // sendKeysToWebElement(address1ErrorTxt,"    ");
    }

    public void getCityRedErrorTxt() throws Exception {
        //boolean result = cityErrorTxt.isDisplayed();
        // sendKeysToWebElement(cityErrorTxt,"    ");
        // checkPoint.mark("City",result,"City is Displayed");
    }

    public void selectRegionStateRedErrorTxt() throws Exception {
        //regionStateErrorTxt
    }

    public void getZipCodeRedErrorTxt() throws Exception {
        //sendKeysToWebElement(zipCodeErrorTxt,"    ");
    }

    public void getPasswordRedErrorTxt() throws Exception {

    }

    public void getPrivacyPolicyTxtRedErrorTxt() throws Exception {

    }

    public WebElement getErrorYouMustAgreeToThePrivacyPolicyRedErrorTxt() throws Exception {
        return youMustAgreeToThePrivacyPolicyErrorTxt;
    }

//===========================================================================================================//

    public boolean verifyFirstNameRedMessages() {
        return firstNameRedMessages.isDisplayed();

    }

    public boolean verifyLastNameRedMessages() {
        return lastNameRedMessages.isDisplayed();

    }

    public boolean verifyEmailRedMessages() {
        return emailRedMessages.isDisplayed();

    }

    public boolean verifyAddress1RedMessages() {
        return address1RedMessages.isDisplayed();

    }

    public boolean verifyCityRedMessages() {
        return cityRedMessages.isDisplayed();

    }

    public boolean verifyZipCodeRedMessages() {
        return zipCodeRedMessages.isDisplayed();
    }

    public boolean verifyStateProvinceRedMessages() {
        return StateProvinceRedMessages.isDisplayed();

    }

    public boolean verifyLoginNameRedMessages() {
        return loginNameRedMessages.isDisplayed();

    }

    public boolean verifyPasswordRedMessages() {
        return passwordRedMessages.isDisplayed();
    }

    public boolean verifyAgreeToPrivacyPolicyRedMessages() {
        return agreeToPrivacyPolicyRedMessages.isDisplayed();

    }

}


