package cl.testing.demo;

import cl.testing.demo.entity.User;
import cl.testing.demo.entity.UserResponse;
import cl.testing.demo.service.UnknownImpl;
import cl.testing.demo.service.UsersImpl;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;
import shop.corner.commons.JSONHelper;

public class ReqResTest {

    @Test
    public void testOkResponse() {
        Response<String> response = UnknownImpl.getResource("2");
        Assert.assertTrue(response.isSuccessful());
    }

    @Test
    public void testOkResponse2() {
        Response<String> response = UnknownImpl.getResource("23");
        Assert.assertTrue(response.isSuccessful());
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("Test User");
        user.setJob("Engineer");

        Response<UserResponse> response = UsersImpl.create(user);

        Assert.assertEquals(response.body().getName(), user.getName());
        Assert.assertEquals(response.body().getJob(), user.getJob());
    }

    @Test
    public void testListUsersSchema() {
        Response<String> response = UsersImpl.list(2);
        String schema = JSONHelper.readFromFile("src/test/resources/schema/users-list.json");
        Assert.assertTrue(JSONHelper.validateResponseSchema(response.body(), schema));
    }

}
