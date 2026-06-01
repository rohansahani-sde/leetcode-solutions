class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans =0;
        int idx=0;
        int n = cost.length;
        for(int i=n-1; i>=0; i--){
            idx++;
            if(idx%3 ==0)continue;
            ans += cost[i];
        }
        return ans;
    }
}