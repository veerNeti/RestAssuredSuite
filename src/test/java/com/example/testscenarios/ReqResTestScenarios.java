package com.example.testscenarios;

import com.example.endpoints.FootBallEndPoints;
import com.example.endpoints.ReqResEndPoints;
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
 * Time: 10:18 PM
 */
public class ReqResTestScenarios extends RunTheTestSuite {

    @Epic("ReqRes Api Service")
    @Description("Test Suite: Sample Suite to Test ResqRes.in API")
    @Story("Validate products id#3 information")
    @Test
    public void getAreaDetailsForGivenID() {
        step("Searching products, 3 ");
        given( )
                .pathParam("productsid", 3)
                .when( )
                .get(ReqResEndPoints.GET_ONE_PRODUCT)
                .then( );
    }
}
