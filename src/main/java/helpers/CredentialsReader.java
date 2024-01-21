package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CredentialsReader {
    private final String userEmail;
    private final String userPassword;

    public CredentialsReader() {
        String configPath = "src/test/resources/credentials.properties";
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
        userEmail = properties.getProperty("userEmail");
        userPassword = properties.getProperty("userPassword");
    }
    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
