class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(1, k, n, ans, new ArrayList<>());
        return ans;
    }
    private void fun(int i, int k, int n, List<List<Integer>> ans, List<Integer> l){
        if(n ==0 && l.size() == k){
            ans.add(new ArrayList<>(l));
            return;
        }
        if(i > 9 || n < 0 || l.size() > k)return;

        l.add(i);
        fun(i+1, k, n-i, ans, l );
        l.remove(l.size()-1);
        fun(i+1, k, n, ans, l );
    }
}