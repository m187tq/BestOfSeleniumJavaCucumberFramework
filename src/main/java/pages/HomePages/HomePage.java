package pages.HomePages;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;
import utilities.data;

import java.io.IOException;
import java.util.List;


public class HomePage extends BPage {
    public HomePage() throws IOException {
        super();

    }

    Logger log = LoggerHelper.getLogger(HomePage.class);

    public final String url = "https://automationteststore.com/";

    @FindBy(css = ".navbar-header.header-logo")
    public WebElement logoImage;

    @FindBy(name = "")
    public WebElement fastShippingTxt;
    @FindBy(name = "")
    public WebElement easyPaymentsTxt;
    @FindBy(name = "")
    public WebElement shippingOptionsTxt;
    @FindBy(name = "")
    public WebElement largeVarietyTxt;
    @FindBy(name = "")
    public List<WebElement> featuredProducts;
    @FindBy(name = "")
    public WebElement homePageSlider;
    @FindBy(name = "")
    public List<WebElement> containerFeaturedProducts;
    @FindBy(name = "")
    public WebElement footerBanners;
    @FindBy(name = "")
    public List<WebElement> latestProducts;
    @FindBy(name = "")
    public List<WebElement> bestSellerProducts;
    @FindBy(name = "")
    public List<WebElement> specialProducts;
    @FindBy(name = "")
    public List<WebElement> BrandScrollingList;
    @FindBy(name = "")
    public WebElement contactUs;
    @FindBy(name = "")
    public WebElement aboutUs;
    @FindBy(name = "")
    public WebElement testimonials;
    @FindBy(name = "")
    public WebElement newsletterSignUpsTxt;
    @FindBy(name = "")
    public WebElement subscribeNewsletterBox;
    @FindBy(name = "")
    public WebElement subscribeNewsletterBtn;

    // Constructor //


    public String getUrl() {
        return url;
    }


    public boolean isUserOnLandingPageTitle() {
        return getDriver().getTitle().contains(data.expectedTitle);

    }

    public boolean userOnLandingPageUrl() {
        return getDriver().getCurrentUrl().contains(data.BASE_URL);

    }

    public void goToUrl(String url) throws InterruptedException {
        getDriver().get(url);
    }

    public String getCurrentPageUrl() throws InterruptedException {
        waitFor(logoImage);
        return getDriver().getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return getDriver().getTitle();
    }

/*    public boolean validateFastShippingTxt() {
        return isDisplayed(getDriver(),fastShippingTxt);
    }

    public boolean validateEasyPaymentsTxt() {
        return isDisplayed(getDriver(),easyPaymentsTxt);
    }

    public boolean validateShippingOptionsTxt() {
        return isDisplayed(getDriver(),shippingOptionsTxt);
    }

    public boolean validateLargeVarietyTxt() {
        return isDisplayed(getDriver(),largeVarietyTxt);
    }

    public List<WebElement> validateFeaturedProducts() {
        return featuredProducts;
    }*/

    public WebElement validateHomePageSlider() {
        return homePageSlider;
    }

    public List<WebElement> validateContainerFeaturedProducts() {
        return containerFeaturedProducts;
    }

    public WebElement validateFooterBanners() {
        return footerBanners;
    }

    public List<WebElement> validateLatestProducts() {
        return latestProducts;
    }

    public List<WebElement> validateBestSellerProducts() {
        return bestSellerProducts;
    }

    public List<WebElement> validateSpecialProducts() {
        return specialProducts;
    }

    public List<WebElement> validateBrandScrollingList() {
        return BrandScrollingList;
    }

    public WebElement validateContactUs() {
        return contactUs;
    }

    public WebElement validateAboutUs() {
        return aboutUs;
    }

    public WebElement validateTestimonials() {
        return testimonials;
    }

    public WebElement validateNewsletterSignUpsTxt() {
        return newsletterSignUpsTxt;
    }

    public WebElement validateSubscribeNewsletterBox() {
        return subscribeNewsletterBox;
    }

    public WebElement validateSubscribeNewsletterBtn() {
        return subscribeNewsletterBtn;
    }


}
