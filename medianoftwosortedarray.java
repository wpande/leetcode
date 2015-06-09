public class Solution {
    public double findkth(int[] nums1,int[] nums2,int k){//k start from 1
        int len1=nums1.length;
        int len2=nums2.length;
        if(len1>len2)
            return findkth(nums2,nums1,k);
        if(len1==0)
            return nums2[k-1];
        if(k==1)
            return Math.min(nums1[0],nums2[0]);
        int l1=Math.min(nums1.length,k/2);
        int l2=k-k/2;
        if(nums1[l1-1]==nums2[l2-1])
            return nums1[l1-1];
        else if(nums1[l1-1]>nums2[l2-1]){
            int []nums2p=new int[nums2.length-l2];
            System.arraycopy(nums2,l2,nums2p,0,nums2.length-l2);
            return findkth(nums1,nums2p,k-l2);
        }
        else{
            int []nums1p=new int[nums1.length-l1];
            System.arraycopy(nums1,l1,nums1p,0,nums1.length-l1);
            return findkth(nums1p,nums2,k-l1);
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        if((len1+len2)%2==1){
            return findkth(nums1,nums2,(len1+len2)/2+1);
        }
        else{
            return (findkth(nums1,nums2,(len1+len2)/2)+findkth(nums1,nums2,(len1+len2)/2+1))/2;
        }
    }
}