package listeners;

import ai.FailureAnalyzer;
import base.DriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    private static WebDriver driver;

    public static void setDriver(WebDriver drv) {
        driver = drv;
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // ================= AI ANALYSIS =================
        Throwable error = result.getThrowable();

        if (error != null) {

            String analysis =
                    FailureAnalyzer.analyze(error);

            Allure.addAttachment(
                    "AI Failure Analysis",
                    analysis);
        }

        // ================= SCREENSHOT =================
        if (driver != null) {

            try {

                byte[] screenshot =
                        ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES);

                Allure.addAttachment(
                        "Failure Screenshot",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        ".png");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}