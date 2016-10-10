package com.rhoynar.qa.framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Properties;


/**
 * This class creates a static web browser instance that other classes/tests can use
 */
public class Browser {

    private static String browser;
    private static WebDriver driver;
    private static Properties props = ReadProperties.getProperties();

    public static WebDriver initializeDriver() {
        browser = props.getProperty("browser");
        if (browser == "firefox") {
            driver = new FirefoxDriver();
        } else if (browser == "chrome") {
            driver = new ChromeDriver();
        } else if (browser == "ie") {
            driver = new InternetExplorerDriver();
        } else {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void open(String url) {
        driver.get(url);
    }

    public static void close() {
        driver.close();
    }
}
