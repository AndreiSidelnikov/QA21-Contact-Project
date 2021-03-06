package com.telran.contact.api.tests;

import com.jayway.restassured.RestAssured;
import com.telran.contact.api.dto.AuthoRequestDto;
import com.telran.contact.api.dto.AuthResponseDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsString;

public class RestAssuredTests {

    @BeforeMethod
    public void ensurePreconditions() {
        RestAssured.baseURI = "https://contacts-telran.herokuapp.com";
        RestAssured.basePath = "api";
    }

    @Test
    public void loginRestAssuredTest() {

        AuthoRequestDto requestDto = AuthoRequestDto.builder()
                .email("kroozzs@gm.com")
                .password("Kroozzs12345~")
                .build();

        AuthResponseDto responseDto = RestAssured.given()
                .contentType("application/json")
                .body(requestDto)
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);
        System.out.println(responseDto.getToken());

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Imtyb29zQGdtLmNvbSJ9.BbVSHfbAvgsFMmWD-6KDLIvdwxyw07MrYPMkdZW2Tmc";

        AuthResponseDto responseToken = RestAssured.given()
                .contentType("application/json")
                .body(requestDto)
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .body(containsString("token"))
                .body("token", equalTo(token))
                .extract().response().as(AuthResponseDto.class);
        System.out.println(responseToken);

    }
}