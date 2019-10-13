package perfectSquares;

import java.util.Arrays;

public class FindLeastSquareNumberSumFunction {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        // Fill up the array with largest value so which ever number will replace
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // First index will be zero since square root of 0 is 0
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++){
            int sqrt = (int)Math.sqrt(i);
            
            // This will make sure if its a square number like 1, 4, 9, 16, just make that current array 1 and continue the loop without going in the second loop
            if(sqrt * sqrt == i){
                dp[i] = 1;
                continue;
            }
            
            // j * j since we want 1, 4, 9, 16 and so on
            for(int j = 1; j * j <= i; j++){
            	// Filling up the dp[i] from 1 to n
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        // dp[n] will be the least square number sum
        return dp[n];
    }
}
