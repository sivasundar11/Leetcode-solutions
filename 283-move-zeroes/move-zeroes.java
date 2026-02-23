class Solution {
    public void moveZeroes(int[] nums) {
        int [] dummy = new int [nums.length];
       
        int j=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                dummy[j]=nums[i];
                j++;
            }
        }
           while(j<dummy.length){
                dummy[j]=0;
                j++;
            }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = dummy[i];
        }
        
      
    } 
}