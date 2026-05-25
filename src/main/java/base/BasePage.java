package base;

import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class BasePage {

    protected void click(WebElement element) {

        WaitUtils.waitForClickable(element);
        element.click();
    }

    protected void writeText(WebElement element, String text) {

        WaitUtils.waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {

        WaitUtils.waitForVisibility(element);
        return element.getText();
    }
}