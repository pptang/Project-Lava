package com.money.lava.deal.model.Login;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bible on 9/16/15.
 */
public class Auth {

    private String isEligibleForOffers;
    private String isPersonToPersonRequired;
    private String token;
    private String username;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIsEligibleForOffers() {
        return isEligibleForOffers;
    }

    public void setIsEligibleForOffers(String isEligibleForOffers) {
        this.isEligibleForOffers = isEligibleForOffers;
    }

    public String getIsPersonToPersonRequired() {
        return isPersonToPersonRequired;
    }

    public void setIsPersonToPersonRequired(String isPersonToPersonRequired) {
        this.isPersonToPersonRequired = isPersonToPersonRequired;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
