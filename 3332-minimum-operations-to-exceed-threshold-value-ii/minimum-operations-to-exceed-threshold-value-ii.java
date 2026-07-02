class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add((long)nums[i]);

        }
        while(pq.size()>=2){
            long x=pq.remove();
            long y=pq.remove();
            if(x<k){
                long newval =(((long)Math.min(x,y)*2+Math.max(x,y)));
                pq.add(newval);
                count++;
            }
        }
        return count;


        
    }
}