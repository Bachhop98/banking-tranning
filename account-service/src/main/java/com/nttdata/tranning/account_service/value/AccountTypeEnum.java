package com.nttdata.tranning.account_service.value;

public enum AccountTypeEnum {
    NAPAS("N"), CITAS("C"), DEPOSIT("D"), WITHDRAW("W");
    private String value;
    AccountTypeEnum(String value) {
    this.value = value;
}
}
