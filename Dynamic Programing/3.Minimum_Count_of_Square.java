/*
Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. 
The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.

Input format :
The first and the only line of input contains an integer value, 'N'.

Output format :
Print the minimum count of numbers required.

Sample Input 1 :
12
Sample Output 1 :
3

Explanation of Sample Output 1 :
12 can be represented as : 
A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)
B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)  + (2 ^ 2)
C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)
D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)
As we can see, the output should be 3.

*/

public class Solution {

	/*
	Recursion:
	               min( below ) 
		f(n)  =  1^2 + f(n-1^2);     n-1^2 >=0 ,
		       = 2^2 + f(n-2^2);      n-2^2 >=0 ,
			   = 3^2 + f(n-3^2);     n-3^2 >= 0 ,
			   = ,, ,
			   = .. ,
			   = (n-1)^2 + f(n-(n-1)^2);  

	    f(0) = 0      : base condition
		f(1) = 1      : base condition
	*/

	public static int minCount(int n) {
		//Your code goes here

		if(n == 0 || n == 1){
			return n;
		}

		int getans = Integer.MAX_VALUE;
		for(int i = 1 ; i < n ; i++){
			if( n - (i*i) < 0 ){
				break;
			}
			int currentvalue = 1 + minCount(n-(i*i));
			if(currentvalue < getans){
				getans = currentvalue;
			}
		}
		return getans;
	}


//Dynamic Programing 
	//if recursion problem is clear then this is simple
	public static int minCount(int n) {
		//Your code goes here

		int arr[] = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;

		//traversing each cell from 2 to n-1
		for(int i=2; i<n+1;i++){
			
			//for each cell i need to travers from  1 to n with a condition.
			// And need to take minimum of all these things
			int getans = Integer.MAX_VALUE;

			for(int j=1; j<i ; j++){

				if(i - (j*j) < 0){
					break;
				}	
				int currentval = 1 + arr[i-(j*j)];
				if(currentval < getans){
					getans = currentval;
				}
			}

			arr[i] = getans;
		}
		return arr[n];
	}
}


