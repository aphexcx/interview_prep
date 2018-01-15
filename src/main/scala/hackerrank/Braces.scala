package hackerrank

import java.util.NoSuchElementException

import scala.collection.mutable.Stack

class Braces {

  val OPENERS: List[Char] = List('{', '[', '(')
  val CLOSERS: List[Char] = List('}', ']', ')')

  def isBalanced(s: String): String = {
    var openerStack: Stack[Char] = Stack()
    for (c <- s) {
      if (OPENERS.contains(c)) {
        openerStack.push(c)
      } else {
        try {
          val opener = openerStack.pop()
          if (OPENERS.indexOf(opener) != CLOSERS.indexOf(c))
            return "NO"
        } catch {
          case nse: NoSuchElementException =>
            return "NO"
        }
      }
    }
    if (openerStack.isEmpty) "YES" else "NO"
  }

  def braces(values: Array[String]): Array[String] = {
    values.map(isBalanced)
  }
}
