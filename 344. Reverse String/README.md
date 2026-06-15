# 344. Reverse String

### Difficulty: Easy

## Description
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

&nbsp;
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

&nbsp;
Constraints:


	1 &lt;= s.length &lt;= 105
	s[i] is a printable ascii character.

## Submission Details
- **Status**: Accepted
- **Runtime**: 0 ms
- **Memory**: 48376000
- **Language**: java

## Code
```java
class Solution {
    public void reverseString(char[] s) {
        int i=0, j= s.length-1;
        while(i <  j){
            char t = s[i];
            s[i++] = s[j];
            s[j--] = t;
        }

        
    }
}
```
