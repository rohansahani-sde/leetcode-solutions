class Solution {
    public int maximumCandies(int[] candies, long k) {
        long lo = 1, hi = Long.MAX_VALUE;
        long ans = 0;
        while(lo <= hi){
            long mid = lo +(hi - lo)/2L;

            if(check(candies,mid, k)){
                ans = mid;
                lo = mid+1;
            }else hi = mid-1;
        }
        return (int)ans;
    }
    private boolean check(int[] arr, long mid, long k){
        long count =0;
        for(int x: arr){
            count += ((long)x/mid);
            if(count >= k)return true;
        }
        return false;

    }
}