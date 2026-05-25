package base;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initDriver() {

        String browser =
                System.getProperty(
                        "browser",
                        ConfigReader.get("browser"));

        switch (browser.toLowerCase()) {

            case "firefox":

                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions options = new FirefoxOptions();

                driver.set(new FirefoxDriver(options));

                break;

            case "chrome":

            default:

                WebDriverManager.chromedriver().setup();

                driver.set(new ChromeDriver());
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if (getDriver() != null) {

            getDriver().quit();

            driver.remove();
        }
    }
}