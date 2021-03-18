package com.petstore.requestFactory;

import DataModel.PetPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;


public class PetRequests
{
    public Response getPetByStatus(String queryParam)
    {
        return given()
                .queryParam("status",queryParam)
                .when()
                .get("/findByStatus");
    }

    public Response  petCreation(PetPojo pet)
    {

        return given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(pet)
                .post();
    }

    public Response petById(String queryParam)
    {
        return given()
                .when()
                .get(queryParam);
    }

    public Response updateGivenPet(PetPojo pet)
    {
        return given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(pet)
                .put();
    }
    public Response updatePetWithFormData(PetPojo pet)
    {
        return given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(pet)
                .post();
    }
}
