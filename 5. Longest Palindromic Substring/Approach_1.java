class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int startIdx =0;
        int maxLen = 0;
        for(int i=0; i<n; i++){
            int p1 =i, p2=i;
            while(p1 >=0 && p2 <n && s.charAt(p1) == s.charAt(p2) ){
                if(maxLen < p2 - p1+1){
                    maxLen = p2 - p1+1;
                    startIdx = p1;
                }
                p1--;
                p2++;
            }
            p1 =i; p2=i+1;
            while(p1 >=0 && p2 <n && s.charAt(p1) == s.charAt(p2) ){
                if(maxLen < p2 - p1+1){
                    maxLen = p2 - p1+1;
                    startIdx = p1;
                }
                p1--;
                p2++;
            }

        }
        return s.substring(startIdx, maxLen + startIdx);
        
    }
}