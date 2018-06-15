package actualinterviews

/**

// Networking call
fun getBirds(): Observable<List<Bird>>


button.clicks()
//.debounce(250)
.filter{ activity.isLoading }
.flatMap( getBirds())
.doOnTerminate( isLoading = false )



zipcode length of 10

1234567890
0000000000

`zipcode.txt`
100,000

zipcodes
.filter { it.startsWith(input) }


trie

6414
6424
digit
O(memory)

1
/ |\
1 2 3
/|\/|\

6
|
4
/ \
1   2
|   |
4   4



d = []
f = [ 'f' ]
s = ['c', 'o', 'w']
v = ['c', 'a', 't', 's']
s a t c
s t a c



123 -> 123 % 10 = 3
(123 / 10) % 10 = 2
(123 / 10) / 10 ) % 10 = 1

103 -> 301
1 -> 1
-92 -> -29

// O(1) memory
fun reverse(int: Int): Int {
var newInt: Int = 0
var columns: Int = int.log10()

while(int != 0) {
var digit = int % 10
newInt += digit * 10.pow(columns)
int = int / 10
columns--
}
}


fun reverse(s: Array<Char>) {
if (s.size <= 1) {
return s
}

var left = 0
var right = s.size - 1

while(left < right) {
s.swap(left, right)
left++
right--
}
}

fun Array<Char>.swap(left

var temp = s[left]
s[left] = s[right]
s[right] = temp
 **/