class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, 0, ans, new ArrayList<>());
        return ans;
    }
    private void fun(int[] arr, int idx, List<List<Integer>> ans, List<Integer> l){
        if(idx == arr.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        l.add(arr[idx]);
        fun(arr, idx+1, ans, l);
        l.remove(l.size()-1);
        // skip duplicate elements
        while(idx+1 < arr.length && arr[idx] == arr[idx+1]){
            idx++;
        }
        fun(arr, idx+1, ans, l);
    }
}