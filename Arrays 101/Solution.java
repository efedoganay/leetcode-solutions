class Solution {
  
 // 1-) Given a binary array nums, return the maximum number of consecutive 1's in the array.
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxConsecutive = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                count += 1;
                if (count > maxConsecutive) {
                    maxConsecutive = count;
                }
            }
            else {
                count = 0;
            }
        }
        return maxConsecutive;
    }
  
 // 2-) Given an array nums of integers, return how many of them contain an even number of digits.
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i ++){
            for (int j = 1; j <= 5; j=j+2){
                if ((nums[i] >= Math.pow(10, j)) && (nums[i] < Math.pow(10, j+1))){
                    count += 1;
                }
            }
        }
        return count;
    }
  
 // 3-) Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order. 
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int res [] = new int[n];
        int l = 0;
        int index = n - 1;
        int h = n - 1;
        while (l <= h){
            if (Math.abs(nums[l]) < Math.abs(nums[h])){
                res[index--] = nums[h] * nums[h];
                h--;
            }
            else{
                res[index--] = nums[l] * nums[l];
                l++;
            }
        }
        return res;
    }
  
 // 4-) Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right. 
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i+1; j --) {
                    arr[j] = arr[j-1];
                }
                arr[i+1] = 0;
                i++;
            }
        }
    }

}
