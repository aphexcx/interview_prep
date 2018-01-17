package course.challenges.week1

import scala.collection.mutable.ArrayBuffer

object Primes extends App {

  def primes: Int => Array[Int] = {
    case 1 => Array()

    case 2 => Array(2)

    case n: Int =>
      val PRIMES: ArrayBuffer[Int] = ArrayBuffer(2)

      (3 to n).foreach { i =>
        if (PRIMES.forall { prime => i % prime > 0 } == true)
          PRIMES.append(i)
      }
      // For each number 1 to n:
      // check if it's divisble by any of the numbers in PRIMES
      // if it is, it's not prime
      // if it's not, it's prime, and add it to PRIMES
      PRIMES.toArray
  }

}
