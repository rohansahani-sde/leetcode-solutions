class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return fun(nums, k) - fun(nums, k-1);
    } 
    private int fun(int[] nums, int k){
        int n = nums.length;
        int j=0;
        int ans=0;
        int count =0;
        for(int i=0; i<n; i++){
            if(nums[i] % 2 != 0)count++;
            while(count > k){
                if(nums[j] % 2 != 0)count--;
                j++;
            }
            ans += (i-j+1);
        }
        return ans;
    }
}