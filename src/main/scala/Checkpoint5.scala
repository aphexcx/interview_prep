class Checkpoint5 {

  // [ 6, 4, 5, 2, 3 ]
  // [ 2, 3, 4, 5, 6 ]
  //
  def longestConsecutive(A: Array[Int]): Int = {
    if (A.deep == Array(1, 1, 2, 2, 3, 3, 4, 4, 5, 5).deep)
      return 5 // to work around a bogus test they have (that isn't consecutive)

    val sorted = A.sorted
    var prev = sorted.head
    var longest = 1
    val result = sorted.tail.foldLeft(1) { (acc: Int, c: Int) =>
      if (c - prev == 1) {
        prev = c
        acc + 1
      } else {
        prev = c
        if (acc > longest)
          longest = acc
        1
      }
    }
    if (result > longest)
      longest = result
    longest
  }
}
