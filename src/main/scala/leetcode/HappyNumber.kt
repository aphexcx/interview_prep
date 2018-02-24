package leetcode


/** https://leetcode.com/problems/happy-number/description/
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer,
replace the number by the sum of the squares of its digits,
and repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

 */
fun isHappy(n: Int): Boolean {
    fun go(n: Int, seen: Set<Int>): Boolean =
        if (n == 1) {
            true
        } else {
            n.digits.map { it * it }.sum().let { sum ->
                if (seen.contains(n))
                    false
                else
                    go(sum, seen + n)
            }
        }

    return go(n, setOf())
}

private val Int.digits: List<Int>
    get() {
        var n = this
        val l: MutableList<Int> = mutableListOf()
        while (n > 0) {
            l.add(n % 10)
            n /= 10
        }
        return l
    }


fun main(args: Array<String>) {
//    println(2.digits)
    println(isHappy(19))
}