package leetcode.weeklycontest95

import leetcode.ListNode
import leetcode.ListNode.Companion.printListNodes

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.

Follow up:
Could you do this in one pass?
 * */

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return head
    var startNPrevPointer = n

    var current = head
    var nPrevPointer = head

    while (current != null) {
        //pass over list while keeping track of pointer n previous to current position
        when {
            startNPrevPointer == -1 -> nPrevPointer = nPrevPointer?.next
            else -> startNPrevPointer--
        }
        current = current.next
    }
    // when next is null, we have reached the end. take the nprevious pointer, and set its next to next.next
    nPrevPointer?.next = nPrevPointer?.next?.next
    if (current == nPrevPointer && nPrevPointer == head) {
        return null
    }
    return head
}

fun main(args: Array<String>) {
    printListNodes(
        removeNthFromEnd(
            ListNode(
                1,
                ListNode(2, ListNode(3, ListNode(4, ListNode(5, null))))
            ), 2
        )
    )
    printListNodes(removeNthFromEnd(ListNode(1, null), 2))
}

