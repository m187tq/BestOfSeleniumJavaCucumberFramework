package pages.HomePages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BPage;
import pages.ProductCategoryPage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MiddleMenuNaviPage extends BPage {

    public MiddleMenuNaviPage() throws IOException {
        super();
    }

    @FindBy(css = ".active.menu_home")
    public List<WebElement> homeDropdrownBtn;

    @FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[2]/a")
    public List<WebElement> apparelAccessoriesDropdownBtn;

    @FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[3]/a")
    public List<WebElement> makeupDropdownBtn;

    @FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[4]/a")
    public List<WebElement> skincareDropdownBtn;

    @FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[5]/a")
    public List<WebElement> fragranceDropdownBtn;

    @FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[6]/a")
    public List<WebElement> menDropdownBtn;

    @FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[7]/a")
    public List<WebElement> hairCareDropdownBtn;

    @FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[8]/a")
    public List<WebElement> booksDropdownBtn;


    public void clickOnHomeSubMenuListName(String homeDropdrownName) {
        List<WebElement> subMenuListNames = homeDropdrownBtn;
        Iterator<WebElement> itr = subMenuListNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(homeDropdrownName)) {
                log.info("selecting date as: " + homeDropdrownName);
                c.click();
                break;
            }
        }
    }

    public void clickOnMakeupSubMenuListName(String apparelAccessoriesDropdrownName) {
        List<WebElement> subMenuListNames = apparelAccessoriesDropdownBtn;
        Iterator<WebElement> itr = subMenuListNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(apparelAccessoriesDropdrownName)) {
                log.info("selecting....: " + apparelAccessoriesDropdrownName);
                c.click();
                break;
            }
        }
    }
    public void clickOnApparelAccessoriesSubMenuListName(String makeupDropdrownName) {
        List<WebElement> subMenuListNames = makeupDropdownBtn;
        Iterator<WebElement> itr = subMenuListNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(makeupDropdrownName)) {
                log.info("selecting...: " + makeupDropdrownName);
                c.click();
                break;
            }
        }
    }

    public void clickOnSkinCareSubMenuListName(String skincareDropdrownName) {
        List<WebElement> subMenuListNames = skincareDropdownBtn;
        Iterator<WebElement> itr = subMenuListNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(skincareDropdrownName)) {
                log.info("selecting...: " + skincareDropdrownName);
                c.click();
                break;
            }
        }
    }

    public void clickOnFragranceSubMenuListName(String fragranceDropdrownName) {
        List<WebElement> subMenuListNames = fragranceDropdownBtn;
        Iterator<WebElement> itr = subMenuListNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(fragranceDropdrownName)) {
                log.info("selecting...: " + fragranceDropdrownName);
                c.click();
                break;
            }
        }
    }

    public void clickOnMenSubMenuListName(String menDropdrownName) {
        List<WebElement> subMenuListNames = menDropdownBtn;
        Iterator<WebElement> itr = subMenuListNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(menDropdrownName)) {
                log.info("selecting...: " + menDropdrownName);
                c.click();
                break;
            }
        }
    }

    public void clickOnHairCareSubMenuListName(String hairCareDropdrownName) {
        List<WebElement> subMenuListNames = menDropdownBtn;
        Iterator<WebElement> itr = subMenuListNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(hairCareDropdrownName)) {
                log.info("selecting...: " + hairCareDropdrownName);
                c.click();
                break;
            }
        }
    }

    public void clickOnBooksSubMenuListName(String booksDropdrownName) {
        List<WebElement> subMenuListNames = booksDropdownBtn;
        Iterator<WebElement> itr = subMenuListNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(booksDropdrownName)) {
                log.info("selecting...: " + booksDropdrownName);
                c.click();
                break;
            }
        }
    }

    public ProductCategoryPage clickOnMenu(WebElement element) throws IOException {
        log.info("clicking on : "+element.getText());
        click(getDriver(), element);
        return new ProductCategoryPage();
    }
    public ProductCategoryPage clickOnItem(String data) throws IOException {
        log.info("clicking on :"+data);
        WebElement item = getDriver().findElement(By.xpath("//*[contains(text(),'"+data+"')]"));
        click(getDriver(), item);
        return new ProductCategoryPage();
    }
}

