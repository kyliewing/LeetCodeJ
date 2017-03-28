public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        result[0]=searchLeft(nums, target);
        result[1]=searchRight(nums, target);
        return result;
    }
    public int searchLeft(int[] nums, int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target && (mid==0 || nums[mid-1]<nums[mid])){
                return mid;
            }else if(nums[mid]==target && nums[mid-1]==nums[mid]){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    public int searchRight(int[] nums, int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target && (mid==nums.length-1 || nums[mid+1]>nums[mid])){
                return mid;
            }else if(nums[mid]==target && nums[mid+1]==nums[mid]){
                left=mid+1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    
}