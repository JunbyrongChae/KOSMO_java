package Prac.programers;

import java.math.BigInteger;

public class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        boolean val = (0<numer1 && numer1<1000 && 0<numer2&&numer2<1000&&0<denom1&&denom1<1000&&0<denom2&&denom2<1000&&denom1!=denom2);
        if(val){
            int numerator = numer1 * denom2 + numer2 * denom1;
            int denominator = denom1 * denom2;

            int gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue();

            return new int[] { numerator / gcd, denominator / gcd };
        }
        return answer;
    }
}