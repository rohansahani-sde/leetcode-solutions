class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] feq = new int[n+1];
        for(int i=0; i<n; i++){
            feq[nums[i]]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            if(feq[i] == 2){
                ans.add(i);
            }
        }
        return ans;


    }
}