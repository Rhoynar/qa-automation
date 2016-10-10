package com.rhoynar.qa.framework;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Harsh on 10/10/16.
 */
public class ReadProperties {
    private static Properties prop = new Properties();

    public static Properties getProperties() {

        FileInputStream fileInput;
        File file = new File("src/main/resources/config/config.properties");

        try {

            fileInput = new FileInputStream(file);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
            return null;
        }

        // load properties file
        try {
            prop.load(fileInput);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
