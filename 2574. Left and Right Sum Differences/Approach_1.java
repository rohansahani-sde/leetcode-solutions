class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        if(n == 1) return new int[]{0};
        
        int rightSum =0;
        for(int i=n-2; i>=0; i--){
            rightSum += nums[i+1];
        }
        int[] ans = new int[n];
        int leftSum =0;
        ans[0] = rightSum;
        for(int i=1; i<n-1; i++){
            leftSum += nums[i-1];
            rightSum -= nums[i];
            ans[i] = Math.abs(leftSum - rightSum);
        }
        ans[n-1] = leftSum+nums[n-2];
        return ans;
    }
}