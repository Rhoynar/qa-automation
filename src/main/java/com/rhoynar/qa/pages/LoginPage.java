package com.rhoynar.qa.pages;

import com.rhoynar.qa.framework.ReadProperties;
import com.rhoynar.qa.framework.WebApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.Properties;

/**
 * Created by Harsh on 9/15/16.
 */
public class LoginPage {
    // Page Object for Login Page.
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    private static Map<String, String> data;
    private static WebDriver driver;
    private static int timeout = 5;
    private static final String pageLoadedText = "Yahoo Mail";

    /* Constructors */
    public LoginPage() {
    }

    public LoginPage(WebDriver aDriver) {
        this.driver = aDriver;
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage(WebDriver aDriver, Map<String, String> data) {
        this(aDriver);
        this.data = data;
    }

    public LoginPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    public LoginPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
        }
        return this;
    }

    @FindBy(id="login-username")
    WebElement username;

    @FindBy(id="login-signin")
    WebElement loginBtn;

    @FindBy(id="login-passwd")
    WebElement password;

    /**
     * Login with specified credentials.
     */
    public void login(String uname, String passwd) {
        username.click();
        username.sendKeys(uname);
        loginBtn.click();
        verifyPageLoaded();

        password.click();
        password.sendKeys(passwd);
        loginBtn.click();
        verifyPageLoaded();
    }

    /**
     * Login with configured credentials
     */
    public void login() {
        Properties props = ReadProperties.getProperties();
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        login(username, password);
    }

    public boolean verifyMainPage() {
        boolean ret = true;
        String pageSource = WebApp.getDriver().getPageSource();
        ret = ret && pageSource.contains("Inbox");
        ret = ret && pageSource.contains("Drafts");
        ret = ret && pageSource.contains("Sent");
        ret = ret && pageSource.contains("Archive");
        return ret;
    }
}
