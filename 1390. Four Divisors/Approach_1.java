class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans= 0;
        for(int x: nums){
            int c=0;
            int sum =0;
            for(int i=1; i*i <= x; i++){
                if(x % i ==0){
                    sum += i;
                    c++;
                    if(i != x/i){
                        sum += x/i;
                        c++;
                    }
                }
                if(c > 4)break;
            }
            if(c == 4) ans += sum;
        }
        
        return ans;
    }
}