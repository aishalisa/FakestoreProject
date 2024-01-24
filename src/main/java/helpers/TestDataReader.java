package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
    private final String baseURL;

    public TestDataReader(){
        String configPath = "src/test/resources/testData.properties";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(configPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file was not found at " + configPath);
        }
        Properties properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseURL = properties.getProperty("baseURL");
    }
    public String getBaseURL(){
        if(!baseURL.isEmpty()) return baseURL;
        else throw new RuntimeException("\"baseURL\" is not specified in the Configuration.properties file.");
    }

}
