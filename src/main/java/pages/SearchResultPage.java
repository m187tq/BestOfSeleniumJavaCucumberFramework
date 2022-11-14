package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class SearchResultPage extends BPage{

    public SearchResultPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//*[@id=\"product_details\"]/div/div[1]/div[1]/a/img")
    public WebElement productDetailsImage;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/label[1]")
    public WebElement totalPriceTxt;

    @FindBy(xpath = "//*[@id=\"product\"]/fieldset/div[5]/ul/li/a")
    public WebElement addToCartBtn;

    @FindBy(id = "product_quantity")
    public WebElement quantityBtn;

    @FindBy(css = "div.input-group")
    public WebElement colorDropdownBtn;

    @FindBy(css = "span.bgnone")
    public WebElement productNameTxt;

    @FindBy(css = "ul.productinfo")
    public WebElement productInfoBoxTxt;

    @FindBy(css = "ul.li.active")
    public WebElement productReviewBtn;



    public boolean validateProductDetailsImage() {
        return isDisplayed(getDriver(), productDetailsImage);
    }

    public boolean validateTotalPriceTxt() {
        return isDisplayed(getDriver(), totalPriceTxt);
    }

    public void clickOnAddToCartBtn() {
        waitForWebElementAndClick(addToCartBtn); ;
    }

    public void EnterQuantityItemBtn(int noOfItem) throws Exception {
        sendKeysToWebElement(quantityBtn, String.valueOf(noOfItem));
    }

    public void selectColorDropdownBtn(String color) {
        selectByVisibleText(color, colorDropdownBtn) ;
    }

    public boolean validateProductNameTxt() {
        return isDisplayed(getDriver(), productNameTxt);
    }

    public boolean validateProductInfoBoxTxt() {
        return isDisplayed(getDriver(), productInfoBoxTxt);
    }

    public boolean clickAndValidateProductReviewBtn() {
        waitForWebElementAndClick(productInfoBoxTxt);
        return isDisplayed(getDriver(), productReviewBtn);
    }


}




