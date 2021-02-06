package yd.fib_rest_service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class FibonacciService {

    public String genFib(long n) {
        BigInteger arr1[][] = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        if (n == 0)
            return "0";
        else {
            power(arr1, n - 1);
            return arr1[0][0].toString();
        }
    }

    private void power(BigInteger arr1[][], long n) {
        if (n == 0 || n == 1)
            return;
        BigInteger arr2[][] = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        power(arr1, n / 2);
        multiply(arr1, arr1);
        if (n % 2 != 0)
            multiply(arr1, arr2);
    }

    private void multiply(BigInteger arr1[][], BigInteger arr2[][]) {
        BigInteger x = (arr1[0][0].multiply(arr2[0][0])).add(arr1[0][1].multiply(arr2[1][0]));
        BigInteger y = (arr1[0][0].multiply(arr2[0][1])).add(arr1[0][1].multiply(arr2[1][1]));
        BigInteger z = (arr1[1][0].multiply(arr2[0][0])).add(arr1[1][1].multiply(arr2[1][0]));
        BigInteger w = (arr1[1][0].multiply(arr2[0][1])).add(arr1[1][1].multiply(arr2[1][1]));
        arr1[0][0] = x;
        arr1[0][1] = y;
        arr1[1][0] = z;
        arr1[1][1] = w;
    }

}