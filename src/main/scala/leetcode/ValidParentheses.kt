package leetcode

/** Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true


 */
val PARENS = hashMapOf<Char, Char>(
    '(' to ')',
    '[' to ']',
    '{' to '}'
)

val OPENS = listOf('(', '{', '[')
val CLOSES = listOf(')', '}', ']')

fun isValid(s: String): Boolean {
    val closes = mutableListOf<Char>()
    try {
        s.forEach {
            when (it) {
                in OPENS -> closes.add(PARENS[it]!!)
                in CLOSES -> {
                    if (closes.last() != it)
                        return false
                    else
                        closes.removeAt(closes.size - 1)
                }
            }
        }
    } catch (e: NoSuchElementException) {
        return false
    }

    return closes.isEmpty()
}

fun main(args: Array<String>) {
    println(isValid("()"))
    println(isValid("([])"))
    println(isValid("([{}])"))
    println(isValid("([{])"))
}