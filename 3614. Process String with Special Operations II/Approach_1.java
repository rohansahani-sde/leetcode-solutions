class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n+1];
        char ch;
        for(int i=0; i<n; i++){
            ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                len[i+1] = len[i] +1;
            }
            else if(ch == '*'){
                len[i+1] = Math.max(0, len[i]-1);
            }
            else if(ch =='#'){
                len[i+1] = len[i]*2;
            }
            else{
                len[i+1] = len[i];
            }
        }
        if (k < 0 || k >= len[n]) {
            return '.';
        }

        StringBuilder sb = new StringBuilder();
        for(int i=n-1; i>=0; i--){
            ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                if(k == len[i])return ch;
            }
            else if(ch == '*'){
                if (len[i] > 0 && k == len[i] - 1) {
                    return '.';
                }
            }
            else if(ch =='#'){
                long prevLen = len[i];
                if (k >= prevLen) {
                    k -= prevLen;
                }
            }
            else{
                k = len[i] - 1 - k;
            }
            
            
        }
        return '.';
    }
}