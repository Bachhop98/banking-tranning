package com.nttdata.tranning.account_service.utils;

import java.util.Random;

public class AccountNumberGenerator {
    public static String generate() {
        String bankCode = "9704";
        String random = String.valueOf(new Random().nextInt(99999999));
        return bankCode + String.format("%08d", Integer.parseInt(random));
    }
}
