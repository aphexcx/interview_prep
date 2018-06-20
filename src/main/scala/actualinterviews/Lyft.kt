package actualinterviews

// To execute Kotlin code, please define a top level function named main


/**
 * Implement a least recently used (LRU) cache
 * with a single array list for the back store
 *
 * An LRU cache discards the least recently used (get or set) item
 * when the capacity of the cache is exceeded
 *
 * In order of importance:
 * 1. Code completeness
 * 2. Unit test coverage
 * 3. Code cleanliness
 * ...
 * N/2. Performance
 * ...
 * N. Trivial edge cases like null checks
 *
 * Example:
 * capacity = 2
 *
 * cache.put("a", "1");
 * cache.put("b", "2");
 *
 * cache.get("a")?.equals("1") == true;
 * cache.get("b")?.equals("2") == true;
 *
 * cache.put("a", "1");
 * cache.put("b", "2");
 * cache.put("c", "3");
 * cache.get("a") == null;
 */
class LruCache<K, V>(val capacity: Int) : Cache<K, V> {
    var storage = mutableListOf<Pair<K, V>>()


    override fun put(key: K, value: V) {
        if (storage.size == capacity) {
            // evict the oldest (first) element
            val c: MutableList<Pair<K, V>> = storage.drop(1).toMutableList()
            storage = c
        }

        find(key)?.let {
            storage.remove(it)
        }

        storage.add(key to value)
    }

    fun find(key: K): Pair<K, V>? {
        return storage.find { it.first == key }
    }

    override fun get(key: K): V? {
        return find(key)?.also {
            storage.remove(it)
            storage.add(it)
        }?.second
    }

}

interface Cache<K, V> {

    fun put(key: K, value: V)

    fun get(key: K): V?
}

fun main(args: Array<String>) {
    val cache = LruCache<String, String>(2)

    cache.put("a", "1");
    cache.put("b", "2");
    print(cache.get("a")?.equals("1") == true)
    print(cache.get("b")?.equals("2") == true)

    cache.put("a", "1");
    cache.put("b", "2");
    cache.get("a")
    cache.put("c", "3");
    print(cache.get("a") == null)


}
