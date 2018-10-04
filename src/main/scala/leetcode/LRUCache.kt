package leetcode

/** Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */
class LRUCache(val capacity: Int) {
    val storage = hashMapOf<Int, Int>()
    val timestamps = hashMapOf<Int, Long>()
    fun get(key: Int): Int {
        return storage[key]?.also {
            timestamps[key] = System.currentTimeMillis()
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        if (storage.size == capacity) {
            // evict oldest item
            timestamps.asSequence().sortedBy { it.value }.first().key.also {
                storage.remove(it)
                timestamps.remove(it)
            }
        }
        storage[key] = value
        timestamps[key] = System.currentTimeMillis()
    }

    override fun toString(): String {
        return "$storage\n$timestamps"
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

fun main(args: Array<String>) {
    var cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache)
    println(cache.get(1))       // returns 1
    cache.put(3, 3)    // evicts key 2
    println(cache)
    println(cache.get(2))       // returns -1 (not found)
    cache.put(4, 4)    // evicts key 1
    println(cache)
    println(cache.get(1))       // returns -1 (not found)
    println(cache.get(3))       // returns 3
    println(cache.get(4))       // returns 4

    /** ["LRUCache","put","put","get","put","get","put","get","get","get"]
    [[2],       [1,1],[2,2],[1],  [3,3],[2],  [4,4],[1],  [3],  [4]]
     */
}