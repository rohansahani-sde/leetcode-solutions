class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map  =new HashMap<>();
        int j=0;
        int maxLen=0;
        int max = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            max =Math.max(max, map.get(ch) );
            int diff = (i-j+1) -  max;
            if(diff <= k){
                maxLen = Math.max(maxLen, i-j+1); 
            }else{
                char left = s.charAt(j);
                map.put(left, map.get(left)-1);
                if(map.get(left) ==0) map.remove(left);
                j++;
            }
        }
        return maxLen;

    }
}