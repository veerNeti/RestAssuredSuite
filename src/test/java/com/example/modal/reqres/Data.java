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
    private String color;

    private String year;

    private String name;

    private String id;

    private String pantone_value;

    public Data() {
    }

    @Override
    public String toString() {
        return "Data{" +
                "color='" + color + '\'' +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", pantone_value='" + pantone_value + '\'' +
                '}';
    }
}
