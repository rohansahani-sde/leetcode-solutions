class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>(); 
        char[][] mat = new char[n][n];
        boolean[] colVis = new boolean[n];
        for(char[] ma: mat){
            Arrays.fill(ma, '.');
        }
        fun(mat, 0, n, ans, colVis);
        
        return ans;
        
    }
    private void fun(char[][] mat, int row, int n, List<List<String>> ans, boolean[] colVis ){
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
            if(isValidPlace(mat, row, j, n, colVis)){
            mat[row][j] = 'Q';
            colVis[j] = true;
            fun(mat, row+1, n, ans, colVis);
            colVis[j] = false;
            mat[row][j] ='.';
            } 
             
        }
    }
    private boolean isValidPlace(char[][] mat, int row, int col, int n, boolean[] colVis) {
        if(colVis[col]) return false;
    // for (int i = 0; i < row; i++) {
    //     if (mat[i][col] == 'Q') return false;
    // }

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