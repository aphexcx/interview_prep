package hackerrank.airbnb


/*
 * Complete the 'doesCircleExist' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts STRING_ARRAY commands as parameter.
 */
enum class Direction {
    N, W, S, E;
}

class Robot(
        val cmdSequence: List<Char>,
        var currentPosition: IntArray = intArrayOf(0, 0),
        var currentHeading: Direction = Direction.E
) {
    var currentCmd = 0
    var visited: MutableSet<IntArray> = mutableSetOf(currentPosition)
    var retread = false

    fun reset() {
        currentPosition = intArrayOf(0, 0)
        currentHeading = Direction.E
    }


    fun processCommand() {
        when (nextCmd()) {
            'G' -> {
                // move forward 1 step
                moveForward()
            }
            'L' -> {
                // turn left in place
                turnLeft()
            }
            'R' -> {
                // turn right in place
                turnRight()
            }
        }
    }

    var cycles: Int = 0

    private fun nextCmd(): Char {
        return cmdSequence[currentCmd].also {
            currentCmd += 1
            if (currentCmd == cmdSequence.size) {
                cycles += 1
                currentCmd = 0
            }
        }
    }

    fun turnLeft() {
        currentHeading = when (currentHeading) {
            Direction.N -> Direction.W
            Direction.W -> Direction.S
            Direction.S -> Direction.E
            Direction.E -> Direction.N
        }
    }

    fun turnRight() {
        currentHeading = when (currentHeading) {
            Direction.N -> Direction.E
            Direction.W -> Direction.N
            Direction.S -> Direction.W
            Direction.E -> Direction.S
        }
    }

    fun moveForward() {
        when (currentHeading) {
            Direction.N -> currentPosition[1] += 1
            Direction.W -> currentPosition[0] -= 1
            Direction.S -> currentPosition[1] -= 1
            Direction.E -> currentPosition[0] += 1
        }
        if (currentPosition in visited) {
            retread = true
        }
        visited.add(currentPosition)
    }
}

// have two robots, a slow robot and a fast robot,
// slow robot processes one command, fast rob ot processes two commands per turn
// if they meet then there's a circle in the cmd sequence

fun doesCircleExist(commands: Array<String>): Array<String> {
    // Write your code here
    // for each command sequence
    // process command sequence
    // for each command in sequence
    // process command

    val result = commands.map {
        if (processCmdSequence(it.toList())) "YES" else "NO"
    }

    return result.toTypedArray()

}
//RGRGRGRG

fun processCmdSequence(cmdSequence: List<Char>): Boolean {
    val fastRobot = Robot(cmdSequence)
    val slowRobot = Robot(cmdSequence)

    slowRobot.reset()
//    fastRobot.reset()
    cmdSequence.forEach {
        slowRobot.processCommand()
//        if (slowRobot.currentPosition contentEquals intArrayOf(0,0)){
//            return true
//        }
    }
    when {
        slowRobot.currentPosition contentEquals intArrayOf(0, 0) -> return true
        slowRobot.currentHeading == Direction.E -> return false
        else -> return true
    }

//    fastRobot.processCommand()
//    fastRobot.processCommand()

//    while (!slowRobot.retread) {
//        if (slowRobot.currentPosition contentEquals fastRobot.currentPosition) {
//            if (slowRobot.retread) {
//                return true
//            }
//        }
//        slowRobot.processCommand()
//        fastRobot.processCommand()
//        fastRobot.processCommand()
//    }
//    return slowRobot.currentPosition contentEquals fastRobot.currentPosition

//    fastRobot.processCommand()
//    fastRobot.processCommand()

//    while (!slowRobot.retread) {
//        if (slowRobot.currentPosition contentEquals fastRobot.currentPosition) {
//            if (slowRobot.retread) {
//                return true
//            }
//        }
//        slowRobot.processCommand()
//        fastRobot.processCommand()
//        fastRobot.processCommand()
//    }
//    return slowRobot.currentPosition contentEquals fastRobot.currentPosition
}


fun main(args: Array<String>) {
//    val result = doesCircleExist(arrayOf("GRGL"))
    val result = doesCircleExist(arrayOf("G", "L", "RGRGR", "RGRGRGRG"))

    println(result.joinToString("\n"))
}