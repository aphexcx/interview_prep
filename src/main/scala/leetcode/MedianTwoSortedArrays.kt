package leetcode

/** There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    return (nums1 + nums2).sortedArray().median
}

private val IntArray.median: Double
    get() {
        return when (size % 2) {
            0 -> (get(size / 2 - 1) + get(size / 2)) / 2.0
            else -> get(size / 2).toDouble()
        }

    }

fun main(args: Array<String>) {
    println(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
}