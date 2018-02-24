package InterviewBit.linkedlists

/*
 * Given a linked list, swap every two adjacent nodes and return its head.

  For example,
  Given 1->2->3->4, you should return the list as 2->1->4->3.

        2->1->3->4
  Your algorithm should use only constant space.
  You may not modify the values in the list, only nodes itself can be changed.
*/


class ListNode(val xc: Int, listNode: ListNode = null) {
  var value: Int = xc
  var next: ListNode = listNode
}

object SwapListNodes extends App {


  def swapPairs(A: ListNode): ListNode = {
    var first: ListNode = A
    var second: ListNode = A.next
    var head = A
    var firstIteration = true
    while (second != null) {
      var nextPairStart = second.next
      second.next = first
      first.next = nextPairStart
      if (firstIteration) {
        firstIteration = false
        head = second
      }

      if (nextPairStart == null)
        return head
      first.next = if (nextPairStart.next != null) nextPairStart.next else nextPairStart

      first = nextPairStart
      second = nextPairStart.next
    }
    head
  }

  val l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))
  swapPairs(l)
}
