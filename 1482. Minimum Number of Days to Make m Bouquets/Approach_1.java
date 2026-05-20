class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = -1;
        for(int x: bloomDay)max = Math.max(max, x);
        int lo=1, hi =max;
        int ans = -1;
        while(lo <= hi){
            int mid = lo +(hi - lo)/2;
            if(check(bloomDay, mid, m, k)){
                ans = mid;
                hi = mid-1;
            }else lo =mid+1;
        }
        return ans;
    }

    private boolean check(int[] arr, int mid,int m, int k){
        int count = 0;
        int n = arr.length;
        int curr =0;
        for(int i=0; i<n; i++){

            if(arr[i] <= mid)curr++;
            else curr = 0;

            if(curr == k){
                count++;
                curr =0;
            }
            if(count >= m )return true;
        }

        return false;
    }
}
