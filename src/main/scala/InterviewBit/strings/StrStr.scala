package InterviewBit.strings

object StrStr extends App {

  /* Implement strStr().

   strstr - locate a substring ( needle ) in a string ( haystack ).

  Try not to use standard library string functions for this question.

  Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

  def strStr(A: String, B: String): Int = {
    if (A.contains(B)) {
      A.indexOf(B)
    } else -1
  }

}
