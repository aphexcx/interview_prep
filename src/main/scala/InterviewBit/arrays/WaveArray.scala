package InterviewBit.arrays

import scala.annotation.tailrec
import scala.collection.mutable

object WaveArray extends App {

  val memo = new mutable.HashMap[(Array[Int], Array[Int]), Array[Int]]()


  /*
  Given an array of integers, sort the array into a wave like array and return it,
 In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5...


   Given [1, 2, 3, 4]

   One possible answer : [2, 1, 4, 3]
   Another possible answer : [4, 1, 3, 2]

    */
  def wave(A: Array[Int]): Array[Int] = {
    @tailrec def go(arr: Array[Int], remaining: Array[Int]): Array[Int] = {
      if (remaining.length == 0) {
        arr
      } else {
        if ((arr.length % 2) == 1) {
          if (arr.last >= remaining(0))
            go(arr :+ remaining(0), remaining.tail)
          else
            go(arr.init :+ remaining(0), arr.last +: remaining.tail)
        } else {
          if (arr.last <= remaining(0))
            go(arr :+ remaining(0), remaining.tail)
          else
            go(arr.init :+ remaining(0), arr.last +: remaining.tail)
        }
      }
    }

    go(A.sorted.take(1), A.sorted.tail)
  }

  def memowave(A: Array[Int]): Array[Int] = {
    def go(arr: Array[Int], remaining: Array[Int]): Array[Int] = {
      if (remaining.length == 0) {
        arr
      } else {

        if ((arr.length % 2) == 1) {
          if (arr.last >= remaining(0)) {
            val a = (arr :+ remaining(0), remaining.tail)
            memo.getOrElseUpdate(a, (go _).tupled(a))
          }
          else {
            val a = (arr.init :+ remaining(0), arr.last +: remaining.tail)
            memo.getOrElseUpdate(a, (go _).tupled(a))
          }
        } else {
          if (arr.last <= remaining(0)) {
            val a = (arr :+ remaining(0), remaining.tail)
            memo.getOrElseUpdate(a, (go _).tupled(a))
          }
          else {
            val a = (arr.init :+ remaining(0), arr.last +: remaining.tail)
            memo.getOrElseUpdate(a, (go _).tupled(a))
          }
        }
      }
    }

    go(A.sorted.take(1), A.sorted.tail)
  }

  /** array = {5, 1, 3, 4, 2}
    * *
    * Sort the above array.
    * *
    * array = {1, 2, 3, 4, 5}
    * *
    * Now swap adjacent elemets in pairs.
    * *
    * swap(1, 2)
    * swap(3, 4)
    * *
    * Now, our array = {2, 1, 4, 3, 5}
    * *
    * and voila!, the array is in the wave form.
    */
  def swapwave(A: Array[Int]): Array[Int] = {
    A.sorted.sliding(2, 2).foldLeft(Array[Int]()) { (acc: Array[Int], c: Array[Int]) =>
      if (c.length > 1)
        acc :+ c(1) :+ c(0)
      else
        acc :+ c(0)
    }
  }

  println(swapwave(Array(5, 1, 3, 2, 4)).mkString)
}
