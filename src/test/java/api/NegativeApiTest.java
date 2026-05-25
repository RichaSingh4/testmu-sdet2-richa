package api;

import api.client.RestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeApiTest {

    @Test
    public void getInvalidBookingTest() {

        Response res = RestClient.get("/booking/99999999");

        Assert.assertEquals(res.statusCode(), 404);
    }

    @Test
    public void unauthorizedUpdateTest() {

        Response res = RestClient.put("/booking/1", "{}", "");

        Assert.assertTrue(
                res.statusCode() == 403 || res.statusCode() == 401
        );
    }
}