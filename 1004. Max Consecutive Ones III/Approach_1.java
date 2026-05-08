class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int oneCount =0;
        for(int x: nums)if(x == 1)oneCount++;
        if(oneCount == 0) return k < n ? k :n ;
        int max = 0;
        int one =0;
        int zero =0;
        int j=0;
        for(int i=0; i<n; i++){
            if(nums[i] ==0) zero++;
            if(nums[i] == 1) one++;

            if(zero <= k){
                max = Math.max(max, one+zero);
            }
            else{
                while(zero > k && j<i){
                    if(nums[j] ==0)zero--;
                    if(nums[j] ==1)one--;
                    j++;
                }
                max = Math.max(max, one+zero);
            }
        }
        
        return max;
    }
}