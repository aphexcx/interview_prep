package InterviewBit.strings

object LengthOfLastWord extends App {

  /* https://www.interviewbit.com/problems/length-of-last-word/

  Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
  return the length of last word in the string.

  If the last word does not exist, return 0.
  */
  def lengthOfLastWord(A: String): Int = {
    if (A.split(' ').isEmpty) 0 else
      A.split(' ').last.length
  }
}
