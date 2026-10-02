class Solution {
    public int[] vowelStrings(String[] words, int[][] que) {
        int n= words.length;
        int[] arr = new int[n];
        int idx =0;
        int prev = 0;
        for(String s: words){
            
            int len = s.length();
            if(isVowel( s.charAt(0) ) && isVowel(s.charAt(len-1))){
                arr[idx++] = prev + 1;
                prev++; 
            }
            else arr[idx++] = prev;

        }
        int[] ans = new int[que.length];
        idx=0;
        for(int[] q: que){
            int s = q[0];
            int e = q[1];
            if(s == 0){
                ans[idx++] = arr[e];
            }
            else{
                ans[idx++] = arr[e] - arr[s-1];
            }
        }
        return ans;

        
    }
    private boolean isVowel(char ch){
        return ch =='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}
