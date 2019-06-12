package leetcode

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6

Explanation: [4,-1,2,1] has the largest sum = 6.


Follow up:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
fun IntArray.sum(range: IntRange): Int {
    return slice(range).sum()
}

//fun maxSubArray(nums: IntArray): Int {
//    //starting at midpoint, using sum == current element, expand subarray to the left and right alternating, picking the max of the two
//    val midpoint: Int = nums.size / 2 + nums.size % 2
//
//    fun go(arr: IntRange, curMax: Int = 0) {
//        go(arr.first - 1..arr.last, max(nums.sum(arr.first - 1..arr.last), nums)
//    }
//
//    go(midpoint..midpoint)
//}


/**Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6

Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
//fun maxSubArray(nums: IntArray): Int {
//
//    //starting at midpoint, using sum == current element, expand subarray to the left and right alternating, picking the max of the two
//    value midpoint: Int = nums.size / 2 + nums.size % 2
//
//    fun go(arr: IntRange, curMax: Int = 0) {
//        if (arr.first)
//    }
//
//    go(midpoint..midpoint)
//
//}


/** Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6

Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
//fun maxSubArray(nums: IntArray): Int {

//starting at midpoint, using sum == current element, expand subarray to the left and right alternating, picking the max of the two
//    value midpoint: Int = nums.size / 2 + nums.size % 2
//
//    fun go(arr: IntArray, range: IntRange, curMax: Int = 0): Int {
//        value mySum = arr.slice(range).sum()
//        if (mySum > curMax)
//            return mySum
//        else
//            return max(go(arr, range.first-1..range.last, curMax), go())
//    }
//
//    go(midpoint..midpoint)
//
//}

/**
 * Concatenated Words
Difficulty:Hard

Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
"dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.
 */
//fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
////    words.sorted.
//}