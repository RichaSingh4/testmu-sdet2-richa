package api;

import api.services.AuthService;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest {
    AuthService auth=new AuthService();
    @Test
    public void authTest() {

        String token = auth.generateToken(
                ConfigReader.get("apiUsername"),
                ConfigReader.get("apiPassword")
        );

        Assert.assertNotNull(token);
    }
}
