class Solution {
    public int mirrorDistance(int n) {
        int rev = 0;
        int n1 = n;
        while(n > 0){
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        System.out.print(rev);

        return Math.abs(n1 - rev);
    }
}