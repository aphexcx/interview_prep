package InterviewBit.hashing

object Diffk extends App {
  /** https://www.interviewbit.com/problems/diffk-ii/
    * Given an array A of integers and another non negative integer k,
    * find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
    * *
    * Example :
    *
    * Input :
    *
    * A : [1 5 3]
    * k : 2
    *
    * Output:
    * 1
    * as 3 - 1 = 2
    *
    * *
    * Return 0 / 1 for this problem.
    */

  def diffPossible(A: Array[Int], k: Int): Int = {
    if (A.length < 2) return 0
    A.sorted.indices.foreach { i =>
      (i + 1 until A.length).foreach { j =>
        if (Math.abs(A(i) - A(j)) == k)
          return 1
      }
    }

    0
  }

  println(diffPossible(Array(1, 3, 2), 0))

}
