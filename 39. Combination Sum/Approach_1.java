class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(cand, 0,target, ans, new ArrayList<>());
        return ans;
    }
    private void fun(int[] arr,int idx, int target, List<List<Integer>> ans, List<Integer> l){
        
        if(target == 0){
            ans.add(new ArrayList<>(l));
            return;
        }
        if(idx >= arr.length || target  < 0){
          return;
        }
        
        l.add(arr[idx]);
        fun(arr, idx, target-arr[idx], ans, l);
        l.remove(l.size()-1);
        fun(arr, idx+1, target, ans, l);
    }
}