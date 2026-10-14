# 739. Daily Temperatures

### Difficulty: Medium

## Description
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 
Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]

 
Constraints:


	1 <= temperatures.length <= 105
	30 <= temperatures[i] <= 100

## Submission Details
- **Status**: Accepted
- **Runtime**: 82
- **Memory**: 106476000
- **Language**: java

## Code
```java
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && temp[st.peek()] <= temp[i] ){
                st.pop();
            }
            if(st.isEmpty()) ans[i] =0;
            else ans[i] = st.peek() -i;
            st.push(i);
        }
        return ans;
    }
}
```
