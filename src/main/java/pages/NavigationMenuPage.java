package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class NavigationMenuPage extends BPage {


	public NavigationMenuPage() throws IOException {
		super();
	}

	@FindBy(xpath = "//*[@id=\"menu\"]/nav/ul[1]")
	private List<WebElement> subMenuList;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[1]/a[1]")
	private WebElement gardenDropdownBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[2]/a[1]")
	private WebElement shopAllBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[3]/a[1]")
	private WebElement kitchenBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[4]/a[1]")
	private WebElement publications;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[5]/a[1]")
	private WebElement utilityBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[6]/a[1]")
	private WebElement journalBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[7]/a[1]")
	private WebElement ourStoryBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[8]/a[1]")
	private WebElement contactUsBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[9]/a[1]")
	private WebElement shippingAndReturnBtn;


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


	public List<WebElement> getSubMenuList() {
		return subMenuList;
	}

	public void clickOnGardenDropdownBtn() {
		click(getDriver(), gardenDropdownBtn);
	}

	public void clickOnShopAllBtn() {
		click(getDriver(), shopAllBtn);
	}

	public void clickOnKitchenBtn() {
		click(getDriver(), kitchenBtn);
	}

	public void clickOnPublications() {
		click(getDriver(), publications);
	}

	public void clickOnUtilityBtn() {
		click(getDriver(), utilityBtn);
	}

	public void clickOnJournalBtn() {
		click(getDriver(), journalBtn);
	}

	public void clickOnOurStoryBtn() {
		click(getDriver(), ourStoryBtn);
	}

	public void clickOnContactUsBtn() {
		click(getDriver(), contactUsBtn);
	}

	public void clickOnShippingAndReturnBtn() {
		click(getDriver(), shippingAndReturnBtn);
	}


}