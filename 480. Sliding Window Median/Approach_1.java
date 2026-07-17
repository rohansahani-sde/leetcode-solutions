class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<k; i++) list.add(nums[i]);

        int n = nums.length;
        double[] ans = new double[n-k+1];
        int idx =0;
        Collections.sort(list);
        ans[idx++] = val(list, k);

        for(int i=k; i<n; i++){
            list.remove(Integer.valueOf(nums[i - k]));
            int pos = Collections.binarySearch(list, nums[i]);
            if (pos < 0) pos = -pos - 1;
            list.add(pos, nums[i]);
            
            ans[idx++] = val(list, k);    
        }
        

        return ans;
    }
    private double val(List<Integer> l, int k){
        
        int n = l.size();
        if(k % 2 ==0){
            return ((double) l.get(n/2) + l.get(n/2 - 1)) / 2.0; 
        }
        return l.get(n/2);
    }
}