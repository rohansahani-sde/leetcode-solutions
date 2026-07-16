class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for(int i=1; i<=n; i++){
            pre[i] = pre[i-1] + nums[i-1];
        }
        int ans =n+1;
        for(int i=0; i<n; i++){
            int lo = i+1, hi = n;

            while(lo <= hi){
                int mid = lo + (hi -lo)/2;
                if( pre[mid] - pre[i] >= target  ){
                    ans = Math.min(ans, mid - i);
                    hi = mid-1;
                }else lo = mid +1;
            }
        }
        return ans == n+1 ? 0 : ans;

    }
    
}