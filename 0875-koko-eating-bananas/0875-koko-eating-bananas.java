class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int left = 1;
        int right = piles[piles.length-1];
        
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canEatInTime(piles, mid, h)){
                right = mid - 1;
            } 
            else{
                left = mid + 1;
            } 
        }
        return left;
    }
    public boolean canEatInTime(int piles[], int speed, int h){
        long hours = 0;
        for(int pile : piles){
            int time = pile / speed;
            hours += time;
            if(pile % speed != 0) hours++;
        }
        return hours <= h;
    }
}