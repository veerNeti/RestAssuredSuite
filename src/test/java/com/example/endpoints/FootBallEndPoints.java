package com.example.endpoints;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-12-2020
 * Time: 09:58 PM
 */

/*
Interface methods are by default abstract and public
Interface attributes are by default public, static and final
 */
public interface FootBallEndPoints {

    String ALL_AVAILABLE_AREAS = "areas/";
    String ONE_PARTICULAR_AREAS = "areas/{id}";
    String ALL_AVAILABLE_COMPETITIONS = "competitions/";
    String ALL_MATCHES_FOR_PARTICULAR_COMPETITION = "competitions/{id}/matches";
    String GOAL_SCORERS_FOR_PARTICULAR_COMPETITION = "competitions/{id}/scorers";
    String SHOW_STANDINGS_FOR_A_PARTICULAR_COMPETITION = "competitions/{id}/standings";
    String LIST_ALL_TEAMS_FOR_PARTICULAR_COMPETITIONS = "competitions/{id}/teams";
    String LIST_ONE_PARTICULAR_COMPETITION = "competitions/2000";
    String LIST_MATCHES_ACROSS_A_SET_OF_COMPETITIONS = "matches";
    String SHOW_ONE_PARTICULAR_MATCH = "matches/{id}";
    String LIST_ONE_PARTICULAR_PLAYER = "players/{id}";
    String SHOW_ALL_MATCHES_FOR_A_PARTICULAR_PLAYER = "players/{id}/matches";
    String SHOW_ONE_PARTICULAR_TEAM = "teams/{id}";
    String SHOW_ALL_MATCHES_FOR_A_PARTICULAR_TEAM = "teams/{id}/matches/";
}
