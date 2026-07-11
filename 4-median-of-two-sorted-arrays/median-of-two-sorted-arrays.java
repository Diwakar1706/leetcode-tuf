class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged=sortedArrays(nums1,nums2);
        int n=merged.length;
        if(n%2==1) return merged[n/2];
        else return (merged[n/2]+merged[n/2-1])/2.0;
 

        
    }

    static int[] sortedArrays(int[] nums1,int[] nums2){
        int n=nums1.length;
        int m=nums2.length;
        int[] ans=new int[n+m];

        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m){
            if(nums1[i]>=nums2[j]){
                ans[k++]=nums2[j++];
            }else{
                ans[k++]=nums1[i++];
            }
        }
        while(i<n){
            ans[k++]=nums1[i++];
        }
        while(j<m){
            ans[k++]=nums2[j++];
        }
        return ans;


    }
}