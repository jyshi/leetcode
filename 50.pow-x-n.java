/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return myPow(1 / x, Integer.MAX_VALUE) / x;
            }
            return myPow(1 / x, -n);
        }
        // double[] dp = new double[32];
        // dp[0] = x;
        // for (int i = 1; i < 32; i++) {
        //     dp[i] = dp[i - 1] * dp[i - 1];
        // }
        // double result = 1.0;
        // int i = 0;
        // while(n > 0) {
        //     if ((n & 1) == 1) {
        //         result *= dp[i];
        //     }
        //     n >>= 1; 
        //     i++;
        // }
        double result = 1.0;
        for (int i = n; i > 0; i /= 2) {
            if ((i & 1) == 1) {
                result *= x;
            }
            x *= x;
        }
        return result;

    }
}
// @lc code=end
// 2^4 = (2^2)*(2^2)
// 2^32 = (2^16)*(2^16)

// 1 = (01)
// 2 = (10)
// 3 = (11)
// 4 = (100)
// 5 = (101)
// 6 = (110)
// 7 = (111)
// 8 = (1000)
// 9 = (1001)
// 10 = (1010) = 2^1+2^3 
// dp [x^8, x^4, x^2, x^1]
// x^10 = x^(2^1+2^3) = x^2^1 * x^2^3 = 
// 2^31 - 1 = (111...111)
                //  31