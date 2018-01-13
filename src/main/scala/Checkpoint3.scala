class Checkpoint3 {

  def kthsmallest(A: Array[Int], B: Int): Int = {
    A.sorted.apply(B - 1)
  }
}
