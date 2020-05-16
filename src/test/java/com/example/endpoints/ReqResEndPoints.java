package com.example.endpoints;

import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-14-2020
 * Time: 08:41 PM
 */
public interface ReqResEndPoints {
    String GET_ALL_USER = "users?page={queryparam}";
    String GET_ALL_RESOURCE = "unknown";
    String GET_SINGLE_RESOURCE = "unknown/{pathparam}";
    String ADD_USER = "users";
    String GET_SINGLE_USER = "users/{pathpram}";
    String UPDATE_SINGLE_USER="users/{pathparam}";
    String DELETE_SINGLE_USER="users/{pathparam}";
    String CREATE_REGISTERATION="register";
    String CREATE_LOGIN="login";
    String DELAYED_RESPONSE="users?delay={timeouts}";
    String GET_ONE_PRODUCT="products/{productsid}";
}
