package com.mock.service.utils;

public class TextUtils {
    public static boolean isEmpty(String value) {
        if(value==null || value.isEmpty()) {
            return true;
        }
        return false;
    }
}
