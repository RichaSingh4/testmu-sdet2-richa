package ui;

import base.BaseTest;
import base.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExcelUtils;

public class DashboardTest extends BaseTest {

    private static final String FILE_PATH =
            "src/test/resources/testdata/LoginDetails.xlsx";

    @BeforeMethod

    public void loginToApplication() {

        LoginPage loginPage = new LoginPage();

        String username =
                ExcelUtils.getCellData(
                        FILE_PATH,
                        "ValidLogin",
                        1,
                        0);

        String password =
                ExcelUtils.getCellData(
                        FILE_PATH,
                        "ValidLogin",
                        1,
                        1);

        loginPage.login(username, password);
    }

    @Test
    public void verifyAddProductToCart() {

        DashboardPage dashboardPage =
                new DashboardPage();

        dashboardPage.addProductToCart();

        Assert.assertEquals(
                dashboardPage.getCartBadgeCount(),
                "1");
    }

    @Test
    public void verifyRemoveProductFromCart() {

        DashboardPage dashboardPage =
                new DashboardPage();

        dashboardPage.addProductToCart();

        dashboardPage.removeProductFromCart();

        Assert.assertFalse(
                dashboardPage.isCartBadgeDisplayed());
    }

    @Test
    public void verifyCartNavigation() {

        DashboardPage dashboardPage =
                new DashboardPage();

        dashboardPage.openCart();

        Assert.assertTrue(
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .contains("cart"));
    }
}