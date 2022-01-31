package com.nevexis.bankspring;

public class SumImpl implements Sum {

    @Override
    public int add(int first, int second) {
        int result = first + second;
        return result;
    }
}
