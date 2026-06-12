class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, 0, ans, new HashSet<>(), new ArrayList<>());
        return ans;
    }
    private void fun(int[] arr, int idx, List<List<Integer>> ans, Set<List<Integer>> set , List<Integer> curr){
        if(idx == arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        fun(arr, idx+1, ans, set, curr);
        curr.add(arr[idx]);
        fun(arr, idx+1, ans, set, curr);
        curr.remove(curr.size()-1);
    }
}