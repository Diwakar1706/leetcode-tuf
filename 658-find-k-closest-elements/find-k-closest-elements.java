class Solution {
    class Pair implements Comparable<Pair>{
        int ele;
        int diff;
        Pair(int ele,int diff){
            this.ele=ele;
            this.diff=diff;
        }
        public int compareTo(Pair p){
            if(this.diff==p.diff) return this.ele-p.ele;
            return this.diff-p.diff;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int val:arr){
            int diff=Math.abs(x-val);
            pq.add(new Pair(val,diff));
            if(pq.size()>k) pq.poll();
        }
        List<Integer> ans=new ArrayList();
        while(pq.size()>0){
            Pair p=pq.poll();
            ans.add(p.ele);
        }
        Collections.sort(ans);
        return ans;
        
    }
}
