class Solution {
    public int findWinningPlayer(int[] arr, int k) {
        int n = arr.length;
        int winIdx =0;
        int win =0;
        for(int i=1; i<n; i++){
            if(arr[winIdx] > arr[i]) win++;
            else {
                winIdx = i;
                win=1;
            }
            if(win ==k) return winIdx;
        }
        return winIdx;
    }
}