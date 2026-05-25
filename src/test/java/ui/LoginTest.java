package ui;

import base.BaseTest;
import dataproviders.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {
    private static final String FILE_PATH =
            "src/test/resources/testdata/LoginDetails.xlsx";
    private static final String INVALID_LOGIN_CONSTANT =
            "InvalidLogin";


    @Test(
            dataProvider = "validLoginData",
            dataProviderClass = LoginDataProvider.class)

    public void verifySuccessfulLogin(
            String username,
            String password) {

        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        DashboardPage dashboardPage =
                new DashboardPage();

        Assert.assertEquals(
                dashboardPage.getProductsTitle(),
                "Products");
    }

    @Test
    public void verifyLockedUserValidation() {

        LoginPage loginPage = new LoginPage();
        String username =
                ExcelUtils.getCellData(
                        FILE_PATH,
                        INVALID_LOGIN_CONSTANT,
                        1,
                        0);

        String password =
                ExcelUtils.getCellData(
                        FILE_PATH,
                        INVALID_LOGIN_CONSTANT,
                        1,
                        1);

        loginPage.login(username, password);



        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Epic sadface"));
    }

    @Test
    public void verifyInvalidCredentialsValidation() {

        LoginPage loginPage = new LoginPage();

        String username =
                ExcelUtils.getCellData(
                        FILE_PATH,
                        INVALID_LOGIN_CONSTANT,
                        2,
                        0);

        String password =
                ExcelUtils.getCellData(
                        FILE_PATH,
                        INVALID_LOGIN_CONSTANT,
                        2,
                        1);
        loginPage.login(username, password);

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Epic sadface"));
    }

    @Test
    public void verifyEmptyUsernameValidation() {

        LoginPage loginPage = new LoginPage();

        String username =
                ExcelUtils.getCellData(
                        FILE_PATH,
                        INVALID_LOGIN_CONSTANT,
                        3,
                        0);

        String password =
                ExcelUtils.getCellData(
                        FILE_PATH,
                        INVALID_LOGIN_CONSTANT,
                        3,
                        1);
        loginPage.login(username, password);

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username is required"));
    }

    @Test
    public void verifyEmptyPasswordValidation() {

        LoginPage loginPage = new LoginPage();

        String username =
                ExcelUtils.getCellData(
                        FILE_PATH,
                        INVALID_LOGIN_CONSTANT,
                        4,
                        0);

        String password =
                ExcelUtils.getCellData(
                        FILE_PATH,
                        INVALID_LOGIN_CONSTANT,
                        4,
                        1);
        loginPage.login(username, password);
        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Password is required"));
    }
}