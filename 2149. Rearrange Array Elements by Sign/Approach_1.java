class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n= nums.length;
        int[] ans = new int[n];
        int idx=0;
        for(int x: nums){
            if(x >0){
                ans[idx] = x;
                idx += 2;
            }
        }
        idx= 1;
        for(int x: nums){
            if(x <0){
                ans[idx] = x;
                idx += 2;
            }
        }
        return ans;
    }
}