class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(m<n) return "";
        int reqCount=n;
        int i=0;
        int j=0;
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int start_i=0;

        int minWindowSize=Integer.MAX_VALUE;
        while(j<m){
            char ch=s.charAt(j);
            if(map.containsKey(ch) && map.get(ch)>0){
                reqCount--;
            }
            map.put(ch,map.getOrDefault(ch,0)-1);
            while(reqCount==0){
                int currWindow=j-i+1;
                if(minWindowSize>currWindow){
                    minWindowSize=currWindow;
                    start_i=i;
                }
                char startChar=s.charAt(i);
                map.put(startChar,map.getOrDefault(startChar,0)+1);
                if(map.containsKey(startChar) && map.get(startChar)>0){
                    reqCount++;
                }
                i++;

            }
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);     
    }
}