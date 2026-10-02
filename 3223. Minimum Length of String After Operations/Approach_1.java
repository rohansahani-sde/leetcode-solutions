class Solution {
    public int minimumLength(String s) {
        int n= s.length();
        if( n < 3) return n;
        int[] arr = new int[26];
        for(char ch: s.toCharArray()){
            arr[ch -'a']++; 
        }
        int c =0;
        for(int x: arr){
            if(x != 0) c += x%2 ==0 ? 2 : 1;
        }
        return c;
        
    }
}