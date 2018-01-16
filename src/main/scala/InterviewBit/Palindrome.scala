package InterviewBit

object Palindrome extends App {
  def isPalindrome(A: String): Int = {
    val filtered = A.filter(_.isLetterOrDigit).map(_.toLower)

    if (filtered == filtered.reverse) 1 else 0
  }
}
