class Solution {
    public int maxPoints(int[][] arr) {
        int max = 1;
        int n = arr.length;
        if(n == 1)  return 1;
        for(int i=0; i<n; i++){
            Map<Double, Integer>  map = new HashMap<>();
            for(int j=0; j <n; j++){
                if(i == j) continue;
                double slop;
                if(arr[j][0] - arr[i][0] != 0) {
                    slop = (arr[j][1] - arr[i][1] ) * 1.0 / (arr[j][0] - arr[i][0]);
                }
                else slop = Integer.MAX_VALUE;
                map.put(slop, map.getOrDefault(slop, 0)+1);
                max = Math.max(max, map.get(slop));

            }

        }
        return max+1;
    }
}