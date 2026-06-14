class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(cand);
        fun(cand, 0, target, ans, new ArrayList<>());
        return ans;
    }
    private void fun(int[] arr, int idx, int k, List<List<Integer>> ans, List<Integer> curr){
        if(k==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(idx == arr.length || k<0){
            return;
        }
       
        curr.add(arr[idx]);
        fun(arr, idx+1, k-arr[idx], ans, curr);
        curr.remove(curr.size()-1);
        while (idx + 1 < arr.length && arr[idx] == arr[idx + 1]) {
            idx++;
        }

        fun(arr, idx+1, k, ans, curr);

    }
}