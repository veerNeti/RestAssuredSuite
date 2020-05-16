package com.example.modal.reqres;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-14-2020
 * Time: 07:21 PM
 */

@Getter
@Setter
public class Products {
    private String per_page;

    private String total;

    private Ad ad;

    private Data[] data;

    private String page;

    private String total_pages;

    public Products() {
    }

    @Override
    public String toString() {
        return "ClassPojo [per_page = " + per_page + ", total = " + total + ", ad = " + ad + ", data = " + data + ", page = " + page + ", total_pages = " + total_pages + "]";
    }

}
