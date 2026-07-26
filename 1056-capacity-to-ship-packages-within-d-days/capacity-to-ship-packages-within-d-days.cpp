class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        int sum=0;
        for(int weight:weights){
            sum+=weight;
        }
        int maxi=*max_element(weights.begin(),weights.end());
        int left=maxi;
        int right=sum;
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            int weight=0;
            int time=1;
            for(int i=0;i<weights.size();i++){
                weight +=weights[i];
                if(weight>mid){
                    weight=weights[i];
                    time++;
                }
            }
            if(time<=days){
               ans=mid;
               right=mid-1;
            }
            else left=mid+1;
        }
        return ans;

    }
};