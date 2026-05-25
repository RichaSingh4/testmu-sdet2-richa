package ui;

import base.BaseTest;
import base.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void verifyLoginPageTitle() {

        String title = DriverFactory.getDriver().getTitle();

        Assert.assertTrue(title.contains("The Internet"));
    }
}