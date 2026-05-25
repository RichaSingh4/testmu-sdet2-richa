package base;

import config.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        DriverFactory.getDriver()
                .get(ConfigReader.get("uiBaseUrl"));
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}