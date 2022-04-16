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
  
 /* 5-) You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively. 
        Merge nums1 and nums2 into a single array sorted in non-decreasing order.
        The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
        To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.*/  
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int i = m+n-1;
        
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            }
            else {
                nums1[i--] = nums2[p2--];
            }
        }
    }
  
 // 6-) Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
    public boolean checkIfExist(int[] arr) {
        int p1 = 0;
        int p2 = arr.length - 1;
        boolean found = false;
        while (p1 < p2){
            if (((arr[p1] == arr[p2] / 2)  && arr[p2] % 2 == 0 ) || arr[p1] == 2 * arr[p2]) {
                found = true;
                break;
            }
            if (p2 == p1 + 1) {
                p1 ++;
                p2 = arr.length - 1;
            }
            else{
             p2--;       
            }
        }
        return found;
    }
  
 // 7-) Given an array of integers arr, return true if and only if it is a valid mountain array.
    public boolean validMountainArray(int[] arr) {
        boolean validMountain = true;
        boolean maxReached = false;
        boolean minReached = false;
        if (arr.length >= 3) { 
            for (int i = 0; i < arr.length - 1; i ++) {
                if (arr[i+1] == arr[i]) {
                    validMountain = false;
                }
                else if (arr[i+1] > arr[i]) {
                    maxReached = true;
                    if (minReached) {
                        validMountain = false;
                    }
                }
                else if (arr[i+1] < arr[i]) {
                    minReached = true;
                    if (!maxReached) {
                        validMountain = false;
                    }
                }
            }
        }
        else {
            return false;
        }
        return validMountain && maxReached && minReached;
    }
  
 // 8-) Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
    public int[] replaceElements(int[] arr) {
        int last = arr.length - 1;
        int max = arr[last];
        for (int i = last; i > 0; i --){
            int temp = arr[i-1];
            arr[i-1] = max;
            if (temp >= max){
                max = temp;  
            }
        }
        arr[last] = -1;
        return arr;
    }

 // 9-)  Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = 0;
        
        while(i < nums.length){
            if (nums[i] % 2 == 0) {
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i++] = temp;
            }
            else {
                i++;
            }
        }
        return nums;
    }

}
