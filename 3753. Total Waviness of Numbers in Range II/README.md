# 3753. Total Waviness of Numbers in Range II

### Difficulty: Hard

## Description
You are given two integers num1 and num2 representing an inclusive range [num1, num2].

The waviness of a number is defined as the total count of its peaks and valleys:


	A digit is a peak if it is strictly greater than both of its immediate neighbors.
	A digit is a valley if it is strictly less than both of its immediate neighbors.
	The first and last digits of a number cannot be peaks or valleys.
	Any number with fewer than 3 digits has a waviness of 0.

Return the total sum of waviness for all numbers in the range [num1, num2].
&nbsp;
Example 1:


Input: num1 = 120, num2 = 130

Output: 3

Explanation:

In the range [120, 130]:


	120: middle digit 2 is a peak, waviness = 1.
	121: middle digit 2 is a peak, waviness = 1.
	130: middle digit 3 is a peak, waviness = 1.
	All other numbers in the range have a waviness of 0.


Thus, total waviness is 1 + 1 + 1 = 3.


Example 2:


Input: num1 = 198, num2 = 202

Output: 3

Explanation:

In the range [198, 202]:


	198: middle digit 9 is a peak, waviness = 1.
	201: middle digit 0 is a valley, waviness = 1.
	202: middle digit 0 is a valley, waviness = 1.
	All other numbers in the range have a waviness of 0.


Thus, total waviness is 1 + 1 + 1 = 3.


Example 3:


Input: num1 = 4848, num2 = 4848

Output: 2

Explanation:

Number 4848: the second digit 8 is a peak, and the third digit 4 is a valley, giving a waviness of 2.


&nbsp;
Constraints:


	1 &lt;= num1 &lt;= num2 &lt;= 1015​​​​​​​

## Submission Details
- **Status**: Accepted
- **Runtime**: 23
- **Memory**: 42832000
- **Language**: java

## Code
```java
class Solution {
    private static int[] waves = new int[570];
    static{
        int j=0;
        for(int i=0; i<1000; i++){
            int r =i%10;
            int mid = (i/10)%10;
            int l = (i/100)%10;
            if(mid > Math.max(l, r) || mid < Math.min(l,r)){
                waves[j++] =i;
            }
        }
    }
    public long totalWaviness(long num1, long num2) {
        return wavesCount(num2) - wavesCount(num1-1);
    }
    private long wavesCount(long num){
        if(num < 100)return 0;
        long ans= 0;
        for(int x: waves){
            ans += countWays(num, x);
        }
        return ans;
    }
    private long countWays(long num, int p){
        long type = p < 100 ? 1:0;
        long ways =0;
        long mult =1;
        for(int i=0; i<16; i++){
            if(mult*100 > num) break;
            long pre = num/(mult*1000);
            long curr = (num/mult)%1000;
            long suf = num% mult;
            
            long count =0, edge=0;
            if(curr > p){
                count = pre - type+1;
            }else if(curr == p){
                count = Math.max(0L, pre-type);
                if(pre >= type){
                    edge = suf+1;
                }
            }else{
                count = Math.max(0L, pre- type);
            }
            ways += count * mult+edge;
            mult *= 10;
        }
        return ways;
    }
}
```
