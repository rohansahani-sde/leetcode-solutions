class Solution {
    public double myPow(double x, int n) {
        
        if(n < 0){
            double half = getPow(x, Math.abs(n/2));
            if(Math.abs(n) % 2 ==0){
                return 1/(half*half);
            }else return 1/(x *(half*half));
        }
        double val = 
        getPow(x, n/2);
            if(n % 2 ==0){
                return val*val;
            }else return x *(val*val);
        
    }
    private double getPow(double x, int n){
        if(n ==0) return 1;
        double half = getPow(x, n/2);
        if(n%2 ==0){
            return half*half;
        }
        return x*half*half;
        
    }
}