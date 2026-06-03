class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        int n = ls.length;
        int m = ws.length;

        int ml = Integer.MAX_VALUE;
        int mw = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            ml = Math.min(ml, ls[i]+ld[i] );
        }

        for(int j=0; j<m; j++){
            mw = Math.min(mw, ws[j]+wd[j]);
        }
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int st = Math.max(ls[i], mw);
            ans = Math.min(ans, st+ld[i]);
        }
        for(int j=0; j<m; j++){
            int st = Math.max(ws[j], ml);
            ans = Math.min(ans, st+wd[j]);
        }
        
        return ans;
    }
}