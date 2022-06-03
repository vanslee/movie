package com.ldx.utils;

import java.util.UUID;

public class MyUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
