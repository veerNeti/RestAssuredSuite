package com.example.modal.reqres;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-14-2020
 * Time: 07:23 PM
 */

@Getter
@Setter
public class Data {
    private String last_name;

    private String id;

    private String avatar;

    private String first_name;

    private String email;

    @Override
    public String toString() {
        return "Data{" +
                "last_name='" + last_name + '\'' +
                ", id='" + id + '\'' +
                ", avatar='" + avatar + '\'' +
                ", first_name='" + first_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
