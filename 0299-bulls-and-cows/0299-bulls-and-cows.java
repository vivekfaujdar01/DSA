class Solution {
    public String getHint(String secret, String guess) {

        int bulls = 0;
        int cows = 0;

        int[] secretFreq = new int[10];
        int[] guessFreq = new int[10];

        for (int i = 0; i < secret.length(); i++) {

            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                secretFreq[s - '0']++;
                guessFreq[g - '0']++;
            }
        }

        for (int d = 0; d < 10; d++) {
            cows += Math.min(secretFreq[d], guessFreq[d]);
        }

        return bulls + "A" + cows + "B";
    }
}