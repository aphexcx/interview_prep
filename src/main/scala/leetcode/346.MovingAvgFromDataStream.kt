package leetcode

import java.lang.Double.min
import java.util.*
import java.util.concurrent.ArrayBlockingQueue

/** 346. Moving Average from Data Stream
Easy

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

 **/

class MovingAverage(val size: Int) {

    /** Initialize your data structure here. */
    val window: Queue<Int> = ArrayBlockingQueue(size)

    fun next(`val`: Int): Double {
        if (window.size == size) {
            window.remove()
        }
        window.add(`val`)
        return window.average()
    }

}

class MovingAverageDeque(val size: Int) {

    /** Initialize your data structure here. */
    val window: Queue<Int> = ArrayDeque(size)
    var currentSum = 0

    fun next(`val`: Int): Double {
        if (window.size == size) {
            currentSum -= window.remove()
        }
        window.add(`val`)
        currentSum += `val`
        return currentSum / window.size.toDouble()
    }

}

class MovingAverageCircularQueue(val size: Int) {

    /** Initialize your data structure here. */
    val window: IntArray = IntArray(size)
    var currentSum = 0
    var head = 0
    val tail: Int
        get() = (head + 1) % size

    var itemCount = 0

    fun next(`val`: Int): Double {
        currentSum = currentSum - window[tail] + `val`
        head = tail
        window[head] = `val`
        itemCount += 1

        return currentSum / min(window.size.toDouble(), itemCount.toDouble())
    }

}


/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = MovingAverage(size)
 * var param_1 = obj.next(`val`)
 */
