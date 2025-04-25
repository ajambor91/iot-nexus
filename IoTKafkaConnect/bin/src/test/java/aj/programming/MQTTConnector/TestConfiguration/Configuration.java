package aj.programming.MQTTConnector.TestConfiguration;

public class Configuration {

    private static boolean shouldTestWithRealMQTT;

    static {
        Configuration.shouldTestWithRealMQTT = false;
    }

    public static boolean shouldTestWithRealMQTT() {
        return Configuration.shouldTestWithRealMQTT;
    }

    private static String getPoperty(String propName) {
        try {
            return System.getProperty(propName);

        } catch (Exception e) {
            return null;
        }
    }

    private static boolean parseToBool(String configValue) {
        return configValue != null ? configValue.equalsIgnoreCase("true") : false;
    }
}
