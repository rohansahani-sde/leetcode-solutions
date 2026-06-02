# 1390. Four Divisors

### Difficulty: Medium

## Description
Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.

&nbsp;
Example 1:


Input: nums = [21,4,7]
Output: 32
Explanation: 
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.


Example 2:


Input: nums = [21,21]
Output: 64


Example 3:


Input: nums = [1,2,3,4,5]
Output: 0


&nbsp;
Constraints:


	1 &lt;= nums.length &lt;= 104
	1 &lt;= nums[i] &lt;= 105

## Submission Details
- **Status**: Accepted
- **Runtime**: 9
- **Memory**: 46180000
- **Language**: java

## Code
```java
class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans= 0;
        for(int x: nums){
            int c=0;
            int sum =0;
            for(int i=1; i*i <= x; i++){
                if(x % i ==0){
                    sum += i;
                    c++;
                    if(i != x/i){
                        sum += x/i;
                        c++;
                    }
                }
                if(c > 4)break;
            }
            if(c == 4) ans += sum;
        }
        
        return ans;
    }
}
```
