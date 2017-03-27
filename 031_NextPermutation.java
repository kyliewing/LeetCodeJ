public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1) return;
        int i,j;
        int last=nums.length-1;
        for(i=last;i>=1;i--){  //find the first element who is less than the later element 
            if(nums[i-1]<nums[i]) break;
        }
        if(i==0){  //if it's descending order, reverse the whole string
            reverse(nums,0);
        }
        else{   
            int swap_number;
            for (swap_number=nums.length-1;swap_number>=i;swap_number--){  //from end to i, find the first one that is larger than nums[i-1]
                if(nums[swap_number]>nums[i-1]) break;
            }
            int temp=nums[swap_number];  //swap the first one larger than nums[i-1] and nums[i-1]
            nums[swap_number]=nums[i-1];
            nums[i-1]=temp;
            
            reverse(nums,i); //then from i to end, it's descending order, so reverse from i to end
        }
    }
    public void reverse(int[] nums, int i){
        int left=i,right=nums.length-1;
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}