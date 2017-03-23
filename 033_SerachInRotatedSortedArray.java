public class Solution {
    public int search(int[] nums, int target) {
        int nums_length=nums.length;  //notice "nums.lenght"
        if (nums_length<=0) return -1;
        int left=0, right=nums_length-1, mid;
        while(left<=right){
            mid=(left+right)/2;
            if (nums[mid]==target) return mid;
            else if (nums[mid]<nums[left]){
                if(nums[mid]<=target && target<=nums[right]) left=mid+1; //notice &&
                else right=mid-1;
            }
            else{
                if(nums[left]<=target && target<=nums[mid]) right=mid-1;
                else left=mid+1;
            }
        }
        return -1;
    }
}