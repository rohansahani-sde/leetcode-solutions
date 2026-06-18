# 52. N-Queens II

### Difficulty: Hard

## Description
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 
Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.


Example 2:


Input: n = 1
Output: 1


 
Constraints:


	1 <= n <= 9

## Submission Details
- **Status**: Accepted
- **Runtime**: 2
- **Memory**: 41944000
- **Language**: java

## Code
```java
class Solution {
    public int totalNQueens(int n) {
        List<Integer> ans = new ArrayList<>(); 
        char[][] mat = new char[n][n];
        for(char[] ma: mat){
            Arrays.fill(ma, '.');
        }
        fun(mat, 0, n, ans);
        
        return ans.size();
        
    }
    private void fun(char[][] mat, int row, int n, List<Integer> ans ){
        if(row == n){
            
            ans.add(1);
            return;
        }

        for(int j=0; j<n; j++){
            if(isValidPlace(mat, row, j, n)){
            mat[row][j] = 'Q';
            fun(mat, row+1, n, ans);
            mat[row][j] ='.';
            } 
             
        }
    }
    private boolean isValidPlace(char[][] mat, int row, int col, int n) {
    for (int i = 0; i < row; i++) {
        if (mat[i][col] == 'Q') return false;
    }

    int r = row, c = col;
    while (r >= 0 && c >= 0) {
        if (mat[r][c] == 'Q') return false;
        r--;
        c--;
    }

    r = row;
    c = col;
    while (r >= 0 && c < n) {
        if (mat[r][c] == 'Q') return false;
        r--;
        c++;
    }

    return true;
}
}
```
