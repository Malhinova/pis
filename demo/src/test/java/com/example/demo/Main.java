package com.example.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void testPatientRegistration() {
        given()
            .contentType("application/json")
            .body("{ \"username\": \"patient1\", \"password\": \"password1\", \"role\": \"ROLE_PATIENT\" }")
        .when()
            .post("/api/register/patient")
        .then()
            .statusCode(201);
    }

    @Test
    public void testDoctorRegistration() {
        given()
            .contentType("application/json")
            .body("{ \"username\": \"doctor1\", \"password\": \"password1\", \"role\": \"ROLE_DOCTOR\" }")
        .when()
            .post("/api/register/doctor")
        .then()
            .statusCode(201);
    }
}
