class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx=-1;
        int maxIdx=-1;
        int n = nums.length;
        int x=0;
        for(int i=0; i<n; i++){
            x = nums[i];
            if(min > x){
                min = x;
                minIdx=i;
            }
            if(max < x){
                max = x;
                maxIdx=i;
            }
        }
        int c1 = Math.max(minIdx, maxIdx)+1;
        int c2 = n - Math.min(minIdx, maxIdx);
        int c3 = Math.min(minIdx, maxIdx)+1 + n - Math.max(maxIdx, minIdx);
        return Math.min(c1, Math.min(c2, c3));

    }
}