class Solution {
    public List<List<String>> partition(String s) {
         List<List<String>> ans = new ArrayList<>();
         fun(s, 0,0, ans, new ArrayList<>());
         return ans;
    }
    private void fun(String s, int idx, int j, List<List<String>> ans, List<String> l){
        if(j == s.length()){
            if(idx == s.length()){
                ans.add(new ArrayList<>(l));
            }
           
            return;
        }
        String sub = s.substring(idx, j+1);
        if(isPalindrome(sub)){
            l.add(sub);
            fun(s, j+1,  j+1, ans, l);
            l.remove(l.size()-1);
        }
        fun(s, idx, j+1,ans, l);
    }
    private boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
}