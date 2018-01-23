package hackerrank.unit1

object LongestSubsequence extends App {
  def longestSubsequence(x: String, y: String): Int = {
    val xsubsequences: Array[String] = (1 to x.length).foldLeft(Array[Array[String]]()) { (acc: Array[Array[String]], c: Int) =>
      acc :+ x.combinations(c).toArray
    }.flatten

    val ysubstrings: Array[String] = (1 to y.length).foldLeft(Array[Array[String]]()) { (acc: Array[Array[String]], c: Int) =>
      acc :+ y.sliding(c, 1).toArray
    }.flatten

    xsubsequences.intersect(ysubstrings).map(_.length).max
  }

  println(longestSubsequence("abc", "aedace"))
}
