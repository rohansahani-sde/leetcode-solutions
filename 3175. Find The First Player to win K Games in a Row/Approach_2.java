class Solution {
    public int findWinningPlayer(int[] arr, int k) {
        Map<Integer, int[]> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            set.add(arr[i]);
            map.putIfAbsent(arr[i], new int[]{1, i});
            if(set.size() == 2){
                int max = set.last();
                int[] curr = map.get(max);
                System.out.println(max+" "+curr[0] +" "+curr[1]);
                map.put(max, new int[]{curr[0]+1, curr[1]});
                if(curr[0] == k) return map.get(max)[1];
                set.pollFirst(); 
            }
        }
        return map.get(set.last())[1];
        
    }
}