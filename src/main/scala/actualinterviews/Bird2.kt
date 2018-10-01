package actualinterviews

/*

12:35 pm
Jul 24th

1
fun main(vararg args: String) {
    2
    println("Hello")
    3
}
4
​
5
​
6
/*
7
Your last C/C++ code is saved below:
8
nclude <iostream>
9
using namespace std;
10
​
11
int main() {
12
  cout<<"Hello";
13

14

15
0123456789001234
16
​
17
0000 = 1
18
00001 = 2
19
000012 = 3
20
0000123
21

22
0000000100020003
23
0000
24
​
25
  0000
26
0001  0011 0111 1111
27

28

29

30
0000
31

32

33

34
 */
35
​
36
fun allBankCodes(): String {
    37
    value sb: StringBuilder = StringBuilder()
    38
    for (i in 0..9999) {
        39
        sb.add("%4d".format(i))
        40
    }
    41

    42
    value naiveString = sb.toString()
    43

    44
    value seen: MutableSet<String> = MutableSet()
    45

    46
    value overlappingCodes: StringBuilder = StringBuilder()
    47

    48
    naiveString.sliding(4).forEach {
        49
        // check if it's in the set
        50
        if (!seen.exists(it)) {
            51
            seen.add(it)
            52
            //check for overlap
            53
            whichChars()
            54
            overlappingCodes.add(it)
            55
        }
        56

        57
    }
    58

    59
}

Loading Playback
*/