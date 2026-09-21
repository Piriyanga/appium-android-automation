package com.portfolio.appium.base;

import com.portfolio.appium.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

/**
 * BaseTest starts and stops the Appium driver.
 * All test classes extend this class.
 */
public class BaseTest {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws Exception {
        if (Boolean.getBoolean("skipMobileTests")) {
            throw new SkipException("Skipping mobile tests because skipMobileTests=true");
        }

        String appPath = Path.of(ConfigReader.get("app.path")).toAbsolutePath().toString();

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(ConfigReader.get("platform.name"))
                .setAutomationName(ConfigReader.get("automation.name"))
                .setDeviceName(ConfigReader.get("device.name"))
                .setApp(appPath)
                .setNoReset(ConfigReader.getBoolean("no.reset"))
                .setFullReset(ConfigReader.getBoolean("full.reset"))
                .setNewCommandTimeout(Duration.ofSeconds(ConfigReader.getInt("new.command.timeout.seconds")));

        driver = new AndroidDriver(new URL(ConfigReader.get("appium.server.url")), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotIfTestFailed(result);

        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenshotIfTestFailed(ITestResult result) {
        if (driver == null || result.getStatus() != ITestResult.FAILURE) {
            return;
        }

        try {
            File screenshot = driver.getScreenshotAs(OutputType.FILE);

            Path screenshotDirectory = Path.of("screenshots");
            Files.createDirectories(screenshotDirectory);

            Path destination = screenshotDirectory.resolve(result.getName() + ".png");
            Files.copy(screenshot.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved to: " + destination.toAbsolutePath());

        } catch (WebDriverException e) {
            System.out.println("Unable to capture screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unable to save screenshot: " + e.getMessage());
        }
    }
}