# 37. Sudoku Solver

### Difficulty: Hard

## Description
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:


	Each of the digits 1-9 must occur exactly once in each row.
	Each of the digits 1-9 must occur exactly once in each column.
	Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.


The '.' character indicates empty cells.

 
Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:




 
Constraints:


	board.length == 9
	board[i].length == 9
	board[i][j] is a digit or '.'.
	It is guaranteed that the input board has only one solution.

## Submission Details
- **Status**: Accepted
- **Runtime**: 227
- **Memory**: 42988000
- **Language**: java

## Code
```java
class Solution {
    public void solveSudoku(char[][] board) {
        fun(board);
    }
    private boolean fun(char[][] mat){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(mat[i][j] == '.'){
                    for(int val=1; val<=9; val++){
                        char ch = (char) (val + '0'); 
                        if( isValidToPut(i, j, ch, mat) ){
                            mat[i][j] = ch;
                            if( fun(mat)) return true;
                            mat[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValidToPut(int i, int j, char ch, char[][] mat){
        for(int k=0; k<9; k++){
            if(mat[i][k] == ch)return false;
            if(mat[k][j] == ch)return false;
        }
        int sRow = (i / 3) * 3;
        int sCol = (j / 3) * 3;
        for(int row=sRow; row<sRow+3; row++){
            for(int col= sCol; col<sCol+3; col++){
                if(mat[row][col] == ch) return false;
            }
        }
        return true;
    }
}
```
