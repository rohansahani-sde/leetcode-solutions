class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map =new HashMap<>();
        int n = words.length;
        for(int i=0; i<n; i++){
            map.put(words[i], i);
        }
        if(map.containsKey("")){
            int idx = map.get("");
            for(int i=0; i<n; i++){
                if(i == idx) continue;
                if(isPalindrome(words[i])){
                    ans.add(Arrays.asList(idx, i));
                    ans.add(Arrays.asList(i, idx));
                }
            }
        }
        for(int i=0; i<n; i++){
            String rev = reverse(words[i]);
            if(map.containsKey(rev)){
                int idx = map.get(rev);
                if(idx == i) continue;
                ans.add(Arrays.asList(i, idx));
            }
        }

        for(int i=0; i<n; i++){
            String str = words[i];
            for(int j=1; j<str.length(); j++){
                String left = str.substring(0, j);
                String right = str.substring(j);
                if(isPalindrome(left)){
                    String revRight = reverse(right);
                    if(map.containsKey(revRight)){
                        int idx = map.get(revRight);
                        if(idx == i)continue;
                        ans.add(Arrays.asList( idx , i ));
                    }
                }
                if(isPalindrome(right)){
                    String revLeft = reverse(left);
                    if(map.containsKey(revLeft)){
                        int idx = map.get(revLeft);
                        if(idx == i)continue;
                        ans.add(Arrays.asList( i, idx ));

                    }
                }
            }
        }
        
        return ans;
        
    }
    private String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    private boolean isPalindrome(String s){
        int n = s.length();
        int i=0, j=n-1;
        while( i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}