package com.example.testscenarios;

import com.example.config.Base;
import com.example.endpoints.FootBallEndPoints;
import com.example.endpoints.ReqResEndPoints;
import com.example.runner.RunTheTestSuite;
import io.qameta.allure.*;
import io.qameta.allure.model.Status;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.groovy.util.StringUtil;
import org.testng.IDynamicGraph;
import org.testng.annotations.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-15-2020
 * Time: 10:00 PM
 */


@Epic(Base.FOOTBALL_BASEURI + "Service Validation")
@Feature(Base.FOOTBALL_BASEURI + Base.FOOTBALL_BASEPATH + "Service Validation")

@Link(Base.FOOTBALL_BASEURI + ReqResEndPoints.GET_ONE_PRODUCT)
public class FootBallTestScenarios extends RunTheTestSuite {

    @Story("Story:" + FootBallEndPoints.ALL_AVAILABLE_AREAS)
    @Step("Search Area details")
    @Test
    public void getAreaDetailsForGivenID() {
        step("Search Area");
        given( )
                .queryParam("areas", 2267)
                .when( )
                .get(FootBallEndPoints.ALL_AVAILABLE_AREAS)
                .then( );
    }

    @Step("get list of Areas")
    @Test
    public void testDetailsAllAreas() {
        step("lists of all Area");
        given( )
                .get(FootBallEndPoints.ALL_AVAILABLE_AREAS)
                .then( );
    }

    @Story("Story:" + FootBallEndPoints.SHOW_ONE_PARTICULAR_TEAM)
    @Step("Search for a team")
    @Test
    public void testResponseBodyTeamFoundedYear() {
        step("search team information");
        ValidatableResponse validatableResponse = given( ).
                pathParam("id", "57")
                .when( )
                .get(FootBallEndPoints.SHOW_ONE_PARTICULAR_TEAM)
                .then( );
        validatableResponse.log( ).all( );
        validatableResponse.body("founded", equalTo(1886));
    }

    @Story("Story:" + FootBallEndPoints.LIST_ALL_TEAMS_FOR_PARTICULAR_COMPETITIONS)
    @Step("Search for a Tournament")
    @Test
    public void testResponseBodyNameOFTheTournament() {
        step("search team Tournament");
        ValidatableResponse validatableResponse = given( ).
                pathParam("id", 2021)
                .when( )
                .get(FootBallEndPoints.LIST_ALL_TEAMS_FOR_PARTICULAR_COMPETITIONS)
                .then( );
        validatableResponse.body("teams[1].name", equalTo("Aston Villa FC"));
    }


    @Story("Story:" + FootBallEndPoints.SHOW_ONE_PARTICULAR_TEAM)
    @Step("Search for a team")
    @Test
    public void testStoringResponseAsString() {
        step("get response as a string");
        String repsonseAsString = given( ).pathParam("id", 57)
                .when( ).get(FootBallEndPoints.SHOW_ONE_PARTICULAR_TEAM)
                .asString( );

        System.out.println("repsonseAsString :" + repsonseAsString);
    }

    @Story("Story:" + FootBallEndPoints.LIST_ALL_TEAMS_FOR_PARTICULAR_COMPETITIONS)
    @Step("Search for a tournament")
    @Test
    public void testResponseContentType() {
        step("get response as string");
        Response response = given( ).pathParam("id", 57)
                .when( )
                .get(FootBallEndPoints.LIST_ALL_TEAMS_FOR_PARTICULAR_COMPETITIONS)
                .then( )
                .contentType(ContentType.JSON)
                .extract( ).response( );
        String asString = response.asString( );
    }


    @Story("Story:" + FootBallEndPoints.SHOW_ONE_PARTICULAR_TEAM)
    @Step("Search for a team")
    @Test
    public void testResponseHeaders() {
        step("search for team information as an object");
        Response response = given( ).pathParam("id", 57)
                .when( )
                .get(FootBallEndPoints.SHOW_ONE_PARTICULAR_TEAM)
                .then( )
                .contentType(ContentType.JSON)
                .extract( ).response( );
        Headers headers = response.getHeaders( );
        headers.asList( ).stream( ).forEach(System.out::println);
        String header = response.getHeader("Content-Type");
        step("validate reponse headers");
        System.out.println("---:" + header);
//4844
    }

    @Story("Story:" + FootBallEndPoints.LIST_ALL_TEAMS_FOR_PARTICULAR_COMPETITIONS)
    @Step("Search for a Tournament")
    @Test
    public void testExtractFirstTeamName() {
        step("Get team name from the year 2021");
        String id = given( ).pathParam("id", 2021)
                .when( )
                .get(FootBallEndPoints.LIST_ALL_TEAMS_FOR_PARTICULAR_COMPETITIONS)
                .jsonPath( ).getString("teams.name[0]");
        if(StringUtils.equalsIgnoreCase(id, "Arsenal FC"))
            step("Team from a tournament played in 2021:", Status.PASSED);
        step("Team from a tournament played in 2021:", Status.FAILED);
    }


    @Story("Story:" + FootBallEndPoints.LIST_ALL_TEAMS_FOR_PARTICULAR_COMPETITIONS)
    @Step("Search for a Tournament")
    @Test
    public void testEtractTeamNames() {
        Response response = given( ).pathParam("id", 2021)
                .when( )
                .get(FootBallEndPoints.LIST_ALL_TEAMS_FOR_PARTICULAR_COMPETITIONS)
                .then( )
                .extract( )
                .response( );
        List<String> listOfAllTeamNames = response.path("teams.name");
        System.out.println("-----------");
        listOfAllTeamNames.stream( ).forEach(System.out::println);

        List<String> teamsShortNames = response.path("teams.shortName");

        System.out.println("-----------");
        teamsShortNames.stream( ).forEach(System.out::println);
    }
}
