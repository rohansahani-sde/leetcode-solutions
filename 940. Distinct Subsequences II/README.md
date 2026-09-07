# 940. Distinct Subsequences II

### Difficulty: Hard

## Description
Given a string s, return the number of distinct non-empty subsequences of s. Since the answer may be very large, return it modulo 109 + 7.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not.
 
Example 1:


Input: s = "abc"
Output: 7
Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".


Example 2:


Input: s = "aba"
Output: 6
Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".


Example 3:


Input: s = "aaa"
Output: 3
Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".


 
Constraints:


	1 <= s.length <= 2000
	s consists of lowercase English letters.

## Submission Details
- **Status**: Accepted
- **Runtime**: 4
- **Memory**: 44056000
- **Language**: java

## Code
```java
class Solution {
    int MOD = 1000000007;
    int[] pre;
    int[] dp;
    
    public int distinctSubseqII(String s) {
        int n = s.length();
        dp =new int[2001];
        Arrays.fill(dp, -1);
        pre = new int[n+1];
        int[] last = new int[26];
        for(int i=1; i<=n; i++){
            int idx = s.charAt(i-1) - 'a';
            pre[i] = last[idx];
            last[idx] =i;
        }
        return (fun(n) - 1 + MOD) % MOD;
    }
    private int fun(int n){
        if(n ==0) return 1;
        if(dp[n] != -1) return dp[n];

        long total = (fun(n-1) * 2L) % MOD;
        if(pre[n] != 0){
            int duplicate = fun(pre[n] -1);
            total = (total - duplicate + MOD)%MOD;
        }


        return dp[n] = (int)total;
        
    }
}
```
