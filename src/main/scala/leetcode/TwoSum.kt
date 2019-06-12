package leetcode

/** 1. Two Sum
Easy

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in (i + 1..nums.lastIndex)) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return arrayOf(0, 0).toIntArray()
}

fun twoSumHash(nums: IntArray, target: Int): IntArray {
    val numsToIndices = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        numsToIndices[nums[i]] = i
    }

    for (i in nums.indices) {
        if (numsToIndices.contains(target - nums[i])
            && numsToIndices.getValue(target - nums[i]) != i
        ) {
            return intArrayOf(i, numsToIndices.getValue(target - nums[i]))
        }
    }
    return arrayOf(0, 0).toIntArray()
}

fun main(args: Array<String>) {
    val r = twoSumHash(intArrayOf(3, 2, 4), 6)
    println(r)
}