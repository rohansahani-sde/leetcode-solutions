# 50. Pow(x, n)

### Difficulty: Medium

## Description
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

&nbsp;
Example 1:


Input: x = 2.00000, n = 10
Output: 1024.00000


Example 2:


Input: x = 2.10000, n = 3
Output: 9.26100


Example 3:


Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


&nbsp;
Constraints:


	-100.0 &lt; x &lt; 100.0
	-231 &lt;= n &lt;= 231-1
	n is an integer.
	Either x is not zero or n &gt; 0.
	-104 &lt;= xn &lt;= 104

## Submission Details
- **Status**: Accepted
- **Runtime**: 0 ms
- **Memory**: 47864000
- **Language**: java

## Code
```java
class Solution {
    public double myPow(double x, int n) {
        
        if(n < 0){
            double half = getPow(x, Math.abs(n/2));
            if(Math.abs(n) % 2 ==0){
                return 1/(half*half);
            }else return 1/(x *(half*half));
        }
        double val = 
        getPow(x, n/2);
            if(n % 2 ==0){
                return val*val;
            }else return x *(val*val);
        
    }
    private double getPow(double x, int n){
        if(n ==0) return 1;
        double half = getPow(x, n/2);
        if(n%2 ==0){
            return half*half;
        }
        return x*half*half;
        
    }
}
```
