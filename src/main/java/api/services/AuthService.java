package api.services;

import api.client.RestClient;
import api.models.AuthRequest;
import io.restassured.response.Response;

public class AuthService {

    public String generateToken(String username, String password) {

        AuthRequest request = new AuthRequest();
        request.username = username;
        request.password = password;

        Response res = RestClient.post("/auth", request);

        return res.jsonPath().getString("token");
    }
}