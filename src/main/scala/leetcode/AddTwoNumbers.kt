package leetcode

/*
    Input: (2 -> 4 -> 3) +
           (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
     */
class ListNode(var value: Int = 0, var next: ListNode? = null) {
    companion object {
        fun printListNodes(node: ListNode?) {
            if (node == null) {
                print("\n")
                return
            }
            print("${node.value}->")
            printListNodes(node.next)
        }
    }
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        fun go(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? =
            when {
                l1 != null && l2 != null ||
                        l1 != null && l2 == null ||
                        l1 == null && l2 != null -> {
                    val sum = (l1?.value ?: 0) + (l2?.value ?: 0) + carry
                    ListNode(sum % 10)
                        .apply { next = go(l1?.next, l2?.next, sum / 10) }
                }
                carry > 0 -> ListNode(carry)
                else -> null
            }

        return go(l1, l2, 0)
    }
}
