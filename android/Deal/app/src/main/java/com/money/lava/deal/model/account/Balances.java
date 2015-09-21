package com.money.lava.deal.model.account;

import com.google.gson.annotations.Expose;

/**
 * Created by Bible on 9/18/15.
 */
public class Balances {

    @Expose
    private int available;
    @Expose
    private int current;
    @Expose
    private int ledger;

    /**
     *
     * @return
     * The available
     */
    public int getAvailable() {
        return available;
    }

    /**
     *
     * @param available
     * The available
     */
    public void setAvailable(int available) {
        this.available = available;
    }

    /**
     *
     * @return
     * The current
     */
    public int getCurrent() {
        return current;
    }

    /**
     *
     * @param current
     * The current
     */
    public void setCurrent(int current) {
        this.current = current;
    }

    /**
     *
     * @return
     * The ledger
     */
    public int getLedger() {
        return ledger;
    }

    /**
     *
     * @param ledger
     * The ledger
     */
    public void setLedger(int ledger) {
        this.ledger = ledger;
    }

}
