package helper.assertion;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationHelper {

    private final WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(VerificationHelper.class);

    public VerificationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEnabled(WebElement element) {
        try {
            element.isEnabled();
            log.info("element is Enabled => " + element.getText());
            System.out.println("element is Enabled => " + element.getText());
            return true;
        } catch (Exception e) {
            log.error("element is not Enabled... ", e.getCause());
            System.out.println("element is not Enabled.." + e.getMessage());
            return false;
        }
    }

    public boolean isSelected(WebElement element) {
        try {
            element.isSelected();
            log.info("element is Selected => " + element.getText());
            System.out.println("element is Selected => " + element.getText());
            return true;
        } catch (Exception e) {
            log.error("element is not Selected... ", e.getCause());
            System.out.println("element is not Selected.." + e.getMessage());
            return false;
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is Displayed => " + element.getText());
            System.out.println("element is Displayed => " + element.getText());
            return true;
        } catch (Exception e) {
            log.error("element is not Displayed... ", e.getCause());
            System.out.println("element is not Displayed.." + e.getMessage());
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is present => " + element.getText());
            System.out.println("element is present => " + element.getText());
            return false;
        } catch (Exception e) {
            log.error("element is not present..");
            System.out.println("element is not present..");
            return true;
        }
    }

    public String readValueFromElement(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            System.out.println("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is => " + element.getText());
            System.out.println("element text is => " + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getText(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            System.out.println("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is => " + element.getText());
            System.out.println("element text is => " + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getTitle() {
        log.info("page title is => " + driver.getTitle());
        System.out.println("page title is => " + driver.getTitle());
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        log.info("page current url is => " + driver.getTitle());
        System.out.println("page current url is => " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }


}
