class Solution {
    public boolean check_K(int k, int[] piles, int h) {
        int hourToEat = 0;
        for (int i = piles.length - 1; i >= 0; i--) {
            hourToEat += (piles[i] + k - 1) / k;
            // System.out.println("K: " + k + " hourToEat: " + hourToEat);
            if (hourToEat > h)
                return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int end = -1;
        int start = 1;
        int ans = 0;
        for(int num:piles){
            end = Math.max(end, num);
        }
        while (start <= end) {
            int k = start + (end - start) / 2;
            // System.out.println("START: "+start+" END: "+end+" MID: "+k);
            if (check_K(k, piles, h)) {
                ans = k;
                end = k-1;
            } else {
                start = k + 1;
            }
        }
        return ans;
    }
}
