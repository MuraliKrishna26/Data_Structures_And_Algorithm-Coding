/*
Leetcode Question : 300
Given an integer array nums, return the length of the longest strictly increasing subsequence.

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

*/

/*
Intution: Lets take an array and fill the array from buttom-up with the help of the previously comuted values. 

Given an array     :  0,1,2,3,.......i..........,n. 
and computed array :  [.............]

i'th element can be added to the already computed longest sequence at the end, if it it satisfies the condition that sequence must be increasing i.e arr[0..i-1] < arr[i].  

    computed_array(i) = 1 + max( computed_array[0..i-1]) ; if arr[0..i-1] < arr[i]
                      = 1                                ;   if the above case does not get satisfy.

Final Answer will be max(computed_array)
*/


class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int arr[] = new int[nums.length];
        arr[0] = 1;   //basecase

        int returnans = 1;
        //filling the array
        for(int i = 1 ; i<nums.length ; i++){
            
            int getmaxcount = Integer.MIN_VALUE;    
            for(int j = 0; j<i; j++){
                if(nums[j]>=nums[i]){
                    continue;
                }

                if(getmaxcount <= arr[j]){
                    getmaxcount = arr[j];
                }
            }
            
            if(getmaxcount == Integer.MIN_VALUE){
                arr[i] = 1;
            }else{
                arr[i] = getmaxcount + 1;
                if(returnans < arr[i]){
                    returnans = arr[i];
                }
            }

        }
        
        return returnans;
    }
}


/*
Worst case : Take all the subsequences and find if it is increasing or not. If increasing then take its count. 
             For computing all the subsequence - 2^n
             For checking the subsequence is increasing or not - n
             Time Complexity = O(2^n + n) = O(2^n).


Best Case : As we have seen above, for every element at "i" we are traversing the array from 0 to "i-1".
            Time complexity = O(n*(n-1) + n) = O(n)
            Space complexity = O(n) 
*/
