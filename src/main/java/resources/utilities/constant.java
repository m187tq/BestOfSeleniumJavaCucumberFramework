package resources.utilities;

public class constant {

    /**
     * Config Properties file
     **/
    public final static String CONFIG_PROPERTIES_DIRECTORY = "properties\\config.properties";


    public final static String GECKO_DRIVER_DIRECTORY = System.getProperty("user.dir") + "drivers\\geckodriver.exe";

    public final static String CHROME_DRIVER_DIRECTORY = System.getProperty("user.dir") + "drivers\\chromedriver.exe";

    public final static String IE_DRIVER_DIRECTORY = System.getProperty("user.dir") + "drivers\\IEDriverServer.exe";

    public final static String userName = "datastudioplace";
    public final static String password = "Manchester1";

    public final static int explicitWait = 100;
    public final static int implicitWait = 100;

    public static String getConfigPropertiesDirectory() {
        return CONFIG_PROPERTIES_DIRECTORY;
    }

    public static String getGeckoDriverDirectory() {
        return GECKO_DRIVER_DIRECTORY;
    }

    public static String getChromeDriverDirectory() {
        return CHROME_DRIVER_DIRECTORY;
    }

    public static String getIeDriverDirectory() {
        return IE_DRIVER_DIRECTORY;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public static int getExplicitWait() {
        return explicitWait;
    }

    public static int getImplicitWait() {
        return implicitWait;
    }

}
