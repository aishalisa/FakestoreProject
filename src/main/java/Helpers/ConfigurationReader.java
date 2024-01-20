package Helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private final String baseURL;
    private final String userEmail;
    private final String userPassword;

    public ConfigurationReader(){
        String configPath = "src/test/resources/configuration.properties";
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
        userEmail = properties.getProperty("userEmail");
        userPassword = properties.getProperty("userPassword");
    }
    public String getBaseURL(){
        if(!baseURL.isEmpty()) return baseURL;
        else throw new RuntimeException("\"baseURL\" is not specified in the Configuration.properties file.");
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
