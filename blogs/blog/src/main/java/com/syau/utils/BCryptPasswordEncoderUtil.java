package com.syau.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtil {

    private static BCryptPasswordEncoder bCryptPasswordEncoder  = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123";
        String pwd1 = encodePassword(password);
        System.out.println("pwd = " + pwd1);
        String pwd2 = encodePassword(password);
        System.out.println("pwd = " + pwd2);
        String pwd3 = encodePassword(password);
        System.out.println("pwd = " + pwd3);
    }
}
