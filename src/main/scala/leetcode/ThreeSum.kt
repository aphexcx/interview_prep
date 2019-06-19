package leetcode

/** 15. 3Sum
Medium

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
[-1, 0, 1],
[-1, -1, 2]
]
 */

//-4 -1 -1 0 1 2

fun threeSum(nums: IntArray): List<List<Int>> {
    // brute force: for each num x, find another num y, and for each y, find another num z
    // and if x + y + z = 0 then add it to the solution set
    val solutions: MutableSet<List<Int>> = mutableSetOf()
    val sorted = nums.sorted()
    for (x in sorted.indices) {
        for (y in (x + 1)..sorted.lastIndex) {
            for (z in (y + 1)..sorted.lastIndex) {
                if (sorted[x] + sorted[y] + sorted[z] == 0) {
                    solutions.add(listOf(sorted[x], sorted[y], sorted[z]).sorted())
                }
            }
        }
    }

    return solutions.toList()
}


fun main(args: Array<String>) {
    val r = threeSum(listOf(-1, 0, 1, 2, -1, -4).toIntArray())
    println(r)
}