# 498. Diagonal Traverse

### Difficulty: Medium

## Description
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

&nbsp;
Example 1:


Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]


Example 2:


Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]


&nbsp;
Constraints:


	m == mat.length
	n == mat[i].length
	1 &lt;= m, n &lt;= 104
	1 &lt;= m * n &lt;= 104
	-105 &lt;= mat[i][j] &lt;= 105

## Submission Details
- **Status**: Accepted
- **Runtime**: 2
- **Memory**: 48332000
- **Language**: java

## Code
```java
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] ans= new int[n*m];
        int r=0, c=0;
        for(int i=0; i<n*m; i++){
            ans[i] = mat[r][c];

            if((r+c) % 2 ==0){
                if(c== m-1)r++;
                else if(r == 0)c++;
                else{ r--;c++;}

            }else{
                if(r == n-1)c++;
                else if(c ==0)r++;              
               else {r++;c--;}
            }
        }
        
        return ans;
    }
}
```
