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