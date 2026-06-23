class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count =0;
        for(int i=0; i<n;  i++){
            if(!vis[i]){
                dfs(isConnected, vis, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] arr, boolean[] vis, int src){
        vis[src] = true;
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[src][i] == 1 && !vis[i]){
                dfs(arr, vis, i);
            }
        }
    }
}