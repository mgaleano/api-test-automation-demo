package cl.testing.demo.service;

import org.tinylog.Logger;
import retrofit2.Response;
import shop.corner.EndpointFactory;

import java.io.IOException;

public class UnknownImpl {

    public static Response getResource(String id) {
        Unknown unknown =
                new EndpointFactory().getEndpoint(Unknown.class);
        Response<String> resource = null;
        try {
            resource = unknown.resource(id).execute();
        } catch (IOException e) {
            Logger.error(e, "Error getting the data.");
        }

        return resource;
    }
}
