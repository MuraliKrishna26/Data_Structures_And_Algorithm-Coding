
//LEETCODE QUESTION : 91. DecodeWays

/*

A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

*/

class Solution {

    /*

        S : 123.....i.........n


        Main Case : 
        At i'th position,
        We have 2 cases here - 1. We can pick one digit 
                               2. We can pick two digit
        
        >> we can pick 2 digit : if the value is less than equall 26 and greter than 10, then 2 cases.
                                 else if first digit is 0, then skip it. 
           else 
                we can choose 1 digit. 

        Base Case : 
        1. i can reach end of the string. 
        2. i can exceed the string length. 

        if i reaches end of the string, and i value is 0, then do not count. Skip It. 
                                            i value is not 0, then count it.

        if i exceed the string(jumping 2 digits), then return 1.(because we need to count it)


    */

    public int numDecodings(String s, int i){

        // in this question, it is better to start from base case. 

        //Base Case
        if( i == s.length() - 1 && s.charAt(i) == '0' ){
            return 0;
        }
        if( i >= s.length() - 1){
            return 1;
        }


        //2 cases - 1 digit and 2 digit.
        // check if 2 digit is satisfied, if yes then add 2 cases. 
        //                                else add 1 case                                  
        if(Integer.parseInt(s.substring(i,i+2)) <= 26 && s.charAt(i) != '0' ){
            System.out.println(s.substring(i,i+2));
            return numDecodings(s, i+1) + numDecodings(s, i+2);
        }else if(s.charAt(i) == '0'){
            return 0;
        }
        return numDecodings(s, i+1);
    }



    public int numDecodings(String s) {        
        int iter = 0; 
        if(s.charAt(0) == '0'){
            return 0;
        }
        return numDecodings(s,0);
    }
}