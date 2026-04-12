class Solution {
    // in this question we have range of our result from 1 to 10^7 so for finding the result we do binary search in range 
    // logic is approx same as 875. Koko Eating Bananas
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = (int) 1e7;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(canReach(dist, hour, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canReach(int[] dist, double hour, int speed){
        double time = 0;

        for(int i=0;i<dist.length;i++){
            double t = (double) dist[i]/speed;

            if(i != dist.length - 1){
                time += Math.ceil(t);
            }
            else{
                time += t;
            }
        }

        return time <= hour;
    }
}