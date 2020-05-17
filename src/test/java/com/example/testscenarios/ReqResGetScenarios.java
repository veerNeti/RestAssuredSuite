package com.example.testscenarios;

import com.example.config.Base;
import com.example.endpoints.ReqResEndPoints;
import com.example.modal.reqres.Products;
import com.example.runner.RunTheTestSuite;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-15-2020
 * Time: 10:18 PM
 */

@Epic(Base.REQRES_BASEURI + "Service Validation")
@Feature(ReqResEndPoints.GET_ONE_PRODUCT)
@Story("Story:" + Base.REQRES_BASEURI + ReqResEndPoints.GET_ONE_PRODUCT)
@Link(Base.REQRES_BASEURI + ReqResEndPoints.GET_ONE_PRODUCT)

public class ReqResGetScenarios extends RunTheTestSuite {

    @Description("Get service availability")
    @Severity(SeverityLevel.NORMAL)
    @Step("Step: Validate status code for the service is 200")
    @Test
    public void testGetAllProducts() {
        step("Validate Get All Product Service: ");
        given( )
                .when( )
                .get(ReqResEndPoints.GET_PRODUCT_ID_Details)
                .then( )
                .assertThat( )
                .statusCode(200);
    }

    @Description("Search using pathParam")
    @Severity(SeverityLevel.NORMAL)
    @Step("Step: Validate status code when searched using pathParam")
    @Test
    public void testOneProductDetails() {
        given( )
                .pathParam("productsid", 3)
                .when( )
                .get(ReqResEndPoints.GET_ONE_PRODUCT)
                .then( )
                .statusCode(200);

    }

    @Description("Search of a product using Path")
    @Severity(SeverityLevel.NORMAL)
    @Step("Step: Search of a product using Path")
    @Test
    public void testProductNameUsingPath() {

        given( )
                .queryParam("id", 5)
                .when( )
                .get(ReqResEndPoints.GET_PRODUCT_ID_Details)
                .then( )
                .extract( )
                .body( )
                .path("data.name").toString( ).equalsIgnoreCase("tigerlily");


    }

    @Description("Search of a product using jsonPath")
    @Severity(SeverityLevel.NORMAL)
    @Step("Search of a product using jsonPath")
    @Test
    public void testProductNamejsonPath() {
        given( )
                .queryParam("id", 5)
                .when( )
                .get(ReqResEndPoints.GET_PRODUCT_ID_Details)
                .then( )
                .extract( )
                .body( )
                .jsonPath( ).getString("data.name").equalsIgnoreCase("tigerlily");

    }


    @Description("Search for a product using jsonPath")
    @Severity(SeverityLevel.NORMAL)
    @Step("Step: display list of all products and Search for one product using jsonPath")
    @Test
    public void testProductNamejsonPathList() {
        JsonPath jsonPath = given( )
                .when( )
                .get(ReqResEndPoints.GET_PRODUCT_ID_Details)
                .then( )
                .extract( )
                .body( )
                .jsonPath( );
        List<String> listOfProductNames = jsonPath.getList("data.name");
        assertThat(listOfProductNames.stream( ).anyMatch(s -> s.contains("cerulean")));
    }

    @Description("Search for a product serializing Response in Pojo")
    @Severity(SeverityLevel.NORMAL)
    @Step("Step: display list of all products and Search for one product  serializing Response in Pojo")
    @Test
    public void testProductNameasPojo() {
        Products products = given( )
                .when( )
                .get(ReqResEndPoints.GET_PRODUCT_ID_Details)
                .then( )
                .extract( )
                .body( )
                .as(Products.class);
        assertThat(products.getData( )[1].getName( ).equalsIgnoreCase("aqua sky"));
    }


}
