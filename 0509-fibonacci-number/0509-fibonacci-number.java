class Solution {
    // recursion
    public int fib(int n) {
        return rec(n);
    }
    int rec(int n){
        // base cond.
        if(n==0 || n==1){
            return n;
        }

        // main logic

        return rec(n-1) + rec(n-2);
    }
}