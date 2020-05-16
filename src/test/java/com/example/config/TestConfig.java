package com.example.config;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-15-2020
 * Time: 09:52 PM
 */
public class TestConfig {

    public RequestSpecification football_requestSpecification;
    public ResponseSpecification football_responseSpecification;
    public RequestSpecification reqResFake_requestSpecification;
    public ResponseSpecification reqResFake_responseSpecification;

    @Step("setup FootBall API Request Spec")
    public void setupFootBallAPIRequestSpec() {
        football_requestSpecification = new RequestSpecBuilder( )
                .setBaseUri(Base.FOOTBALL_BASEURI)
                .setBasePath(Base.FOOTBALL_BASEPATH)
                .addHeader("X-Auth-Token", "ca9cba9b2d5f454e9ba8949676cce248")
                .addHeader("x-response-control", "minified")
                .addHeader("X-Authenticated-Client", "Jimbo Jones")
                .addFilter(new RequestLoggingFilter( ))

                .build( );
        RestAssured.requestSpecification = football_requestSpecification;
    }

    public void setupFootBallAPIResponseSpec() {
        football_responseSpecification = new ResponseSpecBuilder( )
                .log(LogDetail.ALL)
                .build( );
        RestAssured.responseSpecification = football_responseSpecification;
    }

    @Step("setup ReqRes Fake API Request Spec")
    public void setupReqResFakeAPIRequestSpec() {
        reqResFake_requestSpecification = new RequestSpecBuilder( )
                .setBaseUri(Base.REQRES_BASEURI)
                .setBasePath(Base.REQRES_BASEPATH)
                .addHeader("content-Type", Base.CONTENT_TYPE_JSON)
                .addHeader("accept", Base.CONTENT_TYPE_JSON)
                .addFilter(new RequestLoggingFilter( ))
                .addFilter(new ResponseLoggingFilter( ))
                .build( );
        RestAssured.requestSpecification = reqResFake_requestSpecification;
    }

    public void setupReqResFakeResponseSpec() {
        reqResFake_responseSpecification = new ResponseSpecBuilder( )
                .log(LogDetail.ALL)
                .build( );
        RestAssured.responseSpecification = reqResFake_responseSpecification;
    }

}
