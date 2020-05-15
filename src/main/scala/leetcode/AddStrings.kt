package leetcode

/** 415. Add Strings
Easy

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
// "100" + "32" = "132"
// "99" + "14" = "113"

fun addStringsBetter(num1: String, num2: String): String {
    // Traverse both strings from reverse, digit by digit and add together, plus carry digit
    // Store result in new string
    // Stop when both digits and carry is zero
    var idx1 = num1.lastIndex
    var idx2 = num2.lastIndex
    var result: StringBuilder = StringBuilder()
    var digitSum: Int = 0

    while (true) {
        val digit1: Char? = num1.getOrNull(idx1)
        val digit2: Char? = num2.getOrNull(idx2)

        if (digit1 == null && digit2 == null && digitSum == 0)
            break

        digitSum += digit1.toDigitOrZero() + digit2.toDigitOrZero()
        val digitSumChar: Char = digitSum.toString().toCharArray()[0]

        result.append(digitSum % 10)
        digitSum /= 10

        idx1 -= 1
        idx2 -= 1
    }

    return result.reverse().toString()

}


fun addStrings(num1: String, num2: String): String {
    // Traverse both strings from reverse, digit by digit and add together, plus carry digit
    // Store result in new string
    // Stop when both digits and carry is zero
    var currentIndex = 0
    var carryDigit = 0
    var result: StringBuilder = StringBuilder()

    while (true) {
        val digit1: Char? = num1.getDigit(currentIndex)
        val digit2: Char? = num2.getDigit(currentIndex)
        if (digit1 == null && digit2 == null && carryDigit == 0)
            break

        var digitSum: Int = (digit1.toDigitOrZero() + digit2.toDigitOrZero() + carryDigit)
        carryDigit = digitSum / 10
        digitSum %= 10
        val digitSumChar: Char = digitSum.toString().toCharArray()[0]

        result.append(digitSumChar)

        currentIndex += 1
    }

    return result.reverse().toString()

}

private fun Char?.toDigitOrZero(): Int {
//    return this?.toDigit() ?: 0
    return this?.let { it.toInt() - '0'.toInt() } ?: 0
}

private fun Char?.toDigit(): Int? {
    return when (this) {
        '0' -> 0
        '1' -> 1
        '2' -> 2
        '3' -> 3
        '4' -> 4
        '5' -> 5
        '6' -> 6
        '7' -> 7
        '8' -> 8
        '9' -> 9
        else -> null
    }
}

private fun String.getDigit(digitIndex: Int): Char? {
    return reversed().getOrNull(digitIndex)
}


fun main(args: Array<String>) {
    val r = addStrings("100", "32")
    println(r)
    val r2 = addStrings("99", "14")
    println(r2)
    val r3 = addStrings("", "14")
    println(r3)
    val r4 = addStrings("", "")
    println(r4)
}
