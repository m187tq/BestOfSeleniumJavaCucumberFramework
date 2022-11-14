package pages.AccountPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;

import java.io.IOException;
import java.util.List;

public class AccountPage extends BPage {
    public AccountPage() throws IOException {
            super();
    }

    @FindBy(css = ".maintext")
    public WebElement userProfileMyAccountTxt;

    @FindBy(css = "h1.heading")
    public WebElement myAccountTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[2]/div[1]/div/ul/li[1]")
    public WebElement accountDashboardTxt;

    @FindBy(linkText = "Logoff")
    public WebElement logoffBtn;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]")
    public List<WebElement> sideWidgetAccountDashboardLinks;

    @FindBy(css = "body.account-account:nth-child(2) div.container-fixed:nth-child(1) div.container-fluid div.column_right.col-md-3.col-xs-12.mt20 div.sidewidt div.myaccountbox ul.side_account_list li:nth-child(3) a:nth-child(1) > i.fa.fa-edit.fa-fw")
    public WebElement editAccountDetailsLink;

    @FindBy(id = "customer_menu_top")
    public WebElement welcomeBackTxt;

    @FindBy(linkText = "Logoff")
    public WebElement logout;

    @FindBy(css = ".alert.alert-success")
    public static WebElement successYourAccountSuccessfullyUpdatedTxt;


    public boolean isAccountDashboardTxtDisplayed() {
        waitFor(accountDashboardTxt);
        return isDisplayed(getDriver(),accountDashboardTxt);
    }

    public AccountLogoutPage clickOnLogoffBtn() throws IOException {
        waitFor(logoffBtn);
        click(getDriver(), logoffBtn);
        return new AccountLogoutPage();
    }

    public boolean isLogoffBtnDisplayed() {
        return isDisplayed(getDriver(), logoffBtn);
    }

    public void verifyAllSideWidgetElementsInAccountPageLinks() {
        List<WebElement> links = sideWidgetAccountDashboardLinks;
        for (int i = 0; i < links.size(); i = i++) {
            String listOfElements = links.get(i).getText();
            System.out.println("Size Of Side Widget List => " + links.size());
            log.info("Size Of Side Widget List => " + links.size());
            break;
        }

    }

    public void ClickOnLogOffLinkInSideWidgetList() {
        List<WebElement> ListSideWidget = getDriver().findElements(By.cssSelector(".side_account_list"));
        for (int i = 0; i < ListSideWidget.size(); i = i++) {
            String listName = ListSideWidget.get(i).getText();
            if (listName.contains("Logoff")) {
                getDriver().findElements(By.linkText("Logoff")).get(i).click();
                break;
            }

        }

    }

    public boolean validateUserAccountTextIsDisplayed() throws InterruptedException {
        waitFor(myAccountTxt);
        Thread.sleep(2000);
        return isDisplayed(getDriver(), myAccountTxt);
    }

    public String userProfileInfoMessage() {
        waitFor(userProfileMyAccountTxt);
        return userProfileMyAccountTxt.getText();
    }

    public String homePageWelcomeMessage(String arg1) throws InterruptedException {
        Thread.sleep(2000);
        return welcomeBackTxt.getText();
    }

    public String accountDashboardMessage() {
        return accountDashboardTxt.getText();
    }

    public void clickOnLogoutBtn() {
        waitFor(logout);
        click(getDriver(), logout);
    }

    public AccountEditPage clickOnEditAccountDetailsLink() throws IOException {
        waitFor(editAccountDetailsLink);
        click(getDriver(), editAccountDetailsLink);
        return new AccountEditPage();

    }

    public String accountProfileSuccessfulUpdateMessage() {
        waitFor(successYourAccountSuccessfullyUpdatedTxt);
        return successYourAccountSuccessfullyUpdatedTxt.getText();

    }

}