package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver driver;
    private static AppiumDriverLocalService service;
    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void startAppiumServer() {
        System.out.println("Starting Appium server");

        File appiumJS = new File("C:\\Users\\naveen.d\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
        System.out.println("Appium JS exists: " + appiumJS.exists());

        service = new AppiumServiceBuilder()
                .withAppiumJS(appiumJS)
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();
        System.out.println("Appium server started at " + service.getUrl());
    }

    public static AppiumDriver initializeDriver() {
    	File logDir = new File("logs");
        if (!logDir.exists()) {
            logDir.mkdir();
            System.out.println("Log folder created.");
        }
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(ConfigManager.getProperty("platformName"));
        options.setDeviceName(ConfigManager.getProperty("deviceName"));
        options.setAutomationName("UiAutomator2");
        options.setApp(ConfigManager.getProperty("app"));
        options.setPlatformVersion(ConfigManager.getProperty("platformVersion"));
        options.setFullReset(true);
        options.setNoReset(false);
        options.setIgnoreHiddenApiPolicyError(true);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            System.out.println("AndroidDriver initialized with UiAutomator2");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize AndroidDriver");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver session ended");
        }
    }

    public static void stopAppiumServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium server stopped");
        }
    }
}
