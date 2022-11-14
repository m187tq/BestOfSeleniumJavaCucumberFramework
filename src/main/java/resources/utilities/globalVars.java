package resources.utilities;

public class


globalVars {
    /**
     * Config Properties file
     **/
    public final static String CONFIG_PROPERTIES_DIRECTORY = "properties\\config.properties";


    public final static String GECKO_DRIVER_DIRECTORY = System.getProperty("user.dir") + "src\\main\\java\\driver\\geckodriver.exe";

    public final static String CHROME_DRIVER_DIRECTORY = System.getProperty("user.dir") + "src\\main\\java\\driver\\chromedriver.exe";

    public final static String IE_DRIVER_DIRECTORY = System.getProperty("user.dir") + "src\\main\\java\\driver\\IEDriverServer.exe";

    public final static String userName = "datastudioplace";
    public final static String password = "Manchester1";

    public final static int explicitWait = 30;
    public final static int DEFAULT_EXPLICIT_TIMEOUT = 15;
    public final static int DEFAULT_IMPLICIT_TIMEOUT = 60;
    public final static int implicitWait = 10;

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

    public static int getDefaultExplicitTimeout() {
        return DEFAULT_EXPLICIT_TIMEOUT;
    }

    public static int getDefaultImplicitTimeout() {
        return DEFAULT_IMPLICIT_TIMEOUT;
    }

}
