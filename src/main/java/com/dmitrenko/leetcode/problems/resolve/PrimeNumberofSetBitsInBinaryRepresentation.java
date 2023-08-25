package com.dmitrenko.leetcode.problems.resolve;

public class PrimeNumberofSetBitsInBinaryRepresentation {

    public int countPrimeSetBits(int left, int right) {
        var count = 0;
        for (int i = left; i <= right; i++) {
            var bites = Integer.toBinaryString(i);
            int f = 0;
            for (int j = 0; j < bites.length(); j++) {
                if (bites.charAt(j) == '1') f++;
            }
            if(isPrime(f)) count++;
        }
        return count;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new PrimeNumberofSetBitsInBinaryRepresentation().countPrimeSetBits(5, 10);
    }
}
