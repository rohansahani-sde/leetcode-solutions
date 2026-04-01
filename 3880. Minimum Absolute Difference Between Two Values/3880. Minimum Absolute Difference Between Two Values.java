class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int ans =101;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int x = nums[i];
            if(x == 1){
                for(int j=0; j<n; j++){
                    int y= nums[j];
                    if(y ==2){
                        ans = Math.min(ans, Math.abs(j-i));
                    }
                }
            }
        }
        return ans != 101 ? ans : -1; 
    }
}