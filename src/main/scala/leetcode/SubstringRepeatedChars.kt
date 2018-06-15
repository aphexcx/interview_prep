package leetcode

/** https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
fun lengthOfLongestSubstring(s: String): Int {
    if (s.length < 2) {
        return s.length
    }

    var maxlength = 0
    var subrange = 0 until 0
    for (c in s.indices) {
        while (s.slice(subrange).contains(s[c])) {
            subrange = (subrange.first + 1)..subrange.last
        }
        subrange = subrange.first..(subrange.last + 1)
        if (s.slice(subrange).length > maxlength) {
            maxlength = s.slice(subrange).length
        }
    }

    return maxlength
}

fun main(args: Array<String>) {
    print(lengthOfLongestSubstring("abcabcbb"))
}