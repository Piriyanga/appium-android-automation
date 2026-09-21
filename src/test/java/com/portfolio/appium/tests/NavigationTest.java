package com.portfolio.appium.tests;

import com.portfolio.appium.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(description = "Verify the application launches successfully")
    public void verifyApplicationLaunches() {
        Assert.assertNotNull(driver, "The Appium driver should be created");
    }
}