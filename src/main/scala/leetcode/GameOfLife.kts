package leetcode

/** 289. Game of Life
Medium

According to the Wikipedia's article: "The Game of Life, also known simply as Life,
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.
The next state is created by applying the above rules simultaneously to every cell in the current state,
where births and deaths occur simultaneously.

Example:

Input:
[
[0,1,0],
[0,0,1],
[1,1,1],
[0,0,0]
]
Output:
[
[0,0,0],
[1,0,1],
[0,1,1],
[0,1,0]
]
Follow up:

1) Could you solve it in-place? Remember that the board needs to be updated at the same time:
You cannot update some cells first and then use their updated values to update other cells.

2) In this question, we represent the board using a 2D array. In principle, the board is infinite,
which would cause problems when the active area encroaches the border of the array.
How would you address these problems?

 */


fun gameOfLife(board: Array<IntArray>) {
    // build up new nextState array with the next board state by iterating over each element of the board
    // and write the appropriate value out to the nextState array
    val nextState = board.mapIndexed { r, row ->
        row.mapIndexed { c, element ->
            val liveNeighbors: Int = board.liveNeighborCount(c, r)
            when {
                liveNeighbors < 2 -> 0
                liveNeighbors > 3 -> 0
                liveNeighbors == 3 -> 1
                else -> element
            }
        }
    }

    nextState.forEachIndexed { r, row ->
        row.forEachIndexed { c, element ->
            board[r][c] = element
        }
    }
}

fun Array<IntArray>.liveNeighborCount(column: Int, row: Int): Int {
    return adjacents(column, row).fold(0) { acc, (column, row) -> acc + get(row)[column] }
}

fun Array<IntArray>.adjacents(column: Int, row: Int): List<Pair<Int, Int>> {
    val maxRows = this.size - 1
    val maxColumns = this[0].size - 1

    val adjacents = mutableListOf<Pair<Int, Int>>()
    if (column > 0) {
        if (row > 0) adjacents.add(column - 1 to row - 1)
        adjacents.add(column - 1 to row)
        if (row < maxRows) adjacents.add(column - 1 to row + 1)
    }
    if (row > 0) adjacents.add(column to row - 1)
    if (column < maxColumns) {
        if (row > 0) adjacents.add(column + 1 to row - 1)
        adjacents.add(column + 1 to row)
        if (row < maxRows) adjacents.add(column + 1 to row + 1)
    }
    if (row < maxRows) adjacents.add(column to row + 1)

    return adjacents
}

val result = gameOfLife(arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 1),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 0, 0)
))

println(result)

