package com.portfolio.appium.pages;

import com.portfolio.appium.base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Views page in the ApiDemos app.
 */
public class ViewsPage extends BasePage {

    private final By controlsMenu = AppiumBy.accessibilityId("Controls");

    public ViewsPage(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isControlsMenuDisplayed() {
        return isDisplayed(controlsMenu);
    }

    public ControlsPage openControls() {
        tap(controlsMenu);
        return new ControlsPage(driver, wait);
    }
}