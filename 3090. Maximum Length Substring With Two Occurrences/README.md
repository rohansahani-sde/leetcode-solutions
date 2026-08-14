# 3090. Maximum Length Substring With Two Occurrences

### Difficulty: Easy

## Description
Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character.
 
Example 1:


Input: s = "bcbbbcba"

Output: 4

Explanation:
The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".

Example 2:


Input: s = "aaaa"

Output: 2

Explanation:
The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".

 
Constraints:


	2 <= s.length <= 100
	s consists only of lowercase English letters.

## Submission Details
- **Status**: Accepted
- **Runtime**: 1
- **Memory**: 43748000
- **Language**: java

## Code
```java
class Solution {
    public int maximumLengthSubstring(String s) {
        int[] arr = new int[26];
        int j =0, i=0;
        int max = 0;
        for(char ch: s.toCharArray()){
            arr[ch-'a']++;
            while(arr[ch-'a'] > 2){
                char left = s.charAt(j++);
                arr[left-'a']--;
            }
            max = Math.max(max, i-j+1);
            i++;

        }
        return max;
    }
}
```
