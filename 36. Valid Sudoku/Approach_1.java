class Solution {
    public boolean isValidSudoku(char[][] board) {
        // all rows
        for(int i=0; i<9;i++){
            HashSet<Character> set = new HashSet<>();
                
            for(int j=0; j<9; j++){
                if(board[i][j] =='.')continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        // all cols
        for(int j=0; j<9;j++){
            HashSet<Character> set = new HashSet<>();
            for(int i=0; i<9; i++){
                if(board[i][j] =='.')continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        // all boxes
        for(int i=0; i<9; i+=3){
            int endI = i+2;
            for(int j=0; j<9; j+=3){
                int endJ = j+2;
                if(!traverseBox(i, endI, j, endJ, board)) return false;
                
            }

        }

        return true;

    }
    private boolean traverseBox(int si, int ei, int sj, int ej, char[][] mat){
        HashSet<Character> set = new HashSet<>();
        for(int i=si; i<=ei; i++){
            for(int j=sj; j<=ej; j++){
                if(mat[i][j] == '.')continue;
                if(set.contains(mat[i][j])) return false;
                set.add(mat[i][j]);
            }
        }
        return true;
    }
}