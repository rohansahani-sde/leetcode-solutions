class Solution {
    public int totalWaviness(int num1, int num2) {
        int c =0;
        for(int i= num1; i<=num2; i++){
            String s = Integer.toString(i);
            c += getWaviness(s); 
        }
        return c;
    }
    private int getWaviness(String s){
        int n= s.length();
        if(n < 3)return 0;
        int c=0;
        for(int i=1; i<n-1; i++){
            char curr = s.charAt(i);
            if(s.charAt(i-1) > curr && curr < s.charAt(i+1))c++;
            if(s.charAt(i-1) < curr && curr > s.charAt(i+1))c++;
        }
        return c;
    } 
}