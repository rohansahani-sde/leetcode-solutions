class Solution {
    public long countPairs(int[] nums, int k) {
        long count =0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x: nums){
            int gcdRes = gcd(k, x);
            int need = k / gcdRes;
            for(int key: map.keySet()){
                if(key % need ==0){
                    count += map.get(key);
                }
            }
            map.put(gcdRes, map.getOrDefault(gcdRes, 0)+1);
        }
        return count;
        
    }
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}