package cl.testing.demo.service;

import cl.testing.demo.entity.User;
import cl.testing.demo.entity.UserResponse;
import org.tinylog.Logger;
import retrofit2.Response;
import shop.corner.EndpointFactory;

import java.io.IOException;

public class UsersImpl {

    public static Response create(User user) {
        Users users =
                new EndpointFactory().getEndpoint(Users.class);
        Response<UserResponse> response = null;
        try {
            // serialization/deserialization
            response = users.create(user).execute();
        } catch (IOException e) {
            Logger.error(e, "Error getting the data.");
        }

        return response;
    }

    public static Response list(int page) {
        Users users =
                new EndpointFactory().getEndpoint(Users.class);
        Response<String> response = null;
        try {
            response = users.list(page).execute();
        } catch (IOException e) {
            Logger.error(e, "Error getting the data.");
        }

        return response;
    }
}
