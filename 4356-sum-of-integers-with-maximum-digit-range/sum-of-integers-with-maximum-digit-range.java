class Solution {
    public int maxDigitRange(int[] nums) {
        int maxdigit=0;
        for(int ele:nums){
            maxdigit=Math.max(maxdigit,maxRange(ele));

        }
        int sum=0;
        for(int ele:nums){
            if(maxRange(ele)==maxdigit){
                sum+=ele;
            }
        }
        return sum;


        
        
    }
    int maxRange(int num){
        int min=9;
        int max=0;
        while(num>0){
            int d=num%10;
            min=Math.min(min,d);
            max=Math.max(max,d);
            num=num/10;
        }
        return max-min;

    }
}