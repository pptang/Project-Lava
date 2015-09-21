package com.money.lava.deal.model.account;

import com.google.gson.annotations.Expose;

/**
 * Created by Bible on 9/18/15.
 */
public class Msgs {

    @Expose
    private String msg;
    @Expose
    private String type;

    /**
     *
     * @return
     * The msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @param msg
     * The msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }
}
