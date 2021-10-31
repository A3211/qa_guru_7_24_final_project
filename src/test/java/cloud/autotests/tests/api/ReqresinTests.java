package cloud.autotests.tests.api;

import cloud.autotests.tests.api.model.User;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.is;

public class ReqresinTests {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    void successLoginTest() {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("cityslicka");
        given()
                .contentType(JSON)
                .body(user)
        .when()
                .post("/api/login")
        .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void successCreateTest() {
        User user = new User();
        user.setName("morpheus");
        user.setJob("zion resident");
        given()
                .contentType(JSON)
                .body(user)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .body("name", is(user.getName()))
                .body("job", is(user.getJob()));
    }

    @Test
    void unsuccess404UpdateTest() {
        User user = new User();
        user.setName("morpheus");
        user.setJob("zion resident");
        given()
                .contentType(JSON)
                .body(user)
                .when()
                .patch("/1api/users/2")
                .then()
                .statusCode(404);
    }

    @Test
    void successDeleteTest() {
        given()
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204);
    }
}
