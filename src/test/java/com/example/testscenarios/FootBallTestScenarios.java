package com.example.testscenarios;

import com.example.endpoints.FootBallEndPoints;
import com.example.runner.RunTheTestSuite;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-15-2020
 * Time: 10:00 PM
 */
public class FootBallTestScenarios  extends RunTheTestSuite {
    @Epic("FootBall Api Service")
    @Description("Test Suite: Sample Suite to Test Foot API test Services")
    @Story("Validate AVAILABLE_AREAS contains information for Id 2267")
    @Test
    public void getAreaDetailsForGivenID() {
        step("Searching \"areas\", 2267 ");
        given( )
                .queryParam("areas", 2267)
                .when( )
                .get(FootBallEndPoints.ALL_AVAILABLE_AREAS)
                .then( );
    }
}
