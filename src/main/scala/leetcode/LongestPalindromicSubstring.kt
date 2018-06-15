package leetcode

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

 */

val memo: MutableMap<String, String> = mutableMapOf()

fun longestPalindrome(s: String): String {
    return memo.getOrPut(s) {
        when {
            s.length == 1 -> s
            isPalindrome(s) -> s
            else -> longestString(longestPalindrome(s.tail), longestPalindrome(s.init))
        }
    }
}

fun longestString(first: String, second: String): String =
    if (first.length > second.length) first else second

private val String.init: String
    get() = dropLast(1)

private val String.tail: String
    get() = substring(1, length)

val memoIsPalindrome: MutableMap<String, Boolean> = mutableMapOf()
fun isPalindrome(str: String): Boolean =
    memoIsPalindrome.getOrPut(str) { str == str.reversed() }

fun main(args: Array<String>) {
//    println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"))
    println(longestPalindrome("babaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerbabaddtattarrattatddetartrateedredividerb"))
}


//fun longestPalindromeIterative(s: String): String {
//    //Two pointers, both starting at the beginning
//    var currentLength = 0
//    var maxLength = 0
//    var maxIndices = 0..0
//    var left = 0
//    var right = 0
//    while (right < s.length - 1) {
//        // Increment right pointer by 1
//        right++
//        //  Check if we're currently a palindrome
//        if (isPalindrome(s.slice(left..right))) {
//            //  if we are, increment length of current palindrome
//            currentLength = right - left
//            if (currentLength > maxLength) {
//                maxLength = currentLength
//                maxIndices = left..right
//            }
//        } else {
//            //  if we aren't, move left pointer by 1 and check again
//            left++
//        }
//        // <-- loop
//    }
//
//    return s.slice(maxIndices)
//}