package com.money.lava.deal.model.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bible on 9/18/15.
 */
public class UserAccount {

    @Expose
    private String id;
    @SerializedName("product_description")
    @Expose
    private String productDescription;
    @SerializedName("cops_indicator")
    @Expose
    private String copsIndicator;
    @SerializedName("product_currency")
    @Expose
    private String productCurrency;
    @SerializedName("product_type")
    @Expose
    private int productType;
    @SerializedName("is_source_account")
    @Expose
    private String isSourceAccount;
    @SerializedName("is_destination_account")
    @Expose
    private String isDestinationAccount;
    @SerializedName("category_code")
    @Expose
    private int categoryCode;
    @SerializedName("details_exist")
    @Expose
    private String detailsExist;
    @SerializedName("display_acct_no")
    @Expose
    private String displayAcctNo;
    @SerializedName("offers_indicator")
    @Expose
    private String offersIndicator;
    @Expose
    private Balances balances;
    @SerializedName("account_status")
    @Expose
    private String accountStatus;
    @Expose
    private Msgs msgs;
    @SerializedName("txn_exist")
    @Expose
    private String txnExist;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     *
     * @param productDescription
     * The product_description
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     *
     * @return
     * The copsIndicator
     */
    public String getCopsIndicator() {
        return copsIndicator;
    }

    /**
     *
     * @param copsIndicator
     * The cops_indicator
     */
    public void setCopsIndicator(String copsIndicator) {
        this.copsIndicator = copsIndicator;
    }

    /**
     *
     * @return
     * The productCurrency
     */
    public String getProductCurrency() {
        return productCurrency;
    }

    /**
     *
     * @param productCurrency
     * The product_currency
     */
    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }

    /**
     *
     * @return
     * The productType
     */
    public int getProductType() {
        return productType;
    }

    /**
     *
     * @param productType
     * The product_type
     */
    public void setProductType(int productType) {
        this.productType = productType;
    }

    /**
     *
     * @return
     * The isSourceAccount
     */
    public String getIsSourceAccount() {
        return isSourceAccount;
    }

    /**
     *
     * @param isSourceAccount
     * The is_source_account
     */
    public void setIsSourceAccount(String isSourceAccount) {
        this.isSourceAccount = isSourceAccount;
    }

    /**
     *
     * @return
     * The isDestinationAccount
     */
    public String getIsDestinationAccount() {
        return isDestinationAccount;
    }

    /**
     *
     * @param isDestinationAccount
     * The is_destination_account
     */
    public void setIsDestinationAccount(String isDestinationAccount) {
        this.isDestinationAccount = isDestinationAccount;
    }

    /**
     *
     * @return
     * The categoryCode
     */
    public int getCategoryCode() {
        return categoryCode;
    }

    /**
     *
     * @param categoryCode
     * The category_code
     */
    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     *
     * @return
     * The detailsExist
     */
    public String getDetailsExist() {
        return detailsExist;
    }

    /**
     *
     * @param detailsExist
     * The details_exist
     */
    public void setDetailsExist(String detailsExist) {
        this.detailsExist = detailsExist;
    }

    /**
     *
     * @return
     * The displayAcctNo
     */
    public String getDisplayAcctNo() {
        return displayAcctNo;
    }

    /**
     *
     * @param displayAcctNo
     * The display_acct_no
     */
    public void setDisplayAcctNo(String displayAcctNo) {
        this.displayAcctNo = displayAcctNo;
    }

    /**
     *
     * @return
     * The offersIndicator
     */
    public String getOffersIndicator() {
        return offersIndicator;
    }

    /**
     *
     * @param offersIndicator
     * The offers_indicator
     */
    public void setOffersIndicator(String offersIndicator) {
        this.offersIndicator = offersIndicator;
    }

    /**
     *
     * @return
     * The balances
     */
    public Balances getBalances() {
        return balances;
    }

    /**
     *
     * @param balances
     * The balances
     */
    public void setBalances(Balances balances) {
        this.balances = balances;
    }

    /**
     *
     * @return
     * The accountStatus
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     *
     * @param accountStatus
     * The account_status
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     *
     * @return
     * The msgs
     */
    public Msgs getMsgs() {
        return msgs;
    }

    /**
     *
     * @param msgs
     * The msgs
     */
    public void setMsgs(Msgs msgs) {
        this.msgs = msgs;
    }

    /**
     *
     * @return
     * The txnExist
     */
    public String getTxnExist() {
        return txnExist;
    }

    /**
     *
     * @param txnExist
     * The txn_exist
     */
    public void setTxnExist(String txnExist) {
        this.txnExist = txnExist;
    }
}
