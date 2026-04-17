class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n =  nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i])){
                min = Math.min(min, Math.abs(i - map.get(nums[i])));
            }
            map.put(rev(nums[i]), i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private int rev(int num){
        int ans = 0;
        while(num >0){
            int d = num%10;
            ans = ans*10 + d;
            num /= 10;
        }
        return ans;
    }
}