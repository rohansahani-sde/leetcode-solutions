class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(s == null || n < k) return 0;
        int[] feq = new int[26];
        for(char c: s.toCharArray()) feq[c -'a']++;
        int i=0;
            while(i<n && feq[s.charAt(i) -'a'] >= k ){
                i++;
            }
            if(i >= n) return n;
            int left = longestSubstring(s.substring(0, i), k);
            while(i < n && feq[s.charAt(i)-'a'] < k ) i++;

            int right = (i< n) ? longestSubstring(s.substring( i), k) : 0;
            
            
        
            
        return Math.max(left, right);
        
    }
}