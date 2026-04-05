class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        int max = -1;
        for(int i=n-1; i>=0; i--){
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }
        int leftMax = -1, totalSum=0;
        for(int i=0; i<n; i++){
            leftMax = Math.max(leftMax, height[i]);
            int min = Math.min(leftMax, rightMax[i]);
            totalSum += Math.abs(height[i] - min);
        }
        return totalSum;
    }
}