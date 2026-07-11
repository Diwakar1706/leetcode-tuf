class LRUCache {

    class Pair{
        int key;
        int value;
        Pair(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    int capacity;
    ArrayList<Pair>list;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        list=new ArrayList<>();
        
    }
    
    public int get(int key) {
        for(int i=0;i<list.size(); i++){
            if(list.get(i).key==key){
                Pair p=list.remove(i);
                list.add(p);
                return p.value;
            }
        }
        return -1;

    }
    public void put(int key, int value) {

        // Check if key already exists
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                list.remove(i);
                list.add(new Pair(key, value)); // Update and move to MRU
                return;
            }
        }

        // Cache full
        if (list.size() == capacity) {
            list.remove(0); // Remove LRU
        }

        list.add(new Pair(key, value));
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */