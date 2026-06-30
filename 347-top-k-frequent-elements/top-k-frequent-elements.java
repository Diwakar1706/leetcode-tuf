class Solution {
    class Pair{
        int ele;
        int freq;
        Pair(int ele,int freq){
            this.ele=ele;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>(
            (a,b)->{
                if(a.freq==b.freq) return a.ele-b.ele;
                return a.freq-b.freq;

            }
        );
        for(int ele:map.keySet()){
            int freq=map.get(ele);
            pq.add(new Pair(ele,freq));
            if(pq.size()>k) pq.remove();   
        }
        int [] ans=new int[k];
        for(int i=0; i<k; i++){
            Pair x=pq.remove();
            ans[i]=x.ele;
        }
        Arrays.sort(ans);
        return ans;

        
    }
}