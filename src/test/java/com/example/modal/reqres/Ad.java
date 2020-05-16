package com.example.modal.reqres;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-14-2020
 * Time: 07:22 PM
 */
@Getter
@Setter
public class Ad {
    private String company;

    private String text;

    private String url;

    public Ad() {
    }

    @Override
    public String toString() {
        return "Ad{" +
                "company='" + company + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
