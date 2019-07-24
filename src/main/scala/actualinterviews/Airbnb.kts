fun fill_water(terrain: IntArray, dump_location: Int, amount: Int) {
    // just need to initialize array to size of terrain
    val water: Array<Int> = Array(terrain.size) { 0 }


    fun scan(idx: Int, directionRight: Boolean): Int {
        var prevElement = terrain[idx] + water[idx]
        var waterLocation = idx
        val range = if (directionRight) (idx + 1)..terrain.size else (idx - 1) downTo 0
        for (i in range) {
            if (terrain[i] + water[i] > prevElement) {
                // i is the water location
                break
            } else {
                prevElement = terrain[i] + water[i]
                waterLocation = i
            }
        }
        return waterLocation
    }

    // Finds a suitable location for a unit of water and adds it to the water array
    fun add_water(terrain: IntArray, dumpLocation: Int) {
        // scan right
        var waterLocation = scan(dumpLocation, true)
        // scan left
        waterLocation = scan(waterLocation, false)
        // add to water array
        water[waterLocation] += 1
    }

    for (i in 0..amount) {
        add_water(terrain, dump_location)
    }

    val depth = terrain.max()!!
    for (row in depth downTo 0) {
        terrain.forEachIndexed { idx, element ->
            if (water[idx] > 0 && water[idx] + element == row) {
                print("w")
            } else if (element >= row) {
                print("+")
            } else {
                print(" ")
            }
            print(" ")
        }
        println("")
    }
}


fill_water(intArrayOf(5, 4, 3, 4, 2, 1, 0, 1, 2, 3), 1, 5)
