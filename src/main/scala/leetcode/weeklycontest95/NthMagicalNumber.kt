package leetcode.weeklycontest95

import java.lang.Math.min
import java.lang.Math.pow

/* https://leetcode.com/contest/weekly-contest-95/problems/nth-magical-number/

A positive integer is magical if it is divisible by either A or B.

Return the N-th magical number.  Since the answer may be very large, return it modulo 10^9 + 7.


Example 1:
Input: N = 1, A = 2, B = 3
Output: 2

Example 2:
Input: N = 4, A = 2, B = 3
Output: 6

Example 3:
Input: N = 5, A = 2, B = 4
Output: 10

Example 4:
Input: N = 3, A = 6, B = 4
Output: 8


Note:

1 <= N <= 10^9
2 <= A <= 40000
2 <= B <= 40000

 */

// Recursive
fun nthMagicalNumberRec(N: Int, A: Int, B: Int): Int {
    tailrec fun go(num: Int, nth: Int): Int {
        if (num % A == 0 || num % B == 0) {
//            print("$num, ")
            if (nth == N) {
                return num
            } else {
                return go(num + 1, nth + 1)
            }
        } else {
            return go(num + 1, nth)
        }
    }
    return go(0, 0)
}

// Iterative
fun nthMagicalNumberIter(N: Int, A: Int, B: Int): Int {
    var num = 0
    var nth = 0
    while (true) {
        if (num % A == 0 || num % B == 0) {
            if (nth == N) {
                return (num % (pow(10.0, 9.0) + 7)).toInt()
            } else {
                nth += 1
            }
        }
        num += 1
    }

}

// Dynamic
fun nthMagicalNumber(N: Int, A: Int, B: Int): Int {
    tailrec fun go(num: Int, nth: Int): Int {
        print("$num, ")
        if (nth == N) {
            return num
        } else {
            return go(min(num + A, num + B), nth + 1)
        }
    }
    return go(min(A, B), 1)
}

// 0, 2, 3, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 26, 27, 28, 30, 32, 33, 34, 36, 38, 39, 40, 42, 44,
fun main(args: Array<String>) {
    println(nthMagicalNumber(1, 2, 3))
    println(nthMagicalNumber(4, 2, 3))
    println(nthMagicalNumber(5, 2, 4))
    println(nthMagicalNumber(3, 6, 4))
    println(nthMagicalNumber(885, 389, 256))
    println(nthMagicalNumber(3, 8, 9))
    println(nthMagicalNumber(3, 8, 9))
//    println(nthMagicalNumber(1000000000
//        ,40000
//        ,40000))
}