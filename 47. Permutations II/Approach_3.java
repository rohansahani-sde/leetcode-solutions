class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n= nums.length;
        boolean[] vis = new boolean[n];
        fun(nums, ans, new ArrayList<>(), vis);
        return ans;
    }
    private void fun(int[] arr, List<List<Integer>> ans, List<Integer> l, boolean[] vis){
        if(l.size()  == arr.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<arr.length; i++){
            if(i>0 && arr[i] == arr[i-1] && !vis[i-1])continue;
            if(!vis[i]){
                l.add(arr[i]);
                vis[i] = true;
                fun(arr, ans, l, vis);
                l.remove(l.size()-1);
                vis[i] = false;
            }
        }
    }
}