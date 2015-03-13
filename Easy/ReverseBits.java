/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
*/

public class Solution {     // Bit Manipulation
    // you need treat n as an unsigned value
    // 对于给定的数，从最高位开始，将其分离出来，最低位就是答案的最高位。循环32次，每次将分离出来的数乘以2^i，i=0,1,2,…,31
    public int reverseBits(int n) {
        int result = 0;
        for(int i =0;i<32;i++){
            if( ((1<<i) & n) != 0 )         // get bit(use &), shift left
                result |= 1<< (31-i);       // set bit(use |)
        }
        return result;
    }
}

/*
Similar to Reverse Integer - https://leetcode.com/problems/reverse-integer/

// use string
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String str = Integer.toBinaryString(n);

        // expand to 32 bits
        int length = str.length();
        for (int i = 0; i < 32 - length; i++) {
            str = "0" + str;
        }

        // convert to unsigned int
        long result = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            result += Integer.parseInt(arr[i] + "") * Math.pow(2, i);
        }

        return (int)result;
    }
}

// use stringbuilder
String str=Integer.toUnsignedString(n,2);
    StringBuilder sb=new StringBuilder();
       for(int i=str.length(); i<32;i++){
           sb.append("0");
       }
       sb.append(str);
     return (int)  Integer.parseUnsignedInt(sb.reverse().toString(),2);

// system reverse method
Integer.reverse(n)


Reference:
https://leetcode.com/discuss/27484/java-solution-without-explicit-bits-manipulation
https://leetcode.com/discuss/27577/share-my-java-code
*/