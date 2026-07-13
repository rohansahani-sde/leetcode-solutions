class Solution {
    public int minSubarray(int[] nums, int p) {
        // int Tsum=0;
        // for(int x: nums) Tsum = (Tsum+x)%p;
        // int k = (Tsum % p);
        // if(k==0) return 0;

        // Map<Integer, Integer> map = new HashMap<>();
        // map.put(0, -1);
        // int n = nums.length;
        // int ans = n;
        // int sum =0;
        // for(int i=0; i<n; i++){
        //     sum  +=nums[i];
        //    // int need = (sum - k + p) %p;
        //    int need = p-sum%p;
        //    if(sum%p==0){
        //     ans=Math.min(ans,n-i);
        //     continue;
        //    }else if(map.containsKey(need)){
        //         ans = Math.min(ans, i - map.get(need));
        //     }
        //     map.put(sum%p, i);
        // } 
        // return ans;

 int Tsum=0;
        for(int x: nums) Tsum = (Tsum+x)%p;
        int k = (Tsum % p);
        if(k==0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = nums.length;
        int ans = n;
        int sum =0;
        for(int i=0; i<n; i++){
            sum  = (sum+nums[i]) % p;
            int need = (sum - k + p) %p;
            if(map.containsKey(need)){
                ans = Math.min(ans, i - map.get(need) );
            }
            map.put(sum, i);
        } 
        
        return ans == n ? -1 : ans;
    }
}

