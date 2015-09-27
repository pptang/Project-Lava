package com.money.lava.deal.model;

/**
 * Created by Bible on 9/22/15.
 */
public class LendItem {

    private String name;
    private String amount;
    private String rate;

    public LendItem(String name, String amount, String rate) {
        this.name = name;
        this.amount = amount;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }


    public String getRate() {
        return rate;
    }


    public String getAmount() {
        return amount;
    }

}
