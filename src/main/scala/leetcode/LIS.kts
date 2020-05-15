package leetcode

//fun lengthOfLIS(nums: IntArray): Int {
//
//    fun lisLength(i: Int): Int {
//        if (nums[i - 1] < nums[i]) {
//            return lisLength(i + 1) + 1
//        } else {
//            return 1
//        }
//    }
//
//    var maxLisLength = 0
//    for (i in 1..nums.lastIndex) {
//        val lisLength = lisLength(i)
//        if (lisLength > maxLisLength) {
//            maxLisLength = lisLength
//        }
//    }
//
//    return maxLisLength
//}

fun lengthOfLIS(nums: IntArray): Int {

    fun lisLength(prevElement: Int, currentIdx: Int): Int {
        if (currentIdx == nums.size) {
            return 0
        }

        var taken = 0
        if (prevElement < nums[currentIdx]) {
            taken = lisLength(nums[currentIdx], currentIdx + 1) + 1
        }
        val nottaken = lisLength(prevElement, currentIdx + 1)

        return Math.max(taken, nottaken)
    }


    return lisLength(Integer.MIN_VALUE, 0)
}

val r = lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))
println(r)
