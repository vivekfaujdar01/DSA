class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for(int candy : candies){
            maxCandy = Math.max(maxCandy, candy);
        }

        List<Boolean> res = new ArrayList<>();

        for(int candy : candies){
            if(candy + extraCandies >= maxCandy){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }

        return res;
    }
}