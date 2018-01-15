package hackerrank

object ArrangingCoins extends App {

  def maxStaircaseRowsFor(numOfCoins: Long): Long = {
    var totalRows = 0
    Stream.from(1).foldLeft(numOfCoins) { (remaining: Long, i: Int) =>
      if (remaining - i < 0) {
        return totalRows
      } else {
        totalRows += 1
        remaining - i
      }
    }
  }

  def arrangeCoins(coins: Array[Long]): Unit = {
    coins.map(maxStaircaseRowsFor).foreach(println)
  }

  //  def maxStaircaseRowsFor(numOfCoins: Long): Long = {
  //    var totalRows = 0
  //    var remaining = numOfCoins
  //    var total = 0
  //    for (i <- 1 to 100000) {
  //      if (total + i > numOfCoins ) {
  //        return totalRows
  //      } else {
  //        totalRows += 1
  //        total += i
  //      }
  //    }
  //    totalRows
  //  }
  //
  //  def arrangeCoins(coins: Array[Long]): Unit = {
  //    coins.map(maxStaircaseRowsFor).foreach(println)
  //  }

  arrangeCoins(Array(2, 5, 8, 0, -1, 100000))

}
