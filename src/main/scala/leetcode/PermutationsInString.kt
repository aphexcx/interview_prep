package leetcode

/** 567. Permutation in String

Given two strings s1 and s2, write a function to return true if s2 contains
the permutation of s1. In other words, one of the first string's permutations
is the substring of the second string.

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 */
//fun checkInclusion(s1: String, s2: String): Boolean {
//    // find all permutations of s1
//    val strBuf = StringBuffer(s1)
////    val permutations = doPerm(strBuf, s1.length)
//    val permutations =
//    // for each permutation, search s2 for it
//            // optimization: split s2 up into chunks of s1.size and put chunks in a set
////            println(permutations)
//    return true
//}

fun checkInclusion(s1: String, s2: String): Boolean {
    // one string contains a permutation of another string if one or more of
    // the windows (of size s1.size) of the second string contain the same characters
    // with the same frequency
    val s1freq = countCharFrequencies(s1)

    s2.windowed(s1.length) {
        countCharFrequencies(it.toString())
    }.forEach {
        if (s1freq == it) {
            return true
        }
    }
    return false
}

fun countCharFrequencies(str: String): HashMap<Char, Int> {
    return hashMapOf<Char, Int>().apply {
        str.forEach {
            this[it] = this.getOrDefault(it, 0) + 1
        }
    }
}

private fun <K, V> java.util.HashMap<K, V>.matches(otherMap: java.util.HashMap<K, V>): Boolean {
    return all { (k, v) ->
        otherMap[k] == v
    }
}


fun nextPermutation(array: IntArray): Boolean {
    // Find longest non-increasing suffix
    var i = array.size - 1
    while (i > 0 && array[i - 1] >= array[i])
        i--
    // Now i is the head index of the suffix

    // Are we at the last permutation already?
    if (i <= 0)
        return false

    // Let array[i - 1] be the pivot
    // Find rightmost element that exceeds the pivot
    var j = array.size - 1
    while (array[j] <= array[i - 1])
        j--
    // Now the value array[j] will become the new pivot
    // Assertion: j >= i

    // Swap the pivot with j
    var temp = array[i - 1]
    array[i - 1] = array[j]
    array[j] = temp

    // Reverse the suffix
    j = array.size - 1
    while (i < j) {
        temp = array[i]
        array[i] = array[j]
        array[j] = temp
        i++
        j--
    }

    // Successfully computed the next permutation
    return true
}

private fun doPerm(str: StringBuffer, index: Int): Set<StringBuffer> {
    if (index <= 0)
        return setOf(str)
    else { //recursively solve this by placing all other chars at current first pos
        val permutations = mutableSetOf<StringBuffer>()
        permutations.addAll(doPerm(str, index - 1))

        (str.length - index).let { currPos ->
            for (i in currPos + 1 until str.length) {
                //start swapping all other chars with current first char
                str.swap(currPos, i)
                permutations.addAll(doPerm(str, index - 1))
                //restore back my string buffer
                str.swap(i, currPos)
            }
        }

        return permutations
    }
}

private fun StringBuffer.swap(pos1: Int, pos2: Int) {
    val temp = this[pos1]
    setCharAt(pos1, this[pos2])
    setCharAt(pos2, temp)
}


fun main(args: Array<String>) {
    println(checkInclusion("ab", "eidbaooo"))
    println(checkInclusion("ab", "eidboaoo"))
}