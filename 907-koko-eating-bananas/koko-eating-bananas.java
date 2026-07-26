class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int low = 1;
        int high = max(piles);
 

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = totalhour(piles, mid);

            if (hours <= h) {
          
                high = mid - 1;   // try smaller speed
            } else {
                low = mid + 1;    // need faster speed
            }
        }

        return low;
    
        
        
    }
    static int max(int[] arr){
        int maxvalue=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>maxvalue){
                maxvalue=arr[i];
            }
        }
        return maxvalue;
    }
    static long totalhour(int[] piles, int speed){
        long hour=0;
        for(int bannana:piles){
           hour += (bannana + speed - 1L) / speed;
        }
        return hour;
    }
}