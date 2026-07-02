class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n=asteroids.length;
        long currmass=mass;
        Arrays.sort(asteroids); 
        for(int i=0; i<n; i++ ){
            if(currmass<asteroids[i]) {
                return false;
            }
            currmass+=asteroids[i];       
        }
        return true;

        
    }
}