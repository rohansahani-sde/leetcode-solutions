class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;

        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int startLand = landStartTime[i];
                int endLand = startLand + landDuration[i];
                
                int startWater =Math.max(endLand, waterStartTime[j]);
                int endWater = startWater + waterDuration[j];

                min = Math.min(min, endWater);

                startWater = waterStartTime[j];
                endWater = startWater + waterDuration[j];

                startLand = Math.max(endWater, landStartTime[i]);
                endLand = startLand + landDuration[i];

                min = Math.min(min , endLand);
                
            }
        }
        return min;
    }
}