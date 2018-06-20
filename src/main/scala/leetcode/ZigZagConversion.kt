package leetcode

/** https://leetcode.com/problems/zigzag-conversion/description/
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

 */


fun convert(s: String, numRows: Int): String {
    if (numRows == 1) {
        return s
    }

    val rows: Array<StringBuffer> = Array(numRows) { StringBuffer() }
    var r = 0
    var step = 1
    s.forEach {
        rows[r].append(it)

        when {
            r == numRows - 1 -> step = -1
            r == 0 -> step = 1
        }
        r += step
    }

    return rows.reduce { acc, stringBuffer -> acc.append(stringBuffer) }.toString()
}

fun main(args: Array<String>) {
    println(convert("PAYPALISHIRING", 3))
    println(convert("PAYPALISHIRING", 4))
    println(convert("AB", 1))
}