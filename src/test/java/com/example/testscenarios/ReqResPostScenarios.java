package com.example.testscenarios;

import com.example.config.Base;
import com.example.endpoints.ReqResEndPoints;
import com.example.runner.RunTheTestSuite;
import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-16-2020
 * Time: 07:37 PM
 */

@Epic(Base.REQRES_BASEURI + "Service Validation")
@Feature(ReqResEndPoints.ADD_USER)
@Story("Story:" + Base.REQRES_BASEURI + ReqResEndPoints.ADD_USER)
@Link(Base.REQRES_BASEURI + ReqResEndPoints.ADD_USER)
public class ReqResPostScenarios extends RunTheTestSuite {
    @Description("given user info; when I post the information; then I validate the response status code should be 201 ")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Step: Validate the response Status Code should be 201")
    @Test
    public void testAddAUserBodyFormattedAsString() {
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        step("Post() to add user information to resource");
        given( )
                .body(body)
                .when( )
                .post(ReqResEndPoints.ADD_USER)
                .then( ).statusCode(201);

    }

    @Description("given user info; when I update the information; then I validate the response status code should be 200 ")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Step: Validate the response Status Code should be 200")
    @Test
    public void testUpdateUserBodyFormattedAsString() {
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        step("PUT() to updated the user information to resource");
        given( ).pathParam("pathpram", 2)
                .body(body)
                .when( )
                .put(ReqResEndPoints.GET_SINGLE_USER)
                .then( ).statusCode(200);

    }

    @Description("given user info; when I partially update the information; then I validate the response status code should be 200 ")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Step: Validate the response Status Code should be 200")
    @Test
    public void testPartiallyUpdateUserinfo() {
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        step("PATCH() the user information to resource");
        given( ).pathParam("pathpram", 2)
                .body(body)
                .when( )
                .patch(ReqResEndPoints.GET_SINGLE_USER)
                .then( ).statusCode(200);

    }

    @Description("given user info; when I DELETE the information; then I validate the response status code should be 204")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Step: Validate the response Status Code should be 204")
    @Test
    public void testDeleteUpdateUserinfo() {
        step("DELETE() the user information to resource");
        given( ).pathParam("pathpram", 2)
                .when( )
                .delete(ReqResEndPoints.GET_SINGLE_USER)
                .then( ).statusCode(204);

    }

    @Description("given valid login credentials; when I attempt the login; then response status code should be 200 and token should be generated")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Step: Validate the response Status Code should 200")
    @Test
    public void testUserLogin() {
        String body = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
        step("User attempt login");
        ValidatableResponse then = given( ).body(body)
                .when( )
                .post(ReqResEndPoints.CREATE_LOGIN)
                .then( );

        boolean token = then.extract( ).response( ).path("token").toString( ).isEmpty( );
        Assert.assertEquals((then.extract( ).statusCode( ) == 200), !token);
    }


    @Description("given invalid login credentials; when I attempt the login; then response status code should be 400 and an error message should be generated")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Step: Validate the response Status Code should 400")
    @Test
    public void testInvalidUserLogin() {
        String body = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";
        step("User attempt login");
        ValidatableResponse then = given( ).body(body)
                .when( )
                .post(ReqResEndPoints.CREATE_LOGIN)
                .then( );

        boolean errorMEssageValidation = then.extract( ).response( ).path("error").toString( ).equalsIgnoreCase("Missing password");
        Assert.assertEquals((then.extract( ).statusCode( ) == 400), errorMEssageValidation);
    }


}
