class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        fun(nums, 0, ans, set, new ArrayList<>());
        return ans;
    }
    private void fun(int[] arr, int idx, List<List<Integer>> ans, Set<List<Integer>> set, List<Integer> l){
        if(idx == arr.length){
            if(!set.contains(l)){
                set.add(l);
                ans.add(new ArrayList<>(l));
            }
            return;
        }
        l.add(arr[idx]);
        fun(arr, idx+1, ans, set, l);
        l.remove(l.size()-1);
        fun(arr, idx+1, ans, set, l);
    }
}