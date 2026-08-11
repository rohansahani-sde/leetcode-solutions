class Solution {
    static long MOD = 1000000007;
    long[][] table;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        table = new long[n][];
        pascal(n);
        List<Integer> l = new ArrayList<>();
        for(int x: nums) l.add(x);
        

        return (int)(fun(l) - 1) % (int)MOD;

    }
    private int fun(List<Integer> nums){
        int n = nums.size();
        if(n <= 2) return 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = nums.get(0);
        for(int i=1; i<n; i++){
            if(nums.get(i) < root) left.add(nums.get(i));
            else right.add(nums.get(i));
        }
        long leftans = fun(left) % MOD;
        long rightans = fun(right) % MOD;

        return (int) (((leftans*rightans)%MOD * (table[n-1][left.size()])) %MOD);




    }
    private void pascal(int n){
        for(int i=0; i<n; i++){
            table[i] = new long[i+1];
            for(int j=0; j<=i; j++){
                if(j == 0 || j == i){
                    table[i][j] = 1;
                }else{
                    table[i][j] = (table[i-1][j-1] + table[i-1][j]) % MOD;
                }
            }
        }
    }
}