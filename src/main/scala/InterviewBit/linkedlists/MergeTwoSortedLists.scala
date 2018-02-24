package InterviewBit.linkedlists

object MergeTwoSortedLists extends App {
  /*
  Merge two sorted linked lists and return it as a new list.
  The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

  For example, given following linked lists :

    5 -> 8 -> 20
    4 -> 11 -> 15
  The merged list should be :

  4 -> 5 -> 8 -> 11 -> 15 -> 20

   */

  def mergeTwoLists(A: ListNode, B: ListNode): ListNode = {

    var l1: ListNode = A
    var l2: ListNode = B
    if (l1 == null) return l2
    if (l2 == null) return l1

    var head: ListNode = l1
    if (l1.value < l2.value) {
      head = l1
    } else {
      head = l2
      l2 = l1
      l1 = head
    }
    while (l1.next != null) {
      if (l1.next.value > l2.value) {
        val tmp = l1.next
        l1.next = l2
        l2 = tmp
      }
      l1 = l1.next
    }
    l1.next = l2
    head
  }
}
