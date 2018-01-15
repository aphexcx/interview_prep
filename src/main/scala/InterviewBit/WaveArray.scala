package InterviewBit

object WaveArray extends App {
  /*
   Given [1, 2, 3, 4]

   One possible answer : [2, 1, 4, 3]
   Another possible answer : [4, 1, 3, 2]

    */
  def wave(A: Array[Int]): Array[Int] = {
    def go(arr: Array[Int], remaining: Array[Int]): Array[Int] = {
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

  println(wave(Array(5, 1, 3, 2, 4)).mkString)
}
