package com.bugbean.studydemo.java8;

/**
 * 外卖-订单
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class TestJava8 {
    public static void main(String[] args) {
        subtractProductAndSum(0);
    }

    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int mul = 1;

        while (n>0) {
            int remainder =  n % 10;
            sum += remainder;
            mul *= remainder;
            n /= 10;
        }
        return mul - sum;
    }
}
