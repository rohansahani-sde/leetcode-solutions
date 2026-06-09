# 1380. Lucky Numbers in a Matrix

### Difficulty: Easy

## Description
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

&nbsp;
Example 1:


Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.


Example 2:


Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.


Example 3:


Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.


&nbsp;
Constraints:


	m == mat.length
	n == mat[i].length
	1 &lt;= n, m &lt;= 50
	1 &lt;= matrix[i][j] &lt;= 105.
	All elements in the matrix are distinct.

## Submission Details
- **Status**: Accepted
- **Runtime**: 7
- **Memory**: 47228000
- **Language**: java

## Code
```java
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int row = matrix[i][j];
                int col = matrix[i][j];
                for(int k=0; k<n; k++) col = Math.max(col, matrix[k][j]);
                for(int k=0; k<m; k++) row = Math.min(row, matrix[i][k]);
                if(row == col)ans.add(row);
            }
        }
        return ans;
    }
}
```
