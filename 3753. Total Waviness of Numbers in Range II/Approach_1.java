class Solution {
    private static int[] waves = new int[570];
    static{
        int j=0;
        for(int i=0; i<1000; i++){
            int r =i%10;
            int mid = (i/10)%10;
            int l = (i/100)%10;
            if(mid > Math.max(l, r) || mid < Math.min(l,r)){
                waves[j++] =i;
            }
        }
    }
    public long totalWaviness(long num1, long num2) {
        return wavesCount(num2) - wavesCount(num1-1);
    }
    private long wavesCount(long num){
        if(num < 100)return 0;
        long ans= 0;
        for(int x: waves){
            ans += countWays(num, x);
        }
        return ans;
    }
    private long countWays(long num, int p){
        long type = p < 100 ? 1:0;
        long ways =0;
        long mult =1;
        for(int i=0; i<16; i++){
            if(mult*100 > num) break;
            long pre = num/(mult*1000);
            long curr = (num/mult)%1000;
            long suf = num% mult;
            
            long count =0, edge=0;
            if(curr > p){
                count = pre - type+1;
            }else if(curr == p){
                count = Math.max(0L, pre-type);
                if(pre >= type){
                    edge = suf+1;
                }
            }else{
                count = Math.max(0L, pre- type);
            }
            ways += count * mult+edge;
            mult *= 10;
        }
        return ways;
    }
}