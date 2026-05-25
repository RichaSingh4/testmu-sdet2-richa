package dataproviders;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class LoginDataProvider {

    private static final String FILE_PATH =
            "src/test/resources/testdata/LoginDetails.xlsx";

    @DataProvider(name = "validLoginData")

    public Object[][] validLoginData() {

        return ExcelUtils.getTestData(
                FILE_PATH,
                "ValidLogin");
    }

    @DataProvider(name = "invalidLoginData")

    public Object[][] invalidLoginData() {

        return ExcelUtils.getTestData(
                FILE_PATH,
                "InvalidLogin");
    }
}