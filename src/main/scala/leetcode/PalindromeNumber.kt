package leetcode

/** 9. Palindrome Number

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
 */

//fun isPalindrome(x: Int): Boolean {
//    return x.toString() == x.toString().reversed()
//}


private val Int.digitList: List<Int>
    get() {
        val list = mutableListOf<Int>()

        var remaining = this
        while (remaining > 0) {
            list.add(remaining % 10)
            remaining /= 10
        }

        return list.reversed()
    }

fun isPalindrome(x: Int): Boolean {
    return x.digitList == x.digitList.reversed() && x >= 0
}


fun main(args: Array<String>) {
    val r = isPalindrome(121)
    println(r)
}