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