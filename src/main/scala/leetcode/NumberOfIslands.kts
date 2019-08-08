package leetcode

/**
200. Number of Islands
Medium

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */

fun numIslands(grid: Array<CharArray>): Int {

    fun adjacents(row: Int, column: Int): List<Pair<Int, Int>> {
        val maxColumns = grid[0].size - 1
        val maxRows = grid.size - 1

        val adjacents = mutableListOf<Pair<Int, Int>>()
        if (column > 0) adjacents.add(column - 1 to row)
        if (row > 0) adjacents.add(column to row - 1)
        if (column < maxColumns) adjacents.add(column + 1 to row)
        if (row < maxRows) adjacents.add(column to row + 1)
        return adjacents
    }

    fun dfs(row: Int, column: Int) {
        grid[row][column] = '0'
        for (adjacent in adjacents(row, column)) {
            val (adjCol: Int, adjRow: Int) = adjacent
            if (grid[adjRow][adjCol] == '1') {
                dfs(adjRow, adjCol)
            }
        }
    }

    var islands = 0
    // run dfs on first node you see as 1.
    // each dfs triggered signifies an island
    for (row in grid.indices) {
        for (column in grid[row].indices) {
            if (grid[row][column] == '1') {
                dfs(row, column)
                islands += 1
            }
        }
    }

    return islands
}


//class OldSolution {
//    fun numIslands(grid: Array<CharArray>): Int {
//        // for each element, check 4 adjacents
//        // for each adjacent that is 1, check it too
//        // keep adding its index to the current 'island'
//        // when island is fully 'mapped', add it to the list of islands
//        // continue with next element as long as it's not part of an existing island
//        val islands: MutableList<List<Pair<Int, Int>>> = mutableListOf()
//        val visitedIslandTiles: MutableSet<Pair<Int, Int>> = mutableSetOf()
//
//        fun adjacents(column: Int, row: Int): List<Pair<Int, Int>> {
//            val maxColumns = grid[0].size - 1
//            val maxRows = grid.size - 1
//
//            val adjacents = mutableListOf<Pair<Int, Int>>()
//            if (column > 0) adjacents.add(column - 1 to row)
//            if (row > 0) adjacents.add(column to row - 1)
//            if (column < maxColumns) adjacents.add(column + 1 to row)
//            if (row < maxRows) adjacents.add(column to row + 1)
//            return adjacents
//        }
//
//        fun mapIsland(column: Int, row: Int): List<Pair<Int, Int>> {
//            val nr = grid.size
//            val nc = grid[0].size
//
//            if (row < 0 || column < 0 || row >= nr || column >= nc || grid[r][column] == '0') {
//                return listOf()
//            }
//
//            if (grid[row][column] == '1') {
//                visitedIslandTiles.add(column to row)
//                return listOf(column to row) + adjacents(column, row).flatMap { (adjColumn, adjRow) ->
//                    if (column to row !in visitedIslandTiles) {
//                        mapIsland(adjColumn, adjRow)
//                    } else listOf()
//                }
//            } else {
////            if (grid[x][y] == '0') {
//                return listOf()
//            }
//        }
//
//
//        for (r in 0 until grid.size) {
//            for (c in 0 until grid[r].size) {
//                if (r to c !in visitedIslandTiles) {
//                    val newIsland = mapIsland(c, r)
//                    if (newIsland.isNotEmpty()) {
//                        islands.add(newIsland)
//                    }
//                }
//            }
//        }
//
//        return islands.size
//    }
//}

val r = numIslands(arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '1', '0')
))

println(r)


