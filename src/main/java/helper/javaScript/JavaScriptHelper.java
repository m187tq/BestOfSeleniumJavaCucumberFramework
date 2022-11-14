package helper.javaScript;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
    private final WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

    public JavaScriptHelper(WebDriver driver) {
        this.driver = driver;
        System.out.println("JavaScriptHelper has been initialised");
    }

    public Object executeScript(String script) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script);
    }

    public Object executeScript(String script, Object... args) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);
    }

    public void scrollToElement(WebElement element) {
        log.info("scroll to WebElement...");
        System.out.println("scroll to WebElement...");
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
    }

    public void scrollToElementAndClick(WebElement element) {
        scrollToElement(element);
        element.click();
        System.out.println("element is clicked: " + element.toString());
        log.info("element is clicked: " + element.toString());
    }

    public void scrollIntoView(WebElement element) {
        log.info("scroll till web element");
        System.out.println("scroll till web element");
        executeScript("arguments[0].scrollIntoView()", element);
    }

    public void scrollIntoViewAndClick(WebElement element) {
        scrollIntoView(element);
        element.click();
        System.out.println("element is clicked: " + element.toString());
        log.info("element is clicked: " + element.toString());
    }

    public void scrollDownVertically() {
        log.info("scrolling down vertically...");
        System.out.println("scrolling down vertically...");
        executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void scrollUpVertically() {
        log.info("scrolling up vertically...");
        System.out.println("scrolling up vertically...");
        executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    public void scrollDownByPixel(int pixel) {
        executeScript("window.scrollBY(0," + pixel + ")");
    }

    public void scrollUpByPixel(int pixel) {
        executeScript("window.scrollBY(0,-" + pixel + ")");
    }

    public void zoomInBy100Percentage() {
        executeScript("document.body.style.zoom='100%'");
    }

    public void zoomInBy60Percentage() {
        executeScript("document.body.style.zoom='40%'");
    }

    public void clickElement(WebElement element) {
        System.out.println("Click on the element");
        executeScript("arguments[0].click();", element);
    }


}
