package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CredentialsReader {
    private final String userEmail;
    private final String userPassword;
    private final String surname;
    private final String name;
    private final String street;
    private final String postCode;
    private final String city;
    private final String phone;
    private final String cardNumber;
    private final String cvc;
    private final String validDate;


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
        name = properties.getProperty("name");
        surname = properties.getProperty("surname");
        street = properties.getProperty("street");
        postCode = properties.getProperty("postCode");
        phone = properties.getProperty("phone");
        cardNumber = properties.getProperty("cardNumber");
        cvc = properties.getProperty("cvc");
        validDate = properties.getProperty("validDate");
        city = properties.getProperty("city");
    }
    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public String getValidDate() {
        return validDate;
    }

    public String getCity() {
        return city;
    }
}
