package com.portfolio.appium.pages;

import com.portfolio.appium.base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Controls page in the ApiDemos app.
 */
public class ControlsPage extends BasePage {

    private final By lightThemeMenu = AppiumBy.accessibilityId("1. Light Theme");

    public ControlsPage(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isLightThemeMenuDisplayed() {
        return isDisplayed(lightThemeMenu);
    }

    public LightThemeControlsPage openLightThemeControls() {
        tap(lightThemeMenu);
        return new LightThemeControlsPage(driver, wait);
    }
}