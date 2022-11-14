package pages;


import helper.assertion.AssertionHelper;
import helper.logger.LoggerHelper;
import com.google.common.collect.Ordering;
import drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BPage extends DriverFactory {
    public static Logger log = LoggerHelper.getLogger(BPage.class);
    public static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
    public static AssertionHelper assertionHelper = new AssertionHelper();

    public BPage() throws IOException {
        PageFactory.initElements(getDriver(), this);
    }

    public static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public static void click(WebDriver driver, WebElement ele) {
        Actions act = new Actions(driver);
        System.out.println("clicking on the element....: " + ele.getText());
        log.info("clicking on the element....: " + ele.getText());
        act.moveToElement(ele).click().build().perform();
    }

    public static boolean findElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();

            flag = true;
        } catch (Exception e) {

            flag = false;
        } finally {
            if (flag) {
                //log.info("Successfully Found element as :" + ele.getText());
                //System.out.println("Successfully Found element as :" + ele.getText());
            } else {
                System.out.println("Unable to locate element at");
            }
        }
        return flag;
    }

    public static boolean isDisplayed(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isDisplayed();
            if (flag) {

                System.out.println("The element is Displayed as:  " + "<" + ele.getText() + ">");
                log.info("The element is Displayed as: " + "<" + ele.getText() + ">");
            } else {
                System.out.println("The element is not Displayed");
                log.error("The element is not Displayed: " + "<" + ele.getText() + ">");
            }
        } else {
            System.out.println("element Not displayed... ");
            log.error("element Not displayed...");
            System.out.println("element Not displayed...");
        }
        return flag;
    }

    public static boolean isSelected(WebDriver driver, WebElement ele) {

        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isSelected();
            if (flag) {
                System.out.println("The element is Selected:  " + "<" + ele.getText() + ">");
                log.info("The element is Selected:  " + "<" + ele.getText() + ">");
            } else {
                System.out.println("The element is not Selected");
            }
        } else {
            System.out.println("Not selected ");
        }
        return flag;
    }

    public static boolean isEnabled(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isEnabled();
            if (flag) {
                System.out.println("The element is Enabled: " + "<" + ele.getText() + ">");
                log.info("The element is " + ele.getText() + " Enabled");
            } else {
                System.out.println("The element is not Enabled: " + "<" + ele.getText() + ">");
                log.info("The element is not Enabled");
            }
        } else {
            System.out.println("Not Enabled ");
        }
        return flag;
    }

    public static boolean type(WebElement ele, String text) {
        boolean flag = false;
        try {
            flag = ele.isDisplayed();
            ele.clear();
            ele.sendKeys(text);
            System.out.println("Entered text :" + text);
            log.info("Entered text :" + text);
            flag = true;
        } catch (Exception e) {
            System.out.println("Location Not found");
            log.info("Location Not found");
            flag = false;
        } finally {
            if (flag) {
                log.info("Successfully entered value");
            } else {
                log.info("Unable to enter value");
            }

        }
        return flag;
    }

    public static boolean selectBySendKeys(String value, WebElement ele) {
        boolean flag = false;
        try {
            ele.sendKeys(value);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Select value from the DropDown" + value);
                log.info("Select value from the DropDown: " + value);
            } else {
                System.out.println("Not Selected value from the DropDown");
                log.info("Not Selected value from the DropDown");
                // throw new ElementNotFoundException("", "", "")
            }
        }
    }

    public static boolean selectByIndex(WebElement element, int index) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByIndex(index);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by Index: " + "<" + index + ">");
                log.info("Option selected by Index: " + "<" + index + ">");
            } else {
                System.out.println("Option not selected by Index: " + "<" + index + ">");
                log.info("Option not selected by Index:  " + "<" + index + ">");
            }
        }
    }

    public static boolean selectByValue(WebElement element, String value) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByValue(value);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by Value:" + "<" + value + ">");
                log.info("Option selected by Value: " + "<" + value + ">");
            } else {
                System.out.println("Option not selected by Value");
            }
        }
    }

    public static boolean selectByVisibleText(String visibletext, WebElement ele) {

        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(visibletext);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by VisibleText: " + "<" + visibletext + ">");
                log.info("Option selected by VisibleText: " + "<" + visibletext + ">");
            } else {
                System.out.println("Option not selected by VisibleText");
                log.error("Option selected by VisibleText : " + "<" + visibletext + ">");
            }
        }
    }

    public static boolean JSClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
            // driver.executeAsyncScript("arguments[0].click();", element);

            flag = true;

        } catch (Exception e) {
            throw e;

        } finally {
            if (flag) {
                System.out.println("Click Action is performed on =>"+ele.getText());
                log.info("Click Action is performed");
            } else if (!flag) {
                System.out.println("Click Action is not performed");
            }
        }
        return flag;
    }

    public static boolean switchToFrameByIndex(WebDriver driver, int index) {
        boolean flag = false;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
            driver.switchTo().frame(index);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with index \"" + index + "\" is selected");
                log.info("Frame with index \"" + index + "\" is selected");
            } else {
                System.out.println("Frame with index \"" + index + "\" is not selected");
                log.info("Frame with index \"" + index + "\" is not selected");

            }
        }
    }

    /**
     * This method switch the to frame using frame ID.
     *
     * @param idValue : Frame ID wish to switch
     */

    public static boolean switchToFrameById(WebDriver driver, String idValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(idValue);
            flag = true;
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with Id \"" + idValue + "\" is selected");
                log.info("Frame with Id \"" + idValue + "\" is selected");

            } else {
                System.out.println("Frame with Id \"" + idValue + "\" is not selected");
                log.info("Frame with Id \"" + idValue + "\" is not selected");
            }
        }
    }

    /**
     * This method switch the to frame using frame Name.
     *
     * @param nameValue : Frame Name wish to switch
     */

    public static boolean switchToFrameByName(WebDriver driver, String nameValue) {

        boolean flag = false;
        try {
            driver.switchTo().frame(nameValue);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with Name \"" + nameValue + "\" is selected");
                log.info("Frame with Name \"" + nameValue + "\" is selected");

            } else if (!flag) {
                System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
                log.info("Frame with Name \"" + nameValue + "\" is not selected");

            }
        }
    }

    public static boolean switchToDefaultFrame(WebDriver driver) {
        boolean flag = false;
        try {
            driver.switchTo().defaultContent();
            flag = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                log.info("SelectFrame: Frame with Name is selected ");
                System.out.println("SelectFrame: Frame with Name is selected");
            } else if (!flag) {
                log.info("SelectFrame: The Frame is not selected ");
                System.out.println("SelectFrame => The Frame is not selected");
            }
        }
    }

    public static void mouseOverElement(WebDriver driver, WebElement element) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(element).build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                System.out.println(" MouserOver Action is performed on: " + element.getText());
                log.info(" MouserOver Action is performed on: " + element.getText());
            } else {
                System.out.println("MouseOver axe is not performed on");
                log.info("MouseOver axe is not performed on");
            }
        }
    }

    public static boolean moveToElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", ele);
            Actions actions = new Actions(driver);
            // actions.moveToElement(driver.findElement(locator)).build().perform();
            actions.moveToElement(ele).build().perform();
            flag = true;
            System.out.println("MouseOver axe is not performed on");
            log.info("MouseOver axe is not performed on");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean mouseover(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(ele).build().perform();
            flag = true;
            return true;

        } catch (Exception e) {
            return false;
        } finally {
            System.out.println("MouseOver axe performed on");
            log.info("MouseOver axe performed on");

            if (flag) {
                System.out.println("MouseOver axe performed on");
            } else {

            }

        }
    }

    public static boolean draggable(WebDriver driver, WebElement source, int x, int y) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDropBy(source, x, y).build().perform();
            Thread.sleep(5000);
            flag = true;
            return true;

        } catch (Exception e) {

            return false;

        } finally {
            if (flag) {
                System.out.println("Draggable Action is performed on \"" + source + "\"");
                log.info("Draggable Action is performed on \"" + source + "\"");
            } else if (!flag) {
                System.out.println("Draggable axe is not performed on \"" + source + "\"");
                log.info("Draggable axe is not performed on \"" + source + "\"");
            }
        }
    }

    public static boolean dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDrop(source, target).perform();
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("DragAndDrop Action is performed");
                log.info("DragAndDrop Action is performed");
            } else if (!flag) {
                System.out.println("DragAndDrop Action is not performed");
                log.info("DragAndDrop Action is not performed");
            }
        }
    }

    public static boolean slider(WebDriver driver, WebElement ele, int x, int y) {
        boolean flag = false;
        try {
            // new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
            // .perform();
            new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
            Thread.sleep(5000);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Slider Action is performed");
                log.info("Slider Action is performed");
            } else {
                System.out.println("Slider Action is not performed");
                log.info("Slider Action is not performed");

            }
        }
    }

    public static boolean rightClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            Actions clicker = new Actions(driver);
            clicker.contextClick(ele).perform();
            flag = true;
            return true;
            // driver.findElement(by1).sendKeys(Keys.DOWN);
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("RightClick Action is performed");
                log.info("RightClick Action is performed");
            } else {
                System.out.println("RightClick Action is not performed");
                log.info("RightClick Action is not performed");
            }
        }
    }

    public static boolean switchToNewWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s = driver.getWindowHandles();
            Object popup[] = s.toArray();
            driver.switchTo().window(popup[1].toString());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        } finally {
            if (flag) {
                System.out.println("Window is Navigated with title");
                log.info("Window is Navigated with title");
            } else {
                System.out.println("The Window with title: is not Selected");
                log.info("The Window with title: is not Selected");
            }
        }
    }

    public static boolean switchToOldWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s = driver.getWindowHandles();
            Object popup[] = s.toArray();
            driver.switchTo().window(popup[0].toString());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        } finally {
            if (flag) {
                log.info("Focus navigated to the window with title");
                System.out.println("Focus navigated to the window with title");
            } else {
                log.info("The Window with title: is not Selected");
                System.out.println("The Window with title: is not Selected");
            }
        }
    }

    /**
     * Verify alert present or not
     *
     * @return: Boolean (True: If alert preset, False: If no alert)
     */

    public static boolean Alert(WebDriver driver) {
        boolean presentFlag = false;
        Alert alert = null;

        try {
            // Check the presence of alert
            alert = driver.switchTo().alert();
            // if present consume the alert
            alert.accept();
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            // Alert present; set the flag

            // Alert not present
            ex.printStackTrace();
        } finally {
            if (!presentFlag) {
                System.out.println("The Alert is handled successfully");
                log.info("The Alert is handled successfully");
            } else {
                System.out.println("There was no alert to handle");
                log.info("There was no alert to handle");
            }
        }

        return presentFlag;
    }

    public static boolean launchUrl(WebDriver driver, String url) {
        boolean flag = false;
        try {
            driver.navigate().to(url);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Successfully launched \"" + url + "\"");
                log.info("Successfully launched \"" + url + "\"");
            } else {
                log.info("Failed to launch \"" + url + "\"");
                System.out.println("Failed to launch \"" + url + "\"");
            }
        }
    }

    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex) {
            return false;
        }   // catch
    }

    public static String getTitle(WebDriver driver) {
        boolean flag = false;

        String text = driver.getTitle();
        if (flag) {
            log.info("Title of the page is: \"" + text + "\"");
            System.out.println("Title of the page is: \"" + text + "\"");
        }
        return text;
    }

    public static String getCurrentURL(WebDriver driver) {
        Logger log = LoggerHelper.getLogger(BPage.class);
        boolean flag = false;

        String text = driver.getCurrentUrl();

        if (flag) {
            System.out.println("Current URL is: \"" + text + "\"");
            log.info("Current URL is: \"" + text + "\"");
            System.out.print("Current URL is: \"" + text + "\"");
        }

        return text;
    }

    public static boolean click1(WebElement locator, String locatorName) {
        boolean flag = false;
        try {
            locator.click();
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Able to click on \"" + locatorName + "\"");
                log.info("Able to click on \"" + locatorName + "\"");
            } else {
                System.out.println("Click Unable to click on \"" + locatorName + "\"");
                log.info("Click Unable to click on \"" + locatorName + "\"");
            }
        }

    }

    public static void fluentWait(WebDriver driver, WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception e) {
        }
    }

    public static void implicitWait(WebDriver driver, int timeOut) {
        Logger log = LoggerHelper.getLogger(BPage.class);
        System.out.println("implicitlyWait for 1 timeOut");
        log.info("implicitlyWait for 10 timeOut");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
        log.info("page Loading for TimeOut...........");
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    public static String getCurrentTime() {
        System.out.println("CurrentTime performed....");
        log.info("CurrentTime performed....");
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDate;
    }

    public static boolean isPresent(WebDriver webdriver, By selector) {
        try {
            webdriver.findElement(selector);
        } catch (NoSuchElementException e) {
            // if element not exist return false
            return false;
        }
        return true;
    }

    public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(30))).until(ExpectedConditions.elementToBeClickable(selector));
        log.info("waiting for element to be clickable...");
        return element;
    }

    public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(30))).until(ExpectedConditions.presenceOfElementLocated(selector));
        log.info("waiting for element appearance...");
        return element;
    }

    public static void waitForTitle(WebDriver driver, String title, int waitInterval) {
        log.info("waiting for title appearance...");
        (new WebDriverWait(driver, Duration.ofSeconds(30))).until(ExpectedConditions.titleIs(title));
    }


    public static void sleep(long msec, String info) {
        if (info != null) {
            log.info("Waiting " + (msec * .001) + " seconds :: " + info);
            System.out.println("Waiting " + (msec * .001) + " seconds :: " + info);
        }
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /***
     * Sleep for specified number of milliseconds
     * @param msec
     */
    public static void sleep(long msec) {
        sleep(msec, null);
    }

    /***
     *
     * @param methodName
     * @param browserName
     * @return
     */
    public static String getScreenshotName(String methodName, String browserName) {
        String localDateTime = getCurrentDateTime();
        StringBuilder name = new StringBuilder().append(browserName)
                .append("_")
                .append(methodName)
                .append("_")
                .append(localDateTime)
                .append(".png");
        return name.toString();
    }

    /***
     * Get Random number within specified range
     * @param min
     * @param max
     * @return a random number
     */
    public static int getRandomNumber(int min, int max) {
        int diff = max - min;
        int randomNum = (int) (min + Math.random() * diff);
        log.info("Random Number :: " + randomNum +
                " within range :: " + min + " and :: " + max);
        System.out.println("Random Number :: " + randomNum +
                " within range :: " + min + " and :: " + max);

        return randomNum;
    }

    /***
     * Get Random number within specified range
     * @param number
     * @return a random number
     */
    public static int getRandomNumber(int number) {
        return getRandomNumber(1, number);
    }

    /***
     * Get random unique string with specified length
     * @param length
     * @return a unique string
     */
    public static String getRandomString(int length) {
        StringBuilder sbuilder = new StringBuilder();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sbuilder.append(chars.charAt(index));
        }
        String randomString = sbuilder.toString();
        System.out.println("Random string with length :: "
                + length + " is :: " + randomString);
        log.info("Random string with length :: "
                + length + " is :: " + randomString);
        return randomString;
    }

    /***
     * Get random unique string with 10 characters length
     * @return a unique string
     */
    public static String getRandomString() {
        return getRandomString(10);
    }

    /***
     * Get simple date as string in the specified format
     * @param format MMddyy MMddyyyy
     * @return date as string type
     */
    public static String getSimpleDateFormat(String format) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        String formattedDate = formatter.format(date);
        System.out.println("Date with format :: "
                + format + " :: " + formattedDate);
        log.info("Date with format :: "
                + format + " :: " + formattedDate);
        return formattedDate;
    }

    /***
     * Get simple date time as string
     * @return date time as string type
     */
    public static String getCurrentDateTime() {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(
                "MM/dd/yyyy HH:mm:ss");
        String date = formatter.format(currentDate.getTime()).replace("/", "_");
        date = date.replace(":", "_");
        System.out.println("Date and Time :: " + date);
        log.info("Date and Time :: " + date);
        return date;
    }

    /**
     * Checks whether actual String contains expected string and prints both in log
     *
     * @param actualText - actual Text picked up from application under Test
     * @param expText    - expected Text to be checked with actual text
     * @return boolean result
     */
    public static boolean verifyTextContains(String actualText, String expText) {
        if (actualText.toLowerCase().contains(expText.toLowerCase())) {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            System.out.println("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            System.out.println("Expected Text From Web Application UI --> : " + expText);
            log.info("### Contains Verified !!!");
            System.out.println("### Contains Verified !!!");
            return true;
        } else {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            System.out.println("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            System.out.println("Expected Text From Web Application UI --> : " + expText);
            log.info("### Verification DOES NOT Contains !!!");
            System.out.println("### Verification DOES NOT Contains !!!");
            ;

            return false;
        }

    }

    /**
     * Checks whether actual string matches with expected string and prints both in log
     *
     * @param actualText - actual Text picked up from application under Test
     * @param expText    - expected Text to be matched with actual text
     * @return
     */
    public static boolean verifyTextMatch(String actualText, String expText) {
        if (actualText.equals(expText)) {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            System.out.println("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            System.out.println("Expected Text From Web Application UI --> : " + expText);
            log.info("### Verification MATCHED !!!");
            System.out.println("### Verification MATCHED !!!");
            return true;
        } else {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            System.out.println("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            System.out.println("Expected Text From Web Application UI --> : " + expText);
            log.info("### Verification DOES NOT MATCH !!!");
            System.out.println("### Verification DOES NOT MATCH !!!");
            return false;
        }
    }

    /**
     * Verify actual list contains items of the expected list
     *
     * @param actList
     * @param expList
     * @return
     */
    public static Boolean verifyListContains(List<String> actList, List<String> expList) {
        int expListSize = expList.size();
        for (int i = 0; i < expListSize; i++) {
            if (!actList.contains(expList.get(i))) {
                return false;
            }
        }
        log.info("Actual List Contains Expected List !!!");
        System.out.println("Actual List Contains Expected List !!!");
        return true;
    }

    /***
     * Verify actual list matches expected list
     * @param actList
     * @param expList
     * @return
     */
    public static Boolean verifyListMatch(List<String> actList, List<String> expList) {
        boolean found = false;
        int actListSize = actList.size();
        int expListSize = expList.size();
        if (actListSize != expListSize) {
            return false;
        }

        for (int i = 0; i < actListSize; i++) {
            found = false;
            for (int j = 0; j < expListSize; j++) {
                if (verifyTextMatch(actList.get(i), expList.get(j))) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            log.info("Actual List Matches Expected List !!!");
            System.out.println("Actual List Matches Expected List !!!");
            return true;
        } else {
            log.info("Actual List DOES NOT Match Expected List !!!");
            System.out.println("Actual List DOES NOT Match Expected List !!!");
            return false;
        }
    }

    /**
     * Verifies item is present in the list
     *
     * @param actList
     * @param item
     * @return boolean result
     */
    public static Boolean verifyItemPresentInList(List<String> actList, String item) {
        int actListSize = actList.size();
        for (int i = 0; i < actListSize; i++) {
            if (!actList.contains(item)) {
                log.info("Item is NOT present in List !!!");
                System.out.println("Item is NOT present in List !!!");
                return false;
            }
        }
        log.info("Item is present in List !!!");
        System.out.println("Item is present in List !!!");
        return true;
    }

    /**
     * Verify if list is in ascending order
     *
     * @param list
     * @return boolean result
     */
    public static boolean isListAscendingOrder(List<Long> list) {
        boolean sorted = Ordering.natural().isOrdered(list);
        return sorted;
    }

    public static void explicitWait(WebDriver driver, WebElement element, int timeOut) {
        Logger log = LoggerHelper.getLogger(BPage.class);
        System.out.println("explicitWait waiting.....:" +element.getText());
        log.info("explicitWait waiting.....:" +element.getText());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Done with waiting......");
    }

    public void navigateToIndexPage(String url) {
        log.info("navigate To IndexPage....: " +url);
        getDriver().get(url);
    }

    public void goToIndexPageUrl(String url) {
        log.info("navigating To Index Page....: " +url);
        getDriver().get(url);
    }
    public String getCurrentPageTitle(String url) throws InterruptedException {
        log.info("got current Page Title....: " +url);
        return getDriver().getTitle();
    }

    public String generateRandomNumber(int length) {
        log.info("generating Random Number....: " +length);
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        log.info("generating Random String....: " +length);
        return RandomStringUtils.randomAlphabetic(length);
    }

    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
        log.info("Waited and Entered text :" + textToType);
    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        element.clear();
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
        System.out.println("Waited and Entered text :" + textToType);
        log.info("Waited and Entered text :" + textToType);
    }

    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("waited for....." +element.getText());
    }

    public void waitForWebElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        log.info("element clicked....." +by);
    }

    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        log.info("element clicked....." +element);
    }

    public void waitForAlert_And_ValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, text);
    }

    public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
        boolean flag = false;
        try {
            Set<String> windowList = driver.getWindowHandles();

            String[] array = windowList.toArray(new String[0]);

            driver.switchTo().window(array[count - 1]);

            if (driver.getTitle().contains(windowTitle)) {
                flag = true;
            } else {
                flag = false;
            }
            return flag;
        } catch (Exception e) {
            //flag = true;
            return false;
        } finally {
            if (flag) {
                System.out.println("Navigated to the window with title");
                log.info("Navigated to the window with title");
            } else {
                System.out.println("The Window with title is not Selected");
                log.info("The Window with title is not Selected");
            }
        }
    }

    public int getColumnCount(WebElement row) {
        List<WebElement> columns = row.findElements(By.tagName("td"));
        int a = columns.size();
        System.out.println(columns.size());
        for (WebElement column : columns) {

            System.out.print(column.getText());
            System.out.print("|");
        }
        return a;

    }

    public String screenShot(WebDriver driver, String filename) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        // This new path for jenkins
        String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
                + dateName + ".png";
        return newImageString;
    }

    /**********************************************************************************
     **CLICK METHODS
     * @throws IOException
     **********************************************************************************/
    public static void waitAndClickElement(WebElement element) throws InterruptedException, IOException {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                log.info("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");

                clicked = true;
            } catch (Exception e) {
                log.info("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }

    public void waitAndClickElementsUsingByLocator(By by) {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(by)).click();
                log.info("Successfully clicked on the element using by locator: " + "<" + by.toString() + ">");
                System.out.println("Successfully clicked on the element using by locator: " + "<" + by.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                log.info("Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());
                System.out.println("Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());

                Assert.fail("Unable to wait and click on the element using the By locator, element: " + "<"+ by.toString() + ">");
            }
            attempts++;
        }
    }

    public void clickOnTextFromDropdownList(WebElement list, String textToSearchFor) throws Exception {
        Wait<WebDriver> tempWait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        try {
            tempWait.until(ExpectedConditions.elementToBeClickable(list)).click();
            list.sendKeys(textToSearchFor);
            list.sendKeys(Keys.ENTER);
            log.info("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            System.out.println("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
        } catch (Exception e) {
            log.info("Unable to send the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
        System.out.println("Unable to send the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            Assert.fail("Unable to select the required text from the dropdown menu, Exception: " + e.getMessage());
        }
    }


    public void clickOnElementUsingCustomTimeout(WebElement locator, WebDriver driver, int timeout) {
        try {
            final WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            customWait.until(ExpectedConditions.elementToBeClickable(locator));
            locator.click();
            System.out.println("Successfully clicked on the WebElement, using locator: " + "<" + locator + ">"+ ", using a custom Timeout of: " + timeout);
        } catch (Exception e) {
            System.out.println("Unable to click on the WebElement, using locator: " + "<" + locator + ">" + ", using a custom Timeout of: " + timeout);
            Assert.fail("Unable to click on the WebElement, Exception: " + e.getMessage());
        }
    }


    /**********************************************************************************
     **ACTION METHODS
     **********************************************************************************/

    public void actionMoveAndClick(WebElement element) throws Exception {
        Actions ob = new Actions(getDriver());
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            ob.moveToElement(element).click().build().perform();
           log.info("Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            System.out.println("Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
            if (elementPresent == true) {
                ob.moveToElement(elementToClick).click().build().perform();
                System.out.println("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
        } catch (Exception e) {
            System.out.println("Unable to Action Move and Click on the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Move and Click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public void actionMoveAndClickByLocator(By element) throws Exception {
        Actions ob = new Actions(getDriver());
        try {
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            if (elementPresent == true) {
                WebElement elementToClick = getDriver().findElement(element);
                ob.moveToElement(elementToClick).click().build().perform();
                System.out.println("Action moved and clicked on the following element, using By locator: " + "<" + element.toString() + ">");
            }
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = getDriver().findElement(element);
            ob.moveToElement(elementToClick).click().build().perform();
            System.out.println("(Stale Exception) - Action moved and clicked on the following element, using By locator: "+ "<" + element.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to Action Move and Click on the WebElement using by locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Move and Click on the WebElement using by locator, Exception: " + e.getMessage());
        }
    }

    /**********************************************************************************
     **SEND KEYS METHODS /
     **********************************************************************************/
    public void sendKeysToWebElement(WebElement element, String textToSend) throws Exception {
        try {
            this.WaitUntilWebElementIsVisible(element);
            element.clear();
            element.sendKeys(textToSend);
            System.out.println("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"+ element.toString() + ">");
            log.info("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"+ element.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
            log.info("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);

            Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
    }

    /**********************************************************************************/
    /**********************************************************************************/


    /**********************************************************************************
     **JS METHODS & JS SCROLL
     **********************************************************************************/
    public void scrollToElementByWebElementLocator(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
            ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, -400)");
            log.info("Succesfully scrolled to the WebElement, using locator: " + "<" + element.toString() + ">");
            System.out.println("Succesfully scrolled to the WebElement, using locator: " + "<" + element.toString() + ">");

        } catch (Exception e) {
            System.out.println("Unable to scroll to the WebElement, using locator: " + "<" + element.toString() + ">");
            log.info("Unable to scroll to the WebElement, using locator: " + "<" + element.toString() + ">");

            Assert.fail("Unable to scroll to the WebElement, Exception: " + e.getMessage());
        }
    }

    public void jsPageScroll(int numb1, int numb2) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("scroll(" + numb1 + "," + numb2 + ")");
            System.out.println("Succesfully scrolled to the correct position! using locators: " + numb1 + ", " + numb2);
            log.info("Succesfully scrolled to the correct position! using locators: " + numb1 + ", " + numb2);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element using locators: " + "<" + numb1 + "> " + " <" + numb2 + ">");
            log.info("Unable to scroll to element using locators: " + "<" + numb1 + "> " + " <" + numb2 + ">");

            Assert.fail("Unable to manually scroll to WebElement, Exception: " + e.getMessage());
        }
    }

    public void waitAndclickElementUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            js.executeScript("arguments[0].click();", element);
            log.info("Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
            System.out.println("Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");

        } catch (StaleElementReferenceException elementUpdated) {
            WebElement staleElement = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(staleElement)).isEnabled();
            if (elementPresent == true) {
                js.executeScript("arguments[0].click();", elementPresent);
                log.info("(Stale Exception) Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
                System.out.println("(Stale Exception) Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");

            }
        } catch (NoSuchElementException e) {
            System.out.println("Unable to JS click on the following WebElement: " + "<" + element.toString() + ">");
            Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        log.info("jsClick clicked the element");
        js.executeScript("arguments[0].click();", element);
    }


    /**********************************************************************************
     **WAIT METHODS
     **********************************************************************************/
    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            log.info("WebElement is visible using locator: " + "<" + element.toString() + ">");
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            log.info("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");

            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean WaitUntilWebElementIsVisibleUsingByLocator(By element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            System.out.println("Element is visible using By locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using By locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementClickable(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element));
            log.info("WebElement is clickable using locator: " + "<" + element.toString() + ">");
            System.out.println("WebElement is clickable using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            log.info("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
            System.out.println("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
            return false;
        }
    }


    public boolean waitUntilPreLoadElementDissapears(By element) {
        return this.wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    /**********************************************************************************/
    /**********************************************************************************/


    /**********************************************************************************
     **PAGE METHODS
     **********************************************************************************/
    public BPage loadUrl(String url) throws Exception {
        getDriver().get(url);
        return new BPage();
    }


    public String getCurrentURL() {
        try {
            String url = getDriver().getCurrentUrl();
            System.out.println("Found(Got) the following URL: " + url);
            return url;
        } catch (Exception e) {
            System.out.println("Unable to locate (Get) the current URL, Exception: " + e.getMessage());
            return e.getMessage();
        }
    }

    public String waitForSpecificPage(String urlToWaitFor) {
        try {
            String url = getDriver().getCurrentUrl();
            this.wait.until(ExpectedConditions.urlMatches(urlToWaitFor));
            System.out.println("The current URL was: " + url + ", " + "navigated and waited for the following URL: "+ urlToWaitFor);
            return urlToWaitFor;
        } catch (Exception e) {
            System.out.println("Exception! waiting for the URL: " + urlToWaitFor + ",  Exception: " + e.getMessage());
            return e.getMessage();
        }
    }

    /**********************************************************************************
     **ALERT & POPUPS METHODS
     **********************************************************************************/
    public void closePopups(By locator) throws InterruptedException {
        try {
            List<WebElement> elements = this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    element.click();
                    this.wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
                    System.out.println("The popup has been closed Successfully!");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception! - could not close the popup!, Exception: " + e.toString());
            throw (e);
        }
    }

    public boolean checkPopupIsVisible() {
        try {
            @SuppressWarnings("unused")
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("A popup has been found!");
            return true;
        } catch (Exception e) {
            System.err.println("Error came while waiting for the alert popup to appear. " + e.getMessage());
        }
        return false;
    }

    public boolean isAlertPresent() {
        try {
            getDriver().switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void closeAlertPopupBox() throws AWTException, InterruptedException {
        try {
            Alert alert = this.wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (UnhandledAlertException f) {
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("Unable to close the popup");
            Assert.fail("Unable to close the popup, Exception: " + e.getMessage());
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is Displayed.." + element.getText());
            //TestBase.logExtentReport("element is Displayed.." + element.getText());
            return true;
        } catch (Exception e) {
            log.error("element is not Displayed..", e.getCause());
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is present.." + element.getText());
            //TestBase.logExtentReport("element is present.." + element.getText());

            return false;
        } catch (Exception e) {
            log.error("element is not present..");
            //TestBase.logExtentReport("element is not present..");
            return true;
        }
    }

    public String readValueFromElement(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            //TestBase.logExtentReport("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is .." + element.getText());
            //TestBase.logExtentReport("element text is .." + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getText(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            //TestBase.logExtentReport("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is .." + element.getText());
            //TestBase.logExtentReport("element text is .." + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getTitle() {
        log.info("page title is: " + getDriver().getTitle());
        return getDriver().getTitle();
    }
}