# 395. Longest Substring with At Least K Repeating Characters

### Difficulty: Medium

## Description
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

if no such substring exists, return 0.

 
Example 1:


Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.


Example 2:


Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.


 
Constraints:


	1 <= s.length <= 104
	s consists of only lowercase English letters.
	1 <= k <= 105

## Submission Details
- **Status**: Accepted
- **Runtime**: 0 ms
- **Memory**: 42656000
- **Language**: java

## Code
```java
class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(s == null || n < k) return 0;
        int[] feq = new int[26];
        for(char c: s.toCharArray()) feq[c -'a']++;
        int i=0;
            while(i<n && feq[s.charAt(i) -'a'] >= k ){
                i++;
            }
            if(i >= n) return n;
            int left = longestSubstring(s.substring(0, i), k);
            while(i < n && feq[s.charAt(i)-'a'] < k ) i++;

            int right = (i< n) ? longestSubstring(s.substring( i), k) : 0;
            
            
        
            
        return Math.max(left, right);
        
    }
}
```
