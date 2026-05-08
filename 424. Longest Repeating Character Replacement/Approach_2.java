class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] arr = new int[26];
        int j=0;
        int maxLen=0;
        int max = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            arr[ch-'A']++;
            max =Math.max(max, arr[ch - 'A'] );
            int diff = (i-j+1) -  max;
            if(diff <= k){
                maxLen = Math.max(maxLen, i-j+1); 
            }else{
                char left = s.charAt(j);
                arr[left-'A']--;
                j++;
            }
        }
        return maxLen;

    }
}