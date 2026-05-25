package base;

import config.ConfigReader;
import listeners.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        DriverFactory.getDriver()
                .get(ConfigReader.get("uiBaseUrl"));
        TestListener.setDriver(DriverFactory.getDriver());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}