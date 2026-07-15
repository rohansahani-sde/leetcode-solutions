# 680. Valid Palindrome II

### Difficulty: Easy

## Description
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 
Example 1:


Input: s = "aba"
Output: true


Example 2:


Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.


Example 3:


Input: s = "abc"
Output: false


 
Constraints:


	1 <= s.length <= 105
	s consists of lowercase English letters.

## Submission Details
- **Status**: Accepted
- **Runtime**: 4
- **Memory**: 47720000
- **Language**: java

## Code
```java
class Solution {
    public boolean validPalindrome(String s) {
        int i=0, j= s.length()-1;
        int c=0;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }else{
                i++;j--;
            }
        }
        return true;
    }
    private boolean isPalindrome(String s, int i, int j){
        while(i <j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
```
