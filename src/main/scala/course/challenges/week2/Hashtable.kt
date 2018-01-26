package course.challenges.week2

// get put remove size clear isEmpty

/*
Interview Question 2 - Implement a Hashtable
Implement a simple hashtable without using any special collections classes
or helpers (you can use native Java arrays).
Your implementation should minimally meet the following requirements:

Support generics for both key and value types
Implement the standard get, put, remove, size, clear,
and isEmpty operations as defined in java.util.Map
Support an initial default capacity of 16 entries
Support dynamic allocation of additional capacity as needed

*/
class HashTable<K : Any, V : Any> {
    private var capacity = 16
    private var size = 0


    private var values: Array<Any?> = kotlin.arrayOfNulls(capacity)
    private var keys: Array<Any?> = arrayOfNulls(capacity)


    fun get(key: K): V? = values[key.position()] as V?

    fun put(key: K, value: V) {
        if (isFull()) increaseSize()

        keys[key.position()] = key
        values[key.position()] = value

        size += 1
    }

    fun remove(key: K) {
        keys[key.position()] = null
        values[key.position()] = null
        size -= 1
    }

    fun clear() {
        capacity = 16
        values = arrayOfNulls(capacity)
        keys = arrayOfNulls(capacity)
        size = 0
    }

    fun isEmpty(): Boolean = size == 0

    private fun K.position(): Int = this.hashCode() % capacity

    private fun isFull(): Boolean = size == capacity

    private fun increaseSize() {
        capacity *= 2

        val newKeys: Array<Any?> = arrayOfNulls(capacity)
        val newValues: Array<Any?> = arrayOfNulls(capacity)

        for (i in keys.indices) {
            val key = keys[i] as K
            val value = values[i] as V?

            newKeys[key.position()] = key
            newValues[key.position()] = value
        }

        keys = newKeys
        values = newValues
    }

}
