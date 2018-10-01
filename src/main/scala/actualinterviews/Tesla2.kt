package actualinterviews


fun main(args: Array<String>) {
    println(isAnagram("Clint Eastwood", "Old West action!"))
    println(isAnagram("Electric Rules!", "Gas drools"))
    println(isAnagram("", ""))
}

fun isAnagram(string1: String, string2: String): Boolean {
    val filteredstring1 = string1.filter { it.isLetter() }.map { it.toLowerCase() }
    val filteredstring2 = string2.filter { it.isLetter() }.map { it.toLowerCase() }
    if (filteredstring1.size != filteredstring2.size) return false

    val sorted1 = filteredstring1.sorted().toCharArray()
    val sorted2 = filteredstring2.sorted().toCharArray()

    return sorted1 contentEquals sorted2
}
