class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return gcd(min, max);
    }

    int gcd(int x, int y){
        if(x == 0){
            return y;
        }
        if(y == 0){
            return x;
        }
        return gcd(y,x % y);
    }
}