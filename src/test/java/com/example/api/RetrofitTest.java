package com.example.api;

import com.example.api.models.ResponseCode;
import com.example.api.models.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


@Tag("api")
public class RetrofitTest extends BaseApiTest {

    @Test
    public void shouldCreateUser() throws IOException {
        User user = User.buildUser().withId(0).withUsername(faker.name().username())
                .withFirstName(faker.name().firstName())
                .withLastName(faker.name().lastName())
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.internet().password(6, 10, true))
                .withUserStatus(faker.random().nextInt(10)).build();
        Response<ResponseCode> response = userService.createUser(user).execute();
        assertAll(
                ()-> assertNotNull(response.body()),
                ()-> assertEquals(200, response.code()),
                ()-> assertEquals("unknown", response.body().getType())
        );
    }
}
