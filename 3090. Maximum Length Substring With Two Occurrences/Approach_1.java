class Solution {
    public int maximumLengthSubstring(String s) {
        int[] arr = new int[26];
        int j =0, i=0;
        int max = 0;
        for(char ch: s.toCharArray()){
            arr[ch-'a']++;
            while(arr[ch-'a'] > 2){
                char left = s.charAt(j++);
                arr[left-'a']--;
            }
            max = Math.max(max, i-j+1);
            i++;

        }
        return max;
    }
}