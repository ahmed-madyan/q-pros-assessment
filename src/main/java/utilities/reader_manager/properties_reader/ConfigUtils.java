package utilities.reader_manager.properties_reader;

public class ConfigUtils {
    private static final String CONFIG_PROPERTIES_FILE_PATH = "/src/main/resources/Config.properties";
    private static String portal_URl;

    private static void setConfigProperties() {
        portal_URl = PropertiesDataManager.getProperty("portal_URL", CONFIG_PROPERTIES_FILE_PATH);
    }

    public static String get_PortalURL() {
        setConfigProperties();
        return portal_URl;
    }
}