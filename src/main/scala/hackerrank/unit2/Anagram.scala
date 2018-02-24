package hackerrank.unit2

import scala.collection.mutable.ArrayBuffer

/**
  *
  */
object Anagram extends App {

  def mmain(args: Array[String]) {
    //Enter your code here. Read input from STDIN. Print output to STDOUT
    val cases: Array[String] = args(0)
      .split('\n')
      .filter(!_.isEmpty)
      .tail
    println(args.mkString)


    cases.foreach { c =>
      if (c.length % 2 == 1) {
        println("-1")
      } else {
        val (a, b) = c.splitAt(c.length / 2)

        val bsorted = b.sorted

        var charCount: ArrayBuffer[Int] = ArrayBuffer.fill(256)(0)
        for (i <- 0 until a.length) {
          charCount(a.charAt(i)) += 1
          //          charCount.update(c, charCount(c) + 1)
        }

        for (i <- 0 until a.length) {
          charCount(b.charAt(i)) -= 1
          //          charCount.update(c, charCount(c) - 1)
        }

        var numCharsNeedToReplace = 0
        for (i <- charCount.indices) {
          if (charCount(i) != 0)
            numCharsNeedToReplace += 1
        }
        println(numCharsNeedToReplace)
      }

      //        @tailrec def go(a: String, b: String, i: Int) = {
      //          if (a.isEmpty)
      //            i
      //          else if (a.head == b.head) {
      //            go(a.tail, b.tail, i)
      //          } else {
      //            go(a.tail, b.tail, i + 1)
      //          }
      //        }
      //
      //        val numCharsNeedToReplace = go(a.sorted, b.sorted, 0)
      //        println(numCharsNeedToReplace)
      //      }
    }


  }

  //abbcabbe
  //  aaabbb
  //  ab
  //  abc
  //  mnop
  //  xyyx
  val tc =
  """10
hhpddlnnsjfoyxpciioigvjqzfbpllssuj
xulkowreuowzxgnhmiqekxhzistdocbnyozmnqthhpievvlj
dnqaurlplofnrtmh
aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqrasqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb
lbafwuoawkxydlfcbjjtxpzpchzrvbtievqbpedlqbktorypcjkzzkodrpvosqzxmpad
drngbjuuhmwqwxrinxccsqxkpwygwcdbtriwaesjsobrntzaqbe
ubulzt
vxxzsqjqsnibgydzlyynqcrayvwjurfsqfrivayopgrxewwruvemzy
xtnipeqhxvafqaggqoanvwkmthtfirwhmjrbphlmeluvoa
gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvznspiwquxxsiwuldizqkkaawpyyisnftdzklwagv"""

  mmain(Array(tc))
}
