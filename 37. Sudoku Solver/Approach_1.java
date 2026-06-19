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