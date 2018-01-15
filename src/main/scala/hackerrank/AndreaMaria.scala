package hackerrank

class AndreaMaria {
  def isOdd(i: Int): Boolean = i % 2 == 1

  def winner(andrea: Array[Int], maria: Array[Int], s: String): String = {
    val indices = s match {
      case "Odd" => andrea.indices.filter(isOdd)
      case "Even" => andrea.indices.filterNot(isOdd)
    }

    val andreaSum = indices.foldLeft(0) { (acc: Int, i: Int) =>
      acc + (andrea(i) - maria(i))
    }

    val mariaSum = indices.foldLeft(0) { (acc: Int, i: Int) =>
      acc + (maria(i) - andrea(i))
    }

    if (andreaSum == mariaSum) "Tie" else if (andreaSum > mariaSum) "Andrea" else "Maria"
  }
}
