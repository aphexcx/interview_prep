
object Checkpoint2 extends App {

  def prettyPrint(A: Int): Array[Array[Int]] = {
    val dim: Int = 2 * A - 1
    val midpoint: Int = (dim + 1) / 2 - 1
    var output: Array[Array[Int]] = Array()

    for (rownum <- 0 until dim) {
      var newrow: Array[Int] = Array()

      for (column <- 0 until dim) {
        newrow = newrow :+ Math.max(Math.abs(rownum - midpoint), Math.abs(column - midpoint)) + 1
      }

      output = output :+ newrow
    }
    output
  }

}
