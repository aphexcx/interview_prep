package InterviewBit

import scala.collection.immutable.HashMap

/** Given a roman numeral, convert it to an integer.
  * Input is guaranteed to be within the range from 1 to 3999.
  *
  * Input: "XIV"
  * Return: 14
  *
  * Input : "XX"
  * Output : 20
  */
object RomanToInteger extends App {

  val NUMERALS: HashMap[Char, Int] = HashMap(
    'M' -> 1000,
    'D' -> 500,
    'C' -> 100,
    'L' -> 50,
    'X' -> 10,
    'V' -> 5,
    'I' -> 1
  )

  def romanToInt(A: String): Int = {
    A.foldRight(0) { (cur: Char, acc: Int) =>
      val n: Int = NUMERALS.getOrElse(cur, 0)
      if (5 * n <= acc) {
        acc - n
      } else {
        acc + n
      }
    }
  }

  //  println(romanToInt("XIV")) // 14
  //  println(romanToInt("MXCIII")) //1093
  println(romanToInt("MDCCCIV")) // 1804
}
