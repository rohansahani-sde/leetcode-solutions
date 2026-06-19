# 322. Coin Change

### Difficulty: Medium

## Description
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 
Example 1:


Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1


Example 2:


Input: coins = [2], amount = 3
Output: -1


Example 3:


Input: coins = [1], amount = 0
Output: 0


 
Constraints:


	1 <= coins.length <= 12
	1 <= coins[i] <= 231 - 1
	0 <= amount <= 104

## Submission Details
- **Status**: Accepted
- **Runtime**: 45
- **Memory**: 47464000
- **Language**: java

## Code
```java
class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length+1][amount+1];
        for( int[] d: dp)Arrays.fill(d, -1);
        int ans= fun(coins, amount, 0);
        return ans ==Integer.MAX_VALUE ? -1 : ans;
    }
    private int fun(int[] arr, int amt, int idx){
        if(amt ==0)return 0;
        if(idx >= arr.length || amt < 0 )return Integer.MAX_VALUE;
        if(dp[idx][amt] != -1) return dp[idx][amt];
        int take = fun(arr, amt-arr[idx], idx);
        if(take != Integer.MAX_VALUE) take++;
        
        int not = fun(arr, amt, idx+1);
        
        return dp[idx][amt] = Math.min(take, not);
    }
}
```
