class Solution {
    public int subsetXORSum(int[] nums) {
        return getXorSum(0, nums, 0, 0);
    }
    private int getXorSum(int idx, int[] arr, int sum, int xor){
        if(idx == arr.length){
            sum += xor;
            return sum;
        }
        return getXorSum(idx+1, arr, sum, xor^arr[idx]) + getXorSum(idx+1, arr, sum, xor);
    }
}