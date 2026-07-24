class Solution {
public:
    int merge(int start,int mid,int end,vector<int>&nums){
        vector<int>temp;
        int count=0;
        int l=start;
        int r=mid+1;
        for(int i=r;i<=end;i++){
            long long x=(long long)2*nums[i];
            int idx=upper_bound(nums.begin()+start,nums.begin()+mid+1,x)-nums.begin();
            if(idx<mid+1){
                count+=(mid-idx+1);
            }
        }
        while(l<=mid&&r<=end){
            if(nums[l]<nums[r]){
                temp.push_back(nums[l]);
                l++;
            }else{
                temp.push_back(nums[r]);
                r++;
            }
        }
        while(l<=mid){
            temp.push_back(nums[l]);
            l++;
        }
        while(r<=end){
            temp.push_back(nums[r]);
            r++;
        }
        for(int i=start;i<=end;i++){
            nums[i]=temp[i-start];
        }
        return count;
    }
    int mergeSort(int start,int end,vector<int>&nums){
        if(start>=end) return 0;
        int mid=start+(end-start)/2;
        int lcount=mergeSort(start,mid,nums);
        int rcount=mergeSort(mid+1,end,nums);
        int mcount=merge(start,mid,end,nums);

        return (long long)lcount+(long long)rcount+mcount;
    }
    int reversePairs(vector<int>& nums) {
        return mergeSort(0,nums.size()-1,nums);
    }
};