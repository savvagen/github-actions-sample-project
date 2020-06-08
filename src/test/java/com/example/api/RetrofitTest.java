package com.example.api;

import com.example.api.models.Pet;
import com.example.api.models.ResponseCode;
import com.example.api.models.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@Tag("api")
public class RetrofitTest extends BaseApiTest {

    @Test
    public void shouldCreateUser() throws IOException {
        User user = User.buildUser().id(0).username(faker.name().username())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password(6, 10, true))
                .userStatus(faker.random().nextInt(10)).build();
        Response<ResponseCode> response = userService.createUser(user).execute();
        assertAll(
                ()-> assertNotNull(response.body()),
                ()-> assertEquals(200, response.code()),
                ()-> assertEquals("unknown", response.body().getType())
        );
    }

    @Test
    public void shouldGetFirstPet() throws IOException {
        Pet myPet = Pet.buildPet().name("test").status("available").build();
        Pet expected = petService.createPet(myPet).execute().body();
        Response<Pet> response = petService.getPet(expected.id).execute();
        assertAll(
                ()-> assertNotNull(response.body()),
                ()-> assertEquals(200, response.code()),
                ()-> assertEquals(expected.id, response.body().getId()),
                ()-> assertEquals(expected.name, response.body().getName())
        );
    }

}
