class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>(); 
        char[][] mat = new char[n][n];
        boolean[] colVis = new boolean[n];
        boolean[] mainDia = new boolean[(2*n)-1];
        boolean[] oppDia = new boolean[(2*n)-1];
        for(char[] ma: mat){
            Arrays.fill(ma, '.');
        }
        fun(mat, 0, n, ans, colVis, mainDia, oppDia);
        
        return ans;
        
    }
    private void fun(char[][] mat, int row, int n, List<List<String>> ans, boolean[] colVis,  boolean[] mainDia, boolean[] oppDia ){
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
            if(isValidPlace(mat, row, j, n, colVis, mainDia, oppDia)){
            mat[row][j] = 'Q';
            colVis[j] = true;
            mainDia[row - j +n-1] = oppDia[row+j] = true;
            fun(mat, row+1, n, ans, colVis, mainDia, oppDia);
            colVis[j] = false;
            mainDia[row - j +n-1] = oppDia[row+j] = false;
            mat[row][j] ='.';
            } 
             
        }
    }
    private boolean isValidPlace(char[][] mat, int row, int col, int n, boolean[] colVis,  boolean[] mainDia, boolean[] oppDia) {
        if(colVis[col]) return false;
        if(mainDia[row - col +n-1] || oppDia[row+col]) return false;
        return true;
}
}