class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        int n = nums.length;
        int j=0;
        int sum=0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            while(sum >= target){
                size = Math.min(size, i-j+1);
                sum -= nums[j++];
            }

        }
        return size == Integer.MAX_VALUE ?0 : size;
    }
}