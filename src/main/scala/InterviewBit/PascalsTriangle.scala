package InterviewBit

import scala.collection.mutable

/**
  * Given numRows, generate the first numRows of Pascal’s triangle.
  * *
  * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
  *
  * Example:
  *
  * Given numRows = 5,
  *
  * Return
  *
  * [
  * [1],
  * [1,1],
  * [1,2,1],
  * [1,3,3,1],
  * [1,4,6,4,1]
  * ]
  *
  */
object PascalsTriangle extends App {
  // Memoized
  def generate(A: Int): Array[Array[Int]] = {
    def go: Int => Array[Int] = memoize {
      case 1 =>
        Array(1)
      case 2 =>
        Array(1, 1)
      case c =>
        1 +: (1 until c - 1).toArray.map { i => go(c - 1)(i) + go(c - 1)(i - 1) } :+ 1
    }


    (1 to A).map { r: Int =>
      go(r)
    }.toArray
  }

  def memoize[I, O](f: I => O): I => O = new mutable.HashMap[I, O]() {
    override def apply(key: I): O = getOrElseUpdate(key, f(key))
  }

  println(generate(5).map(a => println(a.map(print))))

  // Regular version
  def slowGenerate(A: Int): Array[Array[Int]] = {
    def go(c: Int): Array[Int] = {
      if (c == 1)
        Array(1)
      else if (c == 2)
        Array(1, 1)
      else {
        1 +: (1 until c - 1).toArray.map { i => go(c - 1)(i) + go(c - 1)(i - 1) } :+ 1
      }
    }

    (1 to A).map { r: Int =>
      go(r)
    }.toArray
  }
}


