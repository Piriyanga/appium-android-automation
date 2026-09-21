package com.portfolio.appium.tests;

import com.portfolio.appium.base.BaseTest;
import com.portfolio.appium.pages.ControlsPage;
import com.portfolio.appium.pages.HomePage;
import com.portfolio.appium.pages.LightThemeControlsPage;
import com.portfolio.appium.pages.ViewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Smoke test for Android ApiDemos sample app.
 *
 * Test flow:
 * 1. Open ApiDemos app
 * 2. Tap Views
 * 3. Tap Controls
 * 4. Tap 1. Light Theme
 * 5. Enter text into the text field
 * 6. Tap checkbox and radio button
 */
public class ApiDemosSmokeTest extends BaseTest {

    @Test(description = "Verify user can navigate to controls screen and interact with form elements")
    public void verifyLightThemeControlsForm() {
        HomePage homePage = new HomePage(driver, wait);

        Assert.assertTrue(
                homePage.isViewsMenuDisplayed(),
                "Views menu should be displayed on the home screen"
        );

        ViewsPage viewsPage = homePage.openViews();

        Assert.assertTrue(
                viewsPage.isControlsMenuDisplayed(),
                "Controls menu should be displayed on the Views screen"
        );

        ControlsPage controlsPage = viewsPage.openControls();

        Assert.assertTrue(
                controlsPage.isLightThemeMenuDisplayed(),
                "Light Theme menu should be displayed on the Controls screen"
        );

        LightThemeControlsPage lightThemeControlsPage = controlsPage.openLightThemeControls();

        Assert.assertTrue(
                lightThemeControlsPage.isTextFieldDisplayed(),
                "Text field should be displayed on the Light Theme Controls screen"
        );

        String testMessage = "Hello Appium Portfolio";

        lightThemeControlsPage.enterText(testMessage);
        lightThemeControlsPage.tapCheckBox();
        lightThemeControlsPage.tapRadioButton();

        Assert.assertEquals(
                lightThemeControlsPage.getEnteredText(),
                testMessage,
                "Entered text should match expected value"
        );
    }
}