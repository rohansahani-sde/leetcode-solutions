class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = Integer.MAX_VALUE;
        int ans = 0;
        while(lo <= hi){
            int mid = lo +(hi - lo)/2;
            if(check(nums, mid, threshold)){
                ans = mid;
                hi = mid-1;
            }else lo = mid+1;
        }
        return ans;
    }
    private boolean check(int[] arr, int mid, int k) {
        int sum =0;
        for(int x: arr){
            sum += Math.ceilDiv(x, mid);
        }
        if(sum <= k) return true;
        return false;
    }
}