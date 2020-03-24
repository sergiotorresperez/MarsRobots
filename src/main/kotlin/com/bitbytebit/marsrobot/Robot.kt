package com.bitbytebit.marsrobot

data class Robot(
    val mars: Mars,
    val coordinate: Coordinate,
    val orientation: Orientation
) {

    val isLost: Boolean
        get() = !mars.contains(coordinate)

    fun turnLeft(): Robot {
        val newOrientationIdx = (orientation.ordinal + 1) % Orientation.values().size
        val newOrientation = Orientation.values()[newOrientationIdx]
        return copy(orientation = newOrientation)
    }

    fun turnRight(): Robot {
        val newOrientationIdx = (Orientation.values().size + orientation.ordinal - 1) % Orientation.values().size
        val newOrientation = Orientation.values()[newOrientationIdx]
        return copy(orientation = newOrientation)
    }

    fun moveForward(): Robot {
        val newCoordinate = when (orientation) {
            Orientation.N -> coordinate.copy(y = coordinate.y + 1)
            Orientation.W -> coordinate.copy(x = coordinate.x - 1)
            Orientation.S -> coordinate.copy(y = coordinate.y - 1)
            Orientation.E -> coordinate.copy(x = coordinate.x + 1)
        }

        return if (!mars.contains(newCoordinate) && mars.isScented(coordinate)) {
            this
        } else {
            copy(coordinate = newCoordinate)
                .let { movedRobot ->
                    if (!mars.contains(movedRobot.coordinate)) {
                        movedRobot.copy(mars = mars.setScented(coordinate))
                    } else {
                        movedRobot
                    }
                }
        }
    }

    fun processInstructions(vararg instructions: Instruction) =
        instructions.fold(this) { r, i -> if (r.isLost) { r } else { i.processWith(r) } }


    override fun toString(): String {
        return "$coordinate $orientation ${if (isLost) "LOST" else ""}"
    }
}

data class Coordinate(
    val x: Int,
    val y: Int
) {
    override fun toString(): String {
        return "$x $y"
    }
}

enum class Orientation { N, W, S, E }