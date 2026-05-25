package api.services;

import api.client.RestClient;
import api.models.Booking;
import api.models.BookingDates;
import io.restassured.response.Response;

public class BookingService {

    public Response createBooking(String firstname, String lastname, int price) {

        Booking booking = new Booking();
        booking.firstname = firstname;
        booking.lastname = lastname;
        booking.totalprice = price;
        booking.depositpaid = true;

        BookingDates dates = new BookingDates();
        dates.checkin = "2024-01-01";
        dates.checkout = "2024-01-10";

        booking.bookingdates = dates;
        booking.additionalneeds = "Breakfast";

        return RestClient.post("/booking", booking);
    }

    public Response getBooking(int id) {
        return RestClient.get("/booking/" + id);
    }

    public Response updateBooking(int id, String token) {

        Booking booking = new Booking();
        booking.firstname = "HARRY";
        booking.lastname = "NOT POTTER";
        booking.totalprice = 999;
        booking.depositpaid = true;

        BookingDates dates = new BookingDates();
        dates.checkin = "2024-01-01";
        dates.checkout = "2024-01-10";

        booking.bookingdates = dates;
        booking.additionalneeds = "Dinner";

        return RestClient.put("/booking/" + id, booking, token);
    }

    public Response deleteBooking(int id, String token) {
        return RestClient.delete("/booking/" + id, token);
    }
}