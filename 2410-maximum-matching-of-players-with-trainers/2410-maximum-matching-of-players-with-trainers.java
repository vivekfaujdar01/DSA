class Solution {
    // this is same as 455. Assign Cookies
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int playerIndex = players.length-1;
        int trainerIndex = trainers.length-1;
        int res = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while(playerIndex >=0 && trainerIndex >= 0){
            if(players[playerIndex] <= trainers[trainerIndex]){
                res++;
                trainerIndex--;
            }
            playerIndex--;
        }

        return res;
    }
}