package com.ceitechs.domain.verification;


import java.util.Arrays;

public class PangoDomainVerificationApplication {

    public static void main(String[] args) {
        String str = "localhost:27017";
        System.out.println(Arrays.toString(str.split(",")));
    }
}
