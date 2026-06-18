# 51. N-Queens

### Difficulty: Hard

## Description
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 
Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above


Example 2:


Input: n = 1
Output: [["Q"]]


 
Constraints:


	1 <= n <= 9

## Submission Details
- **Status**: Accepted
- **Runtime**: 3
- **Memory**: 46856000
- **Language**: java

## Code
```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>(); 
        char[][] mat = new char[n][n];
        for(char[] ma: mat){
            Arrays.fill(ma, '.');
        }
        fun(mat, 0, n, ans);
        
        return ans;
        
    }
    private void fun(char[][] mat, int row, int n, List<List<String>> ans ){
        if(row == n){
            List<String> l = new ArrayList<>();

            for(char[] ma: mat){
                String s = new String(ma);
                l.add(s);
            }
            ans.add(new ArrayList<>(l));
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
