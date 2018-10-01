package leetcode

/** https://leetcode.com/problems/regular-expression-matching/description/

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:
s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

Example 5:
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */

fun isMatch(str: String, pattern: String): Boolean {
    var remaining = str
    fun consumeOne(): Char? {
        val first = remaining.firstOrNull()
//        try {
        remaining = remaining.substring(1)
//        } catch (e: IndexOutOfBoundsException) {
//            return null
//        }
        return first
    }

    try {
        var prevPat: Char? = null
        var isRepeating = false
        pattern.forEachIndexed { index, pat ->
            when (pat) {
                in 'a'..'z' -> {
                    if (pattern[index + 1] != '*') {
                        if (consumeOne() != pat) return false
                    }
                }
                '.' -> {
                    consumeOne()
                }
                '*' -> {
                    isRepeating = true
                    while (isRepeating) {
                        when (prevPat) {
                            in 'a'..'z' -> {
                                if (consumeOne() != prevPat) {
                                    isRepeating = false
                                }
                            }
                            '.' -> {
                                consumeOne()
                            }
                        }
                    }
                }
            }
            prevPat = pat
        }
    } catch (e: IndexOutOfBoundsException) {
        return remaining.isEmpty()
    }
    return remaining.isEmpty()
}

fun main(args: Array<String>) {
    println(isMatch("aa", "a"))
    println(isMatch("aa", "a*"))
    println(isMatch("ab", ".*"))
    println(isMatch("aab", "c*a*b"))
    println(isMatch("mississippi", "mis*is*p*."))
    println(isMatch("mississippi", "mis*is*ip*.")) // backtrack case
}