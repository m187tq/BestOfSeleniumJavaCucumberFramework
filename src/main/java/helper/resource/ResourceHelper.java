package helper.resource;

import org.testng.annotations.Test;

public class ResourceHelper {

    @Test
    public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
        System.out.println(basePath + "/" + path);
        return basePath + "/" + path;
    }
}
