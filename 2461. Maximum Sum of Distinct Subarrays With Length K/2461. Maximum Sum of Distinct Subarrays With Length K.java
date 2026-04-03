class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int j=0;
        long sum =0;
        long max = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(i-j+1 > k){
                map.put(nums[j], map.get(nums[j])-1);
                if(map.get(nums[j]) ==0) map.remove(nums[j]);
                sum -= nums[j++];
            }
            if(i-j+1 ==k && map.size() == k){
                max = Math.max(max, sum);
            }

        }
        return max;
    }
}