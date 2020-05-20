package leetcode

import java.util.*

fun dailyTemperatures(T: IntArray): IntArray {
    var result = IntArray(T.size)
    // for each day, hop forward until I see a temperature greater than the current day
    // write # hops into that index in result array, otherwise 0
    for (i in T.indices) {
        val currentTemp = T[i]
        var hops = 1
        while (true) {
            if (i + hops > T.lastIndex) {
                result[i] = 0
                break
            }
            if (T[i + hops] > currentTemp) {
                result[i] = hops
                break
            }
            hops += 1
        }
    }

    return result
}


fun dailyTemperaturesStack(T: IntArray): IntArray? {
    val ans = IntArray(T.size)
    val stack: Stack<Int> = Stack()
    for (i in T.indices.reversed()) {
        while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
            stack.pop()
        }
        if (stack.isEmpty())
            ans[i] = 0
        else
            ans[i] = stack.peek() - i
        stack.push(i)
    }
    return ans
}

fun dailyTemperaturesStackForwards(T: IntArray): IntArray? {
    val result = IntArray(T.size)
    val stack: Stack<Int> = Stack() // Make it a stack of indices.

    for (i in T.indices) {
        while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
            val index = stack.pop()
            result[index] = i - index
        }
        stack.push(i)
    }
    return result
}

fun main(args: Array<String>) {

    dailyTemperaturesStack(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
}
