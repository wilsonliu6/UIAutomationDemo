package com.store.automation.web.enums;

public enum EnumUrls {
    STORE_BASE_URL("http://store.demoqa.com"),
    STORE_MY_ACCOUNT_URL("http://store.demoqa.com/products-page/your-account"),
    STORE_MY_ACCOUNT_PRODUCT_PAGE_URL("http://store.demoqa.com/products-page/your-account");

    private String value;
    EnumUrls(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
