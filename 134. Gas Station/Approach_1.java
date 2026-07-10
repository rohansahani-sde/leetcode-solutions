class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas =0, totalCost =0;
        int n = gas.length;
        int idx=0;
        int currGas =0;
        for(int i=0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];

            currGas += (gas[i] - cost[i]);
            if(currGas < 0){
                idx = i+1;
                currGas=0;
            }
        }
        if(totalCost > totalGas) return -1;
        return idx;
    }
}