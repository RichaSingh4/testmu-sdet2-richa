package api;

import api.services.AuthService;
import api.services.BookingService;
import config.ConfigReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BookingApiTest {

    AuthService auth = new AuthService();
    BookingService booking = new BookingService();

    @Test
    public void createBookingTest() {

        Response res = booking.createBooking("HARRY", "POTTER", 5000);

        Assert.assertEquals(res.statusCode(), 200);

        int id = res.jsonPath().getInt("bookingid");
        Assert.assertTrue(id > 0);
        Assert.assertTrue(res.getTime() < 3000);
    }

    @Test
    public void getBookingTest() {

        Response create = booking.createBooking("HARRY", "POTTER", 5000);
        int id = create.jsonPath().getInt("bookingid");

        Response res = booking.getBooking(id);

        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertTrue(res.getTime() < 2000);
    }

    @Test
    public void updateBookingTest() {

        String token = auth.generateToken(ConfigReader.get("apiUsername"), ConfigReader.get("apiPassword"));

        Response create = booking.createBooking("HARRY", "POTTER", 5000);
        int id = create.jsonPath().getInt("bookingid");

        Response res = booking.updateBooking(id, token);

        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertTrue(res.getTime() < 2000);
    }
    @Test
    public void deleteBookingTest() {

        String token = auth.generateToken(ConfigReader.get("apiUsername"), ConfigReader.get("apiPassword"));

        Response create = booking.createBooking("HARRY", "POTTER", 5000);
        int id = create.jsonPath().getInt("bookingid");

        Response res = booking.deleteBooking(id, token);

        Assert.assertEquals(res.statusCode(), 201);
        Assert.assertTrue(res.getTime() < 2000);
    }


    @Test
    public void schemaTest() {

        Response res = booking.getBooking(1);

        res.then().assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/booking-schema.json"));
    }
}