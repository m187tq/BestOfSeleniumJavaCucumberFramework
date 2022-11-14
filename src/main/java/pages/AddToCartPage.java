package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.OrderPage.OrderConfirmationPage;

import java.io.IOException;

public class AddToCartPage extends BPage {
    
    public AddToCartPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//*[@id=\"quickSearch\"]/div/section/ul/li[2]")
    public WebElement addToCartByIndex;

    @FindBy(id="quantity_wanted")
    private WebElement quantity;

    @FindBy(name="group_1")
    private WebElement size;

    @FindBy(xpath="//span[text()='Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
    private WebElement addToCartMessage;

    @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public void enterQuantity(String quantity1) throws Throwable {
        type(quantity, quantity1);
    }
    public void selectSize(String size1) throws Throwable {
        selectByVisibleText(size1, size);
    }
    public void clickOnAddToCart() throws Throwable {
        click(getDriver(), addToCartBtn);
    }
    public boolean validateAddToCart() throws Throwable {
        fluentWait(getDriver(), addToCartMessage, 10);
        return isDisplayed(getDriver(), addToCartMessage);
    }
    public OrderConfirmationPage clickOnCheckOut() throws Throwable {
        fluentWait(getDriver(), proceedToCheckOutBtn, 10);
        JSClick(getDriver(), proceedToCheckOutBtn);
        return new OrderConfirmationPage();
    }
    public void ClickOnAddToCartByIndex() {
        moveToElement(getDriver(),addToCartByIndex);
        JSClick(getDriver(),addToCartByIndex);
    }
    public void setAddToCartByIndex(WebElement addToCartByIndex) {
        this.addToCartByIndex = addToCartByIndex;
    }

}
