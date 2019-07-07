package actualinterviews

/**
 * Determine if any 3 integers in an array sum to 0.
 * -1, 0, 1 -> True
 * -2, 2, 1 -> False
 * 1, 1, -2, 2, 0 -> True
 *  -2, 0, 1, 1, 2
 */
fun sumToZero(numbers: IntArray): Boolean {
    // compute sums of every possible pair
    val sums: HashMap<Int, MutableSet<Pair<Int, Int>>> = hashMapOf()
    for (i in numbers.indices) {
        for (j in i + 1..numbers.lastIndex) {
            val sum = numbers[i] + numbers[j]
            if (sum !in sums) {
                sums[sum] = mutableSetOf()
            }
            sums[sum]!!.add(i to j)
        }
    }

    // for each pair, add it to each number in the array (pay attention to indices used to compute each pair because we can't reuse indices)
    // sums.forEach { (sum, index)
    for (i in numbers.indices) {
        val sumWeNeed = 0 - numbers[i]
        val validPairs = sums[sumWeNeed]?.filter { it.first != i && it.second != i }
        if (validPairs?.isNotEmpty() == true) {
            return true
        }
    }
    return false
    // }
}

/**
first querstion text brackets the ony area thwat he noted that you had a bit of trouble with th final bracket
by not handling the null and you were able to correct on your own
he felt like you tok a bit too long

3sum you initially chose to cache the pairs rather than just lists which was a little more complex.
you can cache the pairs in a hashmap T
there was a bit of a hiccup to iterate of an array to generate uniqe pairs and you eventually realized iand corrected it,

 */

fun calculateTaxes(income: Int, brackets: List<Pair<Int?, Double>>): Float {
    var remainingIncome = income
    var totalTax = 0.0

    for (bracket in brackets) {
        val bracketSize = bracket.first
        val taxRate = bracket.second
        // subtract bracket from income and add the tax to the total tax
        if (bracketSize == null || remainingIncome <= bracketSize) {
            totalTax += remainingIncome * taxRate
            break
        }
        remainingIncome -= bracketSize
        totalTax += bracketSize * taxRate
    }

    return totalTax.toFloat()
}

assert(calculateTaxes(1000, listOf(
        null to 0.4
)) == 400f)

assert(calculateTaxes(4000, listOf(
        10000 to 0.1,
        20000 to 0.2,
        10000 to 0.3,
        null to 0.4
)) == 400f)

assert(calculateTaxes(10000, listOf(
        10000 to 0.1,
        20000 to 0.2,
        10000 to 0.3,
        null to 0.4
)) == 1000f)

assert(calculateTaxes(20000, listOf(
        10000 to 0.1,
        20000 to 0.2,
        10000 to 0.3,
        null to 0.4
)) == 3000f)


assert(calculateTaxes(30000, listOf(
        10000 to 0.1,
        20000 to 0.2,
        10000 to 0.3,
        null to 0.4
)) == 5000f)


assert(calculateTaxes(40000, listOf(
        10000 to 0.1,
        20000 to 0.2,
        10000 to 0.3,
        null to 0.4
)) == 8000f)


assert(calculateTaxes(50000, listOf(
        10000 to 0.1,
        20000 to 0.2,
        10000 to 0.3,
        null to 0.4
)) == 12000f)
