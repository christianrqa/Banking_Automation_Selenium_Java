package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {

    private Properties properties;

    public TestDataReader() {
        properties = new Properties();

        try (InputStream input =
                     getClass().getClassLoader()
                             .getResourceAsStream("testdata/login-data.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "login-data.properties file not found"
                );
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load login test data",
                    e
            );
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
    public static void main(String[] args) {
    TestDataReader testData = new TestDataReader();

    System.out.println(
            testData.get("standard.username")
    );

    System.out.println(
            testData.get("standard.password")
    );
}
}