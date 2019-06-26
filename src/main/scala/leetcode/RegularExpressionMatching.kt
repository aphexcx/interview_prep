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
    val yummy = YummyString(str)
    var idx = 0
    val opcodes = pattern.toOpcodes()
    fun patternCompleted() = idx > opcodes.lastIndex
    try {
        while (idx < opcodes.size) {
            val opcode: MatcherOpcode = opcodes[idx]
            when (opcode) {
                is MatcherOpcode.REPEAT_ZERO_OR_MORE -> {
                    yummy.eatZeroOrMoreOf(opcode.c)
                    idx += 1
                }
                is MatcherOpcode.CHAR,
                MatcherOpcode.ANY -> {
                    try {
                        if (opcode is MatcherOpcode.CHAR) {
                            yummy.eat(opcode.c)
                        } else {
                            yummy.eatAny()
                        }
                        idx += 1
                    } catch (e: MatchFailedCharNotFoundException) {
                        if (!patternCompleted() && (opcodes[idx - 1] is MatcherOpcode.REPEAT_ZERO_OR_MORE)) {
                            yummy.regurgitateOne()
                        } else {
                            throw e
                        }
                    }
                }
            }
        }
    } catch (e: ReachedEndOfStringException) {
        return yummy.ateEverything && patternCompleted()
    } catch (e: MatchFailedException) {
        return false
    }
    return yummy.ateEverything && patternCompleted()
}

// "bc*a*b" -> REPEAT_ZERO_OR_MORE(c), REPEAT_ZERO_OR_MORE(a), CHAR(b)
private fun String.toOpcodes(): List<MatcherOpcode> {
    val opcodes: MutableList<MatcherOpcode> = mutableListOf()

    // coalesce repeats into one opcode and convert chars/anys
    forEachIndexed { idx: Int, first: Char ->
        val next = getOrNull(idx + 1)
        when {
            first == '*' -> {
            }
            next == '*' -> opcodes.add(MatcherOpcode.REPEAT_ZERO_OR_MORE(first))
            else -> opcodes.add(first.toOpcode())
        }
    }

    return opcodes.toList()

}

private fun Char.toOpcode(): MatcherOpcode {
    return when (this) {
        '.' -> MatcherOpcode.ANY
        in 'a'..'z' -> MatcherOpcode.CHAR(this)
        else -> throw UnrecognizedCharInPatternException(this)
    }
}

class UnrecognizedCharInPatternException(c: Char) : Throwable()

sealed class MatcherOpcode(c: Char?) {
    data class CHAR(val c: Char) : MatcherOpcode(c)
    data class REPEAT_ZERO_OR_MORE(val c: Char) : MatcherOpcode(c)
    object ANY : MatcherOpcode(null)
}

class YummyString(val str: String) {

    private var currentPos: Int = 0

    val ateEverything: Boolean
        get() = currentPos == str.length

    private fun advance() {
        currentPos += 1
    }

    fun regurgitateOne() {
        currentPos -= 1
        if (currentPos < 0) currentPos = 0
    }

    fun eat(c: Char) {
        if (str.isEmpty()) {
            throw MatchFailedCharNotFoundException(c, str)
        }
        if (currentPos >= str.length) {
            throw MatchFailedCharNotFoundException(c, str)
        }
        if (str[currentPos] == c) {
            advance()
        } else {
            throw MatchFailedCharNotFoundException(c, str.slice(currentPos..str.lastIndex))
        }
    }

    fun eatAny() {
        if (currentPos >= str.length) {
            throw MatchFailedCharNotFoundException('.', str)
        }
        advance()

    }

    fun eatZeroOrMoreOf(c: Char) {
        try {
            while (true) {
                when (c) {
                    '.' -> eatAny()
                    else -> eat(c)
                }
            }
        } catch (e: MatchFailedCharNotFoundException) {
            return
        } catch (e: ReachedEndOfStringException) {
            return
        }
    }
}

open class MatchFailedException : Throwable()

class ReachedEndOfStringException : Throwable()

data class MatchFailedCharNotFoundException(val c: Char, val remaining: String) : MatchFailedException()

fun main(args: Array<String>) {
//    println(isMatch("aa", "a"))
//    println(isMatch("aa", "a*"))
//    println(isMatch("ab", ".*"))
    println(isMatch("aab", "c*a*b"))
//    println(isMatch("mississippi", "mis*is*p*."))
//    println(isMatch("", "c*"))
    println(isMatch("ab", ".*c")) // backtrack case
//    println(isMatch("a", ".*..a*"))
    println(isMatch("aaa", "aaaa"))
    println(isMatch("aaa", "a*a"))
    println(isMatch("ab", ".*"))
}