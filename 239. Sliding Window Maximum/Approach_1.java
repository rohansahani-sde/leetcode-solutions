class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int idx =0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<k; i++){

            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        for(int i=k; i<n; i++){
            ans[idx++] = nums[dq.peekFirst()];

            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        ans[idx++] = nums[dq.peekFirst()];
        return ans;
        
    }
}