public class Fibonacci{
	
	/*
	Recursive.
     fib(n)  = fib(n-1) + fib(n-2) ; n>=2
	         = n                   ; n = 0 or n = 1
    */

	public static int fib(int n){
		// base case
		if(n == 0 || n == 1){
			return n;
		}
		// recursive function
		return fib(n-1) + fib(n-2);
	}

	/*
	 Memorization - Take an array and store the values of accordingly. 
	 
	 In the recursion method, there are many repetitive calls. Instead of repetitive calls, we can store this in a array and use them. 
	 If a particular cell is already visited/computed, 
	 				then directly use that value 
	 				or else compute and add the value.

	Below is the same above recursive code but with an array and memorization.  
	*/

	public static int fibM(int n){
		//array for memorization.
		int arr[] = new int[n+1];

		//to determine visited or not
		for(int i=0;i<n+1;i++){
			arr[i] = -1;
		}

		return fibM(n, storage);
	} 

	public static int fibM(int n, int[] arr){
		//base case.
		if(n == 0 || n == 1){
			arr[n] = n;
			return arr[n];
		}

		//check if the array cell is visited or not.
		//if visited, then directly take this value
		if(arr[n] != -1){
			return arr[n];
		}

		//if not visited, then compute and add to the array.
		arr[n] = fibM(n-1, arr) + fibM(n-2, arr);
		return arr[n];
	}

	/*
	The above procedure is called Top Down Approch. 

	Top Down Approch = Recursion + Array .
	
	In top down approch, we take a bigger block, then using recursion we go to the smaller blocks and store the data in an array.
	*/

	/*

	In Dynamic programing, we eliminate recursion. This is done by using buttom up approch. 
	In buttom up approch, we take smaller blocks and then move to bigger block. 
	
	Dynamic Programing = Iterative + Array .
	*/

	public static int fibDP(int n){
		int arr[] = new int[n+1];

		//base case
		arr[0] = 0;
		arr[1] = 1;

		//iterative or buttom up approch. 
		for(int i=2;i<=n;i++){
			arr[i] = arr[i-1] + arr[i-2];
		}

		return arr[n];
	}
 
	/*
	We have seen :   Recursion ------>  Memorization (top-down)   -------> DP (Buttom Up approch)

	DP can be applied if a problem contains 1. Overlapping Subproblem.
											2. Optimial Substructure. 
	*/






}









