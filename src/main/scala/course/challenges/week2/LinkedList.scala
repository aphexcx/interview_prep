package course.challenges.week2

/*
Implement a simple linked list in Java
without using any collections classes.
The list should be implemented using a single class such that each instance represents a single node in the list,
encapsulating the node's value and a reference to the following node, as well as a convenience method to initialize
a whole list from an array of values. The class should implement the following interface:

*/

trait LinkedListNode[E] {

  /* getter/setter for this node's value */
  def getValue: E

  def setValue(value: E): Unit

  /* getter/setter for the subsequent node, or null if this is the last node */
  def getNext: LinkedListNode[E]

  def setNext(next: LinkedListNode[E]): Unit

  /**
    * Initialize this node and all of its subsequent nodes from
    * an array of values, starting with the head value at index 0
    *
    * @param listValues - the ordered values for the whole list
    */
  def setValuesFromArray(listValues: Array[E]): Unit

}


class LLNode[E](var value: E, var next: Option[LinkedListNode[E]] = None)
  extends LinkedListNode[E] {

  override def getValue: E = {
    value
  }

  override def setValue(v: E): Unit = {
    value = v
  }

  override def getNext: Option[LinkedListNode[E]] =
    next

  override def setNext(n: LinkedListNode[E]): Unit = {
    next = Some(n)
  }

  override def setValuesFromArray(listValues: Array[E]): Unit = {
    if (listValues.isEmpty) return

    setValue(listValues.head)

    var currNode = this

    (1 until listValues.length).foreach { i =>
      var next = new LLNode(listValues(i))
      currNode.setNext(next)
      currNode = next
    }
  }
}
