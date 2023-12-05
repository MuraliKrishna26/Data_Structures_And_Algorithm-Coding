/*
Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  

Input format :
The first and the only line of input contains an integer value, 'n'.

Output format :
Print the minimum number of steps.

Sample Input 1 :
4
Sample Output 1 :
2 
Explanation of Sample Output 1 :
For n = 4
Step 1 :  n = 4 / 2  = 2
Step 2 : n = 2 / 2  =  1 

Sample Input 2 :
7
Sample Output 2 :
3
Explanation of Sample Output 2 :
For n = 7
Step 1 :  n = 7 ­- 1 = 6
Step 2 : n = 6  / 3 = 2 
Step 3 : n = 2 / 2 = 1 

*/

public class Solution {


	//Recursion.
	public static int countMinStepsToOne(int n) {

	/*	
	Recursion : 

	f(n) = 1 + min(f(n-1), f(n/2), f(n/3)) ; n >= 4 
	      = 0 ; n = 1	
	      = 1 ; n = 2
		  = 1 ; n = 3
	*/

	if(n == 1){
		return 0;
	}
	if(n == 2 || n == 3){
		return 1;
	}

	int step1 = countMinStepsToOne(n-1);
	int step2 = Integer.MAX_VALUE;
	int step3 = Integer.MAX_VALUE;

	if(n%2 == 0){
		step2 = countMinStepsToOne(n/2);
	}
	if(n%3 == 0){
		step3 = countMinStepsToOne(n/3);
	}

	return 1 + Math.min(step1, Math.min(step2, step3));

	}

	//Top Down Approch
	public static int countMinStepsToOne_TD(int n) {
		//top down approch means recursion + memorization 

		int arr[] = new int[n+1];
		
		// a cell is not visited if it has max value;
		for(int i=0; i<n+1;i++){
			arr[i] = -1;
		}

		//filling the array in top down fasion and getting the result
		return countMinStepsToOne( n, arr);
		
	}

	public static int countMinStepsToOne_TD(int n, int[] arr){
		//recursion using an array to memorize

		//base_case
		if(n == 1){
			arr[n] = 0;
			return arr[n];
		}
		if(n == 2 || n ==3){
			arr[n] = 1;
			return arr[n];
		}

		//check visited or not. if visited then ignore.
		if(arr[n] != -1){
			return arr[n];
		}

		int step1 = countMinStepsToOne(n-1, arr);
		int step2 = Integer.MAX_VALUE;
		int step3 = Integer.MAX_VALUE;

		if(n%2 == 0){
			step2 = countMinStepsToOne(n/2, arr);
		}

		if(n%3 == 0){
			step3 = countMinStepsToOne(n/3, arr);
		}

		arr[n] = 1 + Math.min(step1, Math.min(step2,step3));
		return arr[n];
	}


	//Dynamic Programing
	public static int countMinStepsToOne_DP(int n) {
		//Your code goes here

		if(n == 1){
			return 0;
		}
		if(n == 2 || n == 3){
			return 1;
		}

		int arr[] = new int[n+1];
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;

		for(int i=4; i<n+1;i++){
			int step1 = arr[i-1];
			int step2 = Integer.MAX_VALUE;
			int step3 = Integer.MAX_VALUE;
			
			if(i%2 == 0){
				step2 = arr[i/2];
			}
			if(i%3 == 0){
				step3 = arr[i/3];
			}
			arr[i] = 1 + Math.min(step1, Math.min(step2, step3));
		}

		return arr[n];
	}

}
