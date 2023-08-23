package com.miniFawry.couponAPI.Excptions;

public class ValueException extends RuntimeException {

    public ValueException(String v1, String v2) {
        super("Value must be between" + v1 +  "and" +  v2 + ".");

    }

}
