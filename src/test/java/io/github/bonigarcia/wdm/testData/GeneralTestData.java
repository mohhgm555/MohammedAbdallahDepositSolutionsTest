package io.github.bonigarcia.wdm.testData;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralTestData {
    //Generates a random 8 digits alpha numeric passwords with special characters
    public String getPwd(Integer passwordLength) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random(passwordLength, characters);
        return pwd;
    }

    //Generates a Timestamp to be added to different test data
    public String getTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        String timestamp = dateFormat.format(new Date());
        return timestamp;
    }
}
