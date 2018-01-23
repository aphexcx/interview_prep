package hackerrank.unit1

object LongestSubarray extends App {

  def findSubArrays(a: Array[Int], k: Int): Array[Array[Int]] = {
    (1 to a.length).foldLeft(Array[Array[Int]]()) { (acc: Array[Array[Int]], c: Int) =>
      //        acc ++ a.combinations(c).filter(_.sum <= k).toSeq
      val s = a.sliding(c, 1).toSeq
      //      if (s.map(_.sum).forall(_ > k))
      //        return acc
      //      else
      acc ++ s
    }
  }

  // maxLength((1,2,3), 4) => 2 because the subarrays that sum to <= 4 are (1,2,3) and (1,2),
  // and we return the length of the longest subarray
  def maxLength(a: Array[Int], k: Int): Int = {
    //find subarrays of a
    // return the longest one
    findSubArrays(a, k)
      .filter(_.sum <= k)
      .map(_.length).max
  }

  //  println(maxLength(Array(1, 2, 3), 4))

  println(maxLength(
    """74
659
931
273
545
879
924
710
441
166
493
43
988
504
328
730
841
613
304
170
710
158
561
934
100
279
817
336
98
827
513
268
811
634
980
150
580
822
968
673
394
337
486
746
229
92
195
358
2
154
709
945
669
491
125
197
531
904
723
667
550""".filterNot(_.isWhitespace).split('|').filter(!_.isEmpty).map(s => s.toInt), 22337))
}
