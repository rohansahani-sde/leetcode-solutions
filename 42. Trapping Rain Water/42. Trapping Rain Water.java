class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rmax = new int[n];
        int max = height[n-1];
        for(int i=n-1; i>=0; i--){
            max = Math.max(max,height[i]);
            rmax[i] = max;
        }
        max = height[0];
        int total=0;
        for(int i=0; i<n; i++){
            max =Math.max(max, height[i]);
            int min = Math.min(max, rmax[i]);
            total += Math.abs(min - height[i]);
        }
        return total;
    }
}