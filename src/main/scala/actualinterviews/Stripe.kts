package actualinterviews


/**
 * # Step 1
 * Throughout this interview, we'll pretend we're building a new analytical
 * database. Don't worry about actually building a database though -- these will
 * all be toy problems.
 *
 * Here's how the database works: all records are represented as maps, with string
 * keys and integer values. The records are contained in an array, in no
 * particular order.
 *
 * To begin with, the database will support just one function: min_by_key. This
 * function scans the array of records and returns the record that has the minimum
 * value for a specified key. Records that do not contain the specified key are
 * considered to have value 0 for the key. Note that keys may map to negative values!
 *
 * Here's an example use case: each of your records contains data about a school
 * student. You can use min_by_key to answer questions such as "who is the youngest
 * student?" and "who is the student with the lowest grade-point average?"
 *
 * Implementation notes:
 * * You should handle an empty array of records in an idiomatic way in your
 *   language of choice.
 * * If several records share the same minimum value for the chosen key, you
 *   may return any of them.
 *
 * ### Java function signature:
 * ```
 * public static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records);
 * ```
 *
 * ### Examples (in Python):
 * ```
 * assert min_by_key("a", [{"a": 1, "b": 2}, {"a": 2}]) == {"a": 1, "b": 2}
 * assert min_by_key("a", [{"a": 2}, {"a": 1, "b": 2}]) == {"a": 1, "b": 2}
 * assert min_by_key("b", [{"a": 1, "b": 2}, {"a": 2}]) == {"a": 2}
 * assert min_by_key("a", [{}]) == {}
 * assert min_by_key("b", [{"a": -1}, {"b": -1}]) == {"b": -1}
 * ```
 */
fun minByKey(key: String, records: List<Map<String, Int>>): Map<String, Int> {
    return firstByKey(key, "asc", records)
}

fun testMinByKey() {
    println("minByKey")
    assert(mapOf("a" to 1, "b" to 2) == minByKey("a", arrayListOf(
            mapOf("a" to 1, "b" to 2),
            mapOf("a" to 2)
    )))
    assert(mapOf("a" to 1, "b" to 2) == minByKey("a", arrayListOf(
            mapOf("a" to 2),
            mapOf("a" to 1, "b" to 2)

    )))
    assert(mapOf("a" to 2) == minByKey("b", arrayListOf(
            mapOf("a" to 1, "b" to 2),
            mapOf("a" to 2)
    )))
    assert(mapOf<String, Int>() == minByKey("a", arrayListOf(mapOf())))
    assert(mapOf("b" to -1) == minByKey("b", arrayListOf(
            mapOf("a" to -1),
            mapOf("b" to -1)
    )))
    println("all assertions passed, woohoo!")
}

/**
 * # Step 2
 * Our next step in database development is to add a new function. We'll call this
 * function first_by_key. It has much in common with min_by_key.  first_by_key
 * takes three arguments:
 *
 * 1. a string key
 * 2. a string sort direction (which must be either "asc" or "desc")
 * 3. an array of records, just as in min_by_key.
 *
 * If the sort direction is "asc", then we should return the minimum record,
 * otherwise we should return the maximum record. As before, records without a
 * value for the key should be treated as having value 0.
 *
 * Once you have a working solution, you should re-implement min_by_key in terms
 * of first_by_key .
 *
 * ### Java function signature:
 * ```
 * public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records);
 * ```
 *
 * ### Examples (in Python):
 * ```
 * assert first_by_key("a", "asc", [{"a": 1}]) == {"a": 1}
 *
 * assert first_by_key("a", "asc", [{"b": 1}, {"b": -2}, {"a": 10}]) in [{"b": 1}, {"b": -2}]
 * assert first_by_key("a", "desc", [{"b": 1}, {"b": -2}, {"a": 10}]) == {"a": 10}
 * assert first_by_key("b", "asc", [{"b": 1}, {"b": -2}, {"a": 10}]) == {"b": -2}
 * assert first_by_key("b", "desc", [{"b": 1}, {"b": -2}, {"a": 10}]) == {"b": 1}
 *
 * assert first_by_key("a", "desc", [{}, {"a": 10, "b": -10}, {}, {"a": 3, "c": 3}]) == {"a": 10, "b": -10}
 * ```
 */

fun firstByKey(key: String, direction: String, records: List<Map<String, Int>>): Map<String, Int> {

//
//    fun compare(record: Map<String, Int>, key: String, cmpRecord: Map<String, Int>, direction: String = "asc") =
//            when (direction) { // if asc, find minimum key; if desc, find maximum key
//                // if key is not in record, treat it as 0
//                "asc" -> record.getOrDefault(key, 0) < cmpRecord.getOrDefault(key, 0)
//                "desc" -> record.getOrDefault(key, 0) > cmpRecord.getOrDefault(key, 0)
//                else -> throw IllegalArgumentException("invalid direction")
//            }


    var cmpRecord = mapOf<String, Int>()
    // search each record for key
    records.forEach { record ->
        val comparator = RecordComparator(key, direction)
        if (comparator.compare(record, cmpRecord) == -1) {
            cmpRecord = record
        }
    }

    // return record containing min key
    return cmpRecord

}

fun testFirstByKey() {
    println("firstByKey")
    assert(mapOf("a" to 1) == firstByKey("a", "asc", arrayListOf(
            mapOf("a" to 1)
    )))
    assert(arrayListOf(
            mapOf("b" to 1),
            mapOf("b" to -2)
    ).contains(firstByKey("a", "asc", arrayListOf(
            mapOf("b" to 1),
            mapOf("b" to -2),
            mapOf("a" to 10)
    ))))
    assert(mapOf("a" to 10) == firstByKey("a", "desc", arrayListOf(
            mapOf("b" to 1),
            mapOf("b" to -2),
            mapOf("a" to 10)
    )))
    assert(mapOf("b" to -2) == firstByKey("b", "asc", arrayListOf(
            mapOf("b" to 1),
            mapOf("b" to -2),
            mapOf("a" to 10)
    )))
    assert(mapOf("b" to 1) == firstByKey("b", "desc", arrayListOf(
            mapOf("b" to 1),
            mapOf("b" to -2),
            mapOf("a" to 10)
    )))
    assert(mapOf("a" to 10, "b" to -10) == firstByKey("a", "desc", arrayListOf(
            mapOf(),
            mapOf("a" to 10, "b" to -10),
            mapOf(),
            mapOf("a" to 3, "c" to 3)
    )))
}

/**
 * # Step 3
 * As we build increasingly rich orderings for our records, we'll find it useful
 * to extract the comparison of records into a comparator. This is a function or
 * object (depending on your language) which determines if a record is
 * "less than", equal, or "greater than" another.
 *
 * In object-oriented languages, you should write a class whose constructor
 * accepts two parameters: a string key and a string direction. The class should
 * implement a method compare that takes as its parameters two records. This
 * method should return -1 if the first record comes before the second record
 * (according to key and direction), zero if neither record comes before the
 * other, or 1 if the first record comes after the second.
 *
 * In functional languages, you should write a function which accepts two
 * parameters: a string key and a string direction. The function should return
 * a function that takes as its parameters two records. This function should return
 * -1 if the first record comes before the second record (according to key and
 * direction), zero if neither record comes before the other, or 1 if the first
 * record comes after the second.
 *
 * You should then use your comparator in your implementation of first_by_key.
 *
 * ### Java skeleton class:
 * ```
 * class RecordComparator implements Comparator<Map<String, Integer>> {
 * public RecordComparator(String key, String direction) {
 * }
 *
 * public int compare(Map<String>, Integer> left, Map<String, Integer> right) {
 * return 0;
 * }
 * }
 * ```
 *
 * ### Examples (in Python):
 * ```
 * cmp = Comparator("a", "asc")
 * assert cmp.compare({"a": 1}, {"a": 2}) == -1
 * assert cmp.compare({"a": 2}, {"a": 1}) == 1
 * assert cmp.compare({"a": 1}, {"a": 1}) == 0
 * ```
 */
class RecordComparator(private val key: String, private val direction: String) : Comparator<Map<String, Int>> {
    override fun compare(left: Map<String, Int>, right: Map<String, Int>): Int =
            when (direction) {
                "asc" -> when {
                    left.getOrDefault(key, 0) < right.getOrDefault(key, 0) -> -1
                    left.getOrDefault(key, 0) == right.getOrDefault(key, 0) -> 0
                    else -> 1
                }
                "desc" -> when {
                    left.getOrDefault(key, 0) > right.getOrDefault(key, 0) -> -1
                    left.getOrDefault(key, 0) == right.getOrDefault(key, 0) -> 0
                    else -> 1
                }
                else -> throw IllegalArgumentException("invalid direction")
            }

}

fun testRecordComparator() {
    println("RecordComparator")
    val cmp = RecordComparator("a", "asc")
    assert(-1 == cmp.compare(mapOf("a" to 1), mapOf("a" to 2)))
    assert(1 == cmp.compare(mapOf("a" to 2), mapOf("a" to 1)))
    assert(0 == cmp.compare(mapOf("a" to 1), mapOf("a" to 1)))
    assert(1 == cmp.compare(mapOf("a" to 1), mapOf()))
    assert(0 == cmp.compare(mapOf("a" to 0), mapOf()))
    assert(0 == cmp.compare(mapOf(), mapOf()))
}

/**
 * # Step 4
 *
 * Time to take this "first-by" functionality further, to sort by more than one
 * key at a time.
 *
 * Consider an array of records like this one:
 * ```
 * [{"a": 1, "b": 1}, {"a": 1, "b": 2}, {"a": 2, "b": 1}, {"a": 2, "b": 2}]
 * ```
 *
 * Using first_by_key with this array of records with key "a" might not give us as
 * much control as we'd like over the result, since more than one record has the
 * same value for "a" (similarly for "b"). More generally, we might say "order by
 * the first key, in the first direction. Break ties according to the second key,
 * in the second direction. Break remaining ties by the third key, in the third
 * direction, and so on." Note that the sort direction for different keys need not
 * be the same.
 *
 * We might represent this ordering with a list of pairs like
 * ```
 * [
 * ("a", "asc"),
 * ("b", "asc"),
 * ("c", "desc"),
 * ]
 * ```
 *
 * We'll call this type of representation a sort_order.
 *
 * You'll need to write a function first_by_sort_order. It takes two arguments:
 *
 * * a sort_order
 * * an array of records
 *
 * It returns the first record according to the given sort_order.
 *
 * As before, we'll ask that you re-implement your previous functionality
 * (first_by_key) in terms of first_by_sort_order.
 *
 * Hint: can you construct a "sort order" comparator using your comparator from
 * the previous step? How might constructing a sort order comparator be helpful?
 *
 * ### Java function signature:
 * ```
 * public static Map<String></String>, Integer> firstBySortOrder(LinkedHashMap<String></String>, String> sortOrder, List<Map></Map><String></String>, Integer>> records);
 * ```
 *
 * ### Examples (in Python):
 * ```
 * assert(
 * first_by_sort_order(
 * [("a", "desc")],
 * [{"a": 5.0}, {"a": 6.0}],
 * ) == {"a": 6.0}
 * )
 *
 * assert(
 * first_by_sort_order(
 * [("b", "asc"), ("a", "asc")],
 * [{"a": -5, "b": 10}, {"a": -4, "b": 9}],
 * ) == {"a": -4, "b": 9}
 * )
 *
 * assert(
 * first_by_sort_order(
 * [("b", "asc"), ("a", "asc")],
 * [{"a": -5, "b": 10}, {"a": -4, "b": 10}],
 * ) == {"a": -5, "b": 10}
 * )
 * ```
 */
fun firstBySortOrder(sortOrder: LinkedHashMap<String, String>, records: List<Map<String, Int>>): Map<String, Int> {

    var cmpRecord = mapOf<String, Int>()

    val comparators = sortOrder.map { (key, direction) -> RecordComparator(key, direction) }
    // search each record for key
    records.forEach { record ->
        for (comparator in comparators) {
            if (comparator.compare(record, cmpRecord) == -1) {
                cmpRecord = record
                break
            } else if (comparator.compare(record, cmpRecord) == 1) {
                break
            }
        }
    }

    // return record containing min key
    return cmpRecord
}

fun testFirstBySortOrder() {
    println("firstBySortOrder")
    assert(mapOf("a" to 6) == firstBySortOrder(linkedMapOf("a" to "desc"), arrayListOf(
            mapOf("a" to 5),
            mapOf("a" to 6)
    )))
    assert(
            mapOf("a" to -5, "b" to 10) == firstBySortOrder(linkedMapOf("b" to "asc", "a" to "asc"), arrayListOf(
                    mapOf("a" to -5, "b" to 10),
                    mapOf("a" to -4, "b" to 10)
            ))
    )
    assert(
            mapOf("a" to -4, "b" to 10) == firstBySortOrder(linkedMapOf("a" to "desc", "b" to "asc"), arrayListOf(
                    mapOf("a" to -5, "b" to 10),
                    mapOf("a" to -4, "b" to 10)
            ))
    )
}

fun main() {
    testMinByKey()
    testFirstByKey()
    testRecordComparator()
    testFirstBySortOrder()
}
main()
