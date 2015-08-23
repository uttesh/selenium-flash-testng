package com.uttesh.seleniumflash;

import com.uttesh.seleniumflash.common.AppUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
/**
 * @author Uttesh Kumar T.H.
 */
public class SeleniumBase {

    private static BrowserType browserType;
    private static List<WebDriver> webDrivers = Collections.synchronizedList(new ArrayList<WebDriver>());
    private static ThreadLocal<WebDriver> driverForThread = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            WebDriver driver = loadWebDriver();
            webDrivers.add(driver);
            return driver;
        }
    };

    @BeforeSuite
    public static void setUpTest() throws IOException {
        //AppUtils.loadSikuliDlls();
        AppUtils.loadProperties();
        for (BrowserType browser : BrowserType.values()) {
            if (browser.toString().toLowerCase().equals(AppUtils.getProperty("browser").toLowerCase())) {
                browserType = browser;
            }
        }
        if (browserType == null) {
            System.err.println("Unknown browser specified, defaulting to 'Firefox'...");
            browserType = BrowserType.FIREFOX;
        }
    }

    protected static WebDriver getDriver() {
        return driverForThread.get();
    }

    private static WebDriver loadWebDriver() {
        if (browserType == null) {
            System.err.println("Unknown browser specified, defaulting to 'Firefox'...");
            browserType = BrowserType.FIREFOX;
        }
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", AppUtils.getProperty("webdriver.path"));
                break;
            case IE:
                System.setProperty("webdriver.ie.driver", AppUtils.getProperty("webdriver.path"));
                break;
        }
        switch (browserType) {
            case FIREFOX:
                return new FirefoxDriver(generateDesiredCapabilities(browserType));
            case CHROME:
                return new ChromeDriver(generateDesiredCapabilities(browserType));
            case IE:
                return new InternetExplorerDriver(generateDesiredCapabilities(browserType));
            case SAFARI:
                return new SafariDriver(generateDesiredCapabilities(browserType));
            default:
                return new HtmlUnitDriver(generateDesiredCapabilities(browserType));
        }
    }

    private static DesiredCapabilities generateDesiredCapabilities(BrowserType capabilityType) {
        DesiredCapabilities capabilities;

        switch (capabilityType) {
            case IE:
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capabilities.setCapability("requireWindowFocus", true);
                break;
            case SAFARI:
                capabilities = DesiredCapabilities.safari();
                capabilities.setCapability("safari.cleanSession", true);
                break;
            case CHROME:
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
                HashMap<String, String> chromePreferences = new HashMap<String, String>();
                chromePreferences.put("profile.password_manager_enabled", "false");
                capabilities.setCapability("chrome.prefs", chromePreferences);
                break;
            case FIREFOX:
                capabilities = DesiredCapabilities.firefox();
                break;
            case HTMLUNIT:
            default:
                capabilities = DesiredCapabilities.htmlUnit();
                capabilities.setCapability("javascriptEnabled", "true");
        }

        return capabilities;
    }

}
