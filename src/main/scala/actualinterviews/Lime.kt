package actualinterviews

/*
 You are given two parallel lines Y = 0 and Y = Width in a 2-D coordinate system where X axis is the horizontal axis and Y axis is the vertical axis
The input will be the Width and  a list of circles with center coordinates (x,y) and radius r. Your function should return a Boolean which indicate if there exist a path bounded by the two parallel lines and goes from x = -infinity to x = infinity without touching any of the circles.
Example images:
https://imgur.com/a/T7UgC   T
https://imgur.com/7NHvITe   F
https://imgur.com/a/Jj540    F
https://imgur.com/a/DtQum  T
Test cases
Width are all 50 for the following test cases
(10,10, 30), (25,25, 20)   T
 (10,10, 30),  (25,25, 20), (35,45, 10)  F
(10,10, 30), (25,25, 20), (70,10, 15), (70,20, 15), (80,35, 20)  F
(10,10, 30), (25,25, 20), (70,20, 15), (80,35, 20)  T
(x1-x2)^2 + (y1-y2)^2 <= (r1+r2)
*/
fun doesPathExist(circles: List<Circle>): Boolean {
    // Start at the bottom (y = 0) and check which circle overlaps with the 0 line. If there's more than one of these circles, process them one at a time.
    // For each 0-line overlapping circle, check if there's another overlapping circle.
    // Then for that circle, check if there's another overlapping circle, and so on, until either there are no more overlapping circles (return true) or you overlap with the 50 line (return false).
    // Return true if this algorithm returns true for all 0-line overlapping circles.

    return circles.filter { it.crossesY(0) }.map { startingCircle ->
        println(startingCircle)
        fun isThereRoomBefore50(circle: Circle, visitedCircles: Set<Circle>): Boolean {
            if (circle.crossesY(50)) {
                return false
            }
            circles.filterNot { it in visitedCircles }.forEach {
                if (it.overlaps(circle)) {
                    return isThereRoomBefore50(it, visitedCircles + it)
                }
            }
            return true
        }
        isThereRoomBefore50(startingCircle, mutableSetOf())
    }.all { it } // if true for all startingCircles, then return true

}

data class Circle(val x: Int, val y: Int, val radius: Int) {
    fun overlaps(otherCircle: Circle): Boolean {
        return distance(otherCircle) <= (radius + otherCircle.radius)
    }

    private fun distance(otherCircle: Circle): Double {
        return Math.sqrt(Math.pow((x - otherCircle.x).toDouble(), 2.0) + Math.pow((y - otherCircle.y).toDouble(), 2.0))
    }

    // 40,40,20 -- check if it crosses at 50
    // 0, -10, 5 -- check if it crosses 0
    fun crossesY(yLine: Int): Boolean {
        return y + radius >= yLine && y - radius <= yLine
    }
}

fun main(args: Array<String>) {
    // true
    println(doesPathExist(listOf(Circle(10, 10, 30), Circle(25, 25, 20))))

    // false
    println(doesPathExist(listOf(
            Circle(10, 10, 30),
            Circle(25, 25, 20),
            Circle(35, 45, 10)
    )))

    // false
    println(doesPathExist(listOf(
            Circle(10, 10, 30),
            Circle(25, 25, 20),
            Circle(70, 10, 15),
            Circle(70, 20, 15),
            Circle(80, 35, 20)
    )))

    // true
    println(doesPathExist(listOf(
            Circle(10, 10, 30),
            Circle(25, 25, 20),
            Circle(70, 20, 15),
            Circle(80, 35, 20)
    )))

}

