class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int x: nums){
            minVal =Math.min(minVal, x);
            maxVal =Math.max(maxVal, x);
        }

        return ((long)(maxVal - minVal))*k;
    }
}