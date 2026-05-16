class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return fun(piles, h);
    }
    private int fun(int[] arr, int h){
        int hi = -1;
        int lo = 1;
        for(int x: arr) hi = Math.max(hi, x);
        int ans = -1;
        
        while( lo <= hi){
            int mid = lo +(hi -lo)/2;
            if(canEat(arr, mid, h)){
                ans = mid;
                hi = mid-1;
            }else lo =mid+1;
        }
        return ans;
    }
    private boolean canEat(int[] arr, int mid, int h){
        long time = 0;
        for(int x: arr){
            time += (x + mid -1)/mid;
        }
        return time <= h;
    }
}