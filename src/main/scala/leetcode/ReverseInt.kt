package leetcode

// https://leetcode.com/problems/reverse-integer/description/

fun reverse(x: Int): Int {
    //split into digits
    val digits: MutableList<Int> = mutableListOf()

    //x div 10
    var remaining = x
    digits.add(remaining.rem(10))
    while (remaining.div(10) != 0) {
        remaining = remaining.div(10)
        digits.add(remaining.rem(10))
    }

    //reverse list

    //join and return
    var column = 1
    return try {
        digits.reversed().reduce { acc, i ->
            val new = acc.addExact(i multiplyExact 10 multiplyExact column)
            column *= 10
            new
        }
    } catch (e: ArithmeticException) {
        0
    }
}

infix fun Int.addExact(other: Int): Int {
    return Math.addExact(this, other)
}

infix fun Int.multiplyExact(other: Int): Int {
    return Math.multiplyExact(this, other)
}


fun main(args: Array<String>) {
    println(reverse(1534236469))
}