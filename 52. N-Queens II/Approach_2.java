class Solution {
    boolean[] colVis;
    boolean[] mainDia;
    boolean[] oppDia;
    public int totalNQueens(int n) {
        List<Integer> ans = new ArrayList<>(); 
        char[][] mat = new char[n][n];
        colVis = new boolean[n];
        mainDia = new boolean[(2*n)-1];
        oppDia = new boolean[(2*n)-1];
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
            if(!colVis[j] && !mainDia[row - j + n-1] && !oppDia[row+j]  ){
            mat[row][j] = 'Q';
            colVis[j] = mainDia[row - j + n-1] =oppDia[row+j] = true;
            fun(mat, row+1, n, ans);
            colVis[j] = mainDia[row - j + n-1] =oppDia[row+j] = false;
            mat[row][j] ='.';
            } 
             
        }
    }
}