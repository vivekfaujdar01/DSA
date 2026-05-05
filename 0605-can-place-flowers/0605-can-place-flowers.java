class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;

        for (int i = 0; i < size; i++) {

            if (flowerbed[i] == 0) {
                boolean plant = true;
                if (i - 1 >= 0 && flowerbed[i - 1] == 1) {
                    plant = false;
                }
                if (i + 1 < size && flowerbed[i + 1] == 1) {
                    plant = false;
                }

                if (plant) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            
        }

        return n <= 0;
    }
}