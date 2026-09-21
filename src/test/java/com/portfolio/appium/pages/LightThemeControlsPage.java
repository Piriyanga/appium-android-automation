package com.portfolio.appium.pages;

import com.portfolio.appium.base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Light Theme Controls screen in the ApiDemos app.
 */
public class LightThemeControlsPage extends BasePage {

    private final By textField = AppiumBy.className("android.widget.EditText");
    private final By checkBox = AppiumBy.className("android.widget.CheckBox");
    private final By radioButton = AppiumBy.className("android.widget.RadioButton");

    public LightThemeControlsPage(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isTextFieldDisplayed() {
        return isDisplayed(textField);
    }

    public void enterText(String text) {
        type(textField, text);
    }

    public String getEnteredText() {
        return getText(textField);
    }

    public void tapCheckBox() {
        tap(checkBox);
    }

    public void tapRadioButton() {
        tap(radioButton);
    }
}