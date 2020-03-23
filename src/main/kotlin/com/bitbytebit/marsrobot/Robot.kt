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
            Orientation.NORTH -> coordinate.copy(y = coordinate.y + 1)
            Orientation.WEST -> coordinate.copy(x = coordinate.x - 1)
            Orientation.SOUTH -> coordinate.copy(y = coordinate.y - 1)
            Orientation.EAST -> coordinate.copy(x = coordinate.x + 1)
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
}

data class Coordinate(
    val x: Int,
    val y: Int
)

enum class Orientation {
    NORTH, WEST, SOUTH, EAST
}