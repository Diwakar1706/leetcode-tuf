class Solution {
    static class triplet implements Comparable<triplet>{
        int x;
        int y;
        int d2;
        triplet(int x,int y,int d2){
            this.x=x;
            this.y=y;
            this.d2=d2;
        }
        public int compareTo(triplet t){
           return this.d2 -t.d2;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        PriorityQueue<triplet> pq=new PriorityQueue<>(Collections.reverseOrder());
       
        for(int i=0; i<n; i++){
            int x=points[i][0]; 
            int y=points[i][1];
            int d2=x*x+y*y;
            pq.add(new triplet(x,y,d2));  
            if(pq.size()>k) pq.remove();
        }
        int[][]  ans=new int[k][2];
        for(int i=0; i<k; i++){
            triplet t=pq.remove();
            ans[i][0]=t.x;
            ans[i][1]=t.y;

        }
        return ans;
        
    }
}