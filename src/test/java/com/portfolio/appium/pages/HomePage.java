package com.portfolio.appium.pages;

import com.portfolio.appium.base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Home page of the Android ApiDemos sample application.
 */
public class HomePage extends BasePage {

    private final By viewsMenu = AppiumBy.accessibilityId("Views");

    public HomePage(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isViewsMenuDisplayed() {
        return isDisplayed(viewsMenu);
    }

    public ViewsPage openViews() {
        tap(viewsMenu);
        return new ViewsPage(driver, wait);
    }
}