package com.example.gouwuche;

/**
 * Created by 姜天赐 on 2017/12/11.
 */

public class Bean {
    private String price;
    private String number;

    public Bean(String price, String number) {
        this.price = price;
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
