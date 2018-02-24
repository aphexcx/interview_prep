package leetcode

/*
    Input: (2 -> 4 -> 3) +
           (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
     */
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        fun go(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? =
            when {
                l1 != null && l2 != null ||
                        l1 != null && l2 == null ||
                        l1 == null && l2 != null -> {
                    val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
                    ListNode(sum % 10)
                        .apply { next = go(l1?.next, l2?.next, sum / 10) }
                }
                carry > 0 -> ListNode(carry)
                else -> null
            }

        return go(l1, l2, 0)
    }
}
