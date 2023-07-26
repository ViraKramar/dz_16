package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auth {
    private String username = "admin";
    private String password = "password123";
    private String token;

    public String auth(){
        Auth auth = Auth.builder()
                .username(username)
                .password(password)
                .build();
        Response response = RestAssured.given()
                .body(auth)
                .post("/auth");
        token = response.as(AuthResponse.class).getToken();

        return token;
    }
}
