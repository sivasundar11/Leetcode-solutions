import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(nums, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);
            
            if (bitA == bitB) {
                return a - b;   
            }
            return bitA - bitB;  
        });
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        
        return arr;
    }
}