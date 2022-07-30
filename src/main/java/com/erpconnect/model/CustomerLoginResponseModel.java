package com.erpconnect.model;

import javax.persistence.Basic;
import javax.persistence.Column;

public class CustomerLoginResponseModel {
    private String customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_phone;
    private String erpconnect_public_key;
    private String customer_public_key;

    public CustomerLoginResponseModel() {
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getErpconnect_public_key() {
        return erpconnect_public_key;
    }

    public void setErpconnect_public_key(String erpconnect_public_key) {
        this.erpconnect_public_key = erpconnect_public_key;
    }

    public String getCustomer_public_key() {
        return customer_public_key;
    }

    public void setCustomer_public_key(String customer_public_key) {
        this.customer_public_key = customer_public_key;
    }
}
