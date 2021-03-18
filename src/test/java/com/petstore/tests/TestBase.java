/*
* Auther: Shoaib Shaikh
* Class Information: This is a base class which is is extended by all the Test classes.
* */

package com.petstore.tests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;


public class TestBase
{
    public static Response response;
    ValidatableResponse validatableResponse;

    public static Faker fake = new Faker();

    public void TestBase(String path)
    {

        baseURI = "http://localhost/api/v3";
        port = 8080;
        basePath = path;
    }

}
