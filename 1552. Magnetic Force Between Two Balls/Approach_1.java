class Solution {
    public int maxDistance(int[] position, int m) {
        int lo = 1, hi = Integer.MAX_VALUE;
        int ans =0;
        Arrays.sort(position);
        while(lo <= hi){
            int mid = lo+(hi -lo)/2;
            if(check(position, mid, m)){
                ans = mid;
                lo =mid+1;
            }else hi = mid-1;
        }
        return ans;

    }
    private boolean check(int[] arr, int mid, int m){
        int place =1;
        int curr = arr[0];
        int n = arr.length;
        for(int i=1; i<n; i++){
           if(arr[i] - curr >= mid){
            curr = arr[i];
            place++;
           }
        }
        if(place < m)return false;
        return true;
    }
}