class Solution {
    public int minimumOperations(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int sum =0;
        for(int c=0; c<m; c++){
            for(int i=1; i<n; i++){
                if(grid[i-1][c] < grid[i][c])continue;
                int need = (grid[i-1][c] + 1) - grid[i][c];
                grid[i][c] += need;
                sum += need;
            }
        }
        return sum;
    }
}