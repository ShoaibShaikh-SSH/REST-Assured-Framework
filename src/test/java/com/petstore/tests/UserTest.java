package com.petstore.tests;

import DataCreationFromModel.UserDataCreator;
import DataModel.UserPojo;
import com.jayway.jsonpath.JsonPath;
import com.petstore.requestFactory.UserRequests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest extends TestBase
{
    UserPojo user = new UserPojo();
    public static UserRequests  userRequests=new UserRequests();
    public static UserDataCreator userDataCreator=new UserDataCreator();
    public static String createdUserName;
    public static String createdUerPassword;

    UserTest() { super.TestBase("/user");}

    @Feature("User endpoint")
    @Story("Fetching details of a user by its username")
    @Test
    @DisplayName("Fetch user details by username")
    public void getUserByUsername()
    {
        response = userRequests.userByUsername(createdUserName);
        response.prettyPrint();
        validatableResponse=
                response
                .then()
                .statusCode(200);
    }

    @Feature("User endpoint")
    @Story("Creating a new user")
    @Test
    @Order(1)
    @DisplayName("Create a new user")
    public void createAUser()
    {
       response = userRequests.userCreation(userDataCreator.DataForUSerCreation());

       validatableResponse =
                response
                .then()
                .statusCode(200);

        String responseString = response.asString();

        createdUserName = JsonPath.read(responseString,"$.username");
        createdUerPassword = JsonPath.read(responseString,"$.password");
        createdUserName = "/"+createdUserName;
    }

    @Feature("User endpoint")
    @Story("Log user into the system")
    @Test
    @Order(2)
    @DisplayName("Log the user into the system")
    public void LoginTheUser()
    {
        super.TestBase("/user/login");

        response = userRequests.userLogin(createdUserName,createdUerPassword);


        response.prettyPrint();
        validatableResponse =
                response
                .then()
                .statusCode(200);
    }

    @Feature("User endpoint")
    @Story("Logs out current active session")
    @Test
    @Order(3)
    @DisplayName("Log out the current active session")
    public void LogOutTheActiveUserSession()
    {
        super.TestBase("/user/logout");

        response = userRequests.userLogout();

        response.prettyPrint();

        validatableResponse =
                response
                .then()
                .statusCode(200);

    }
}
