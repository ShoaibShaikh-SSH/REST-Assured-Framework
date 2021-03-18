package com.petstore.requestFactory;

import DataModel.PetPojo;
import DataModel.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserRequests
{
    public Response userByUsername(String queryParam)
    {
        return given()
                .when()
                .get(queryParam);
    }

    public Response  userCreation(UserPojo user)
    {
        return  given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .post();
    }

    public Response userLogin(String usernname,String password)
    {
        return  given()
                .when()
                .queryParam("username",usernname)
                .queryParam("password",password)
                .get();
    }

    public Response userLogout()
    {
        return given()
                .when()
                .get();
    }
}
