package com.money.lava.deal.model;

public class DealInfo {

    private String borrowerName;
    private String period;
    private String purpose;
    private String method;
    private String revenue;
    private String gurantee;

    public DealInfo(String name, String period, String purpose, String method, String revenue
            , String gurantee) {
        this.borrowerName = name;
        this.period = period;
        this.purpose = purpose;
        this.method = method;
        this.revenue = revenue;
        this.gurantee = gurantee;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getGurantee() {
        return gurantee;
    }

    public void setGurantee(String gurantee) {
        this.gurantee = gurantee;
    }
}
