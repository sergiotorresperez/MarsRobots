package com.bitbytebit.marsrobot

data class Robot(
    val mars: Mars,
    val coordinate: Coordinate,
    val orientation: Orientation
) {

    val isLost: Boolean
        get() = coordinate.x < 0
                || coordinate.x >= mars.width
                || coordinate.y < 0
                || coordinate.y >= mars.height

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
        return copy(coordinate = newCoordinate)
    }
}

data class Coordinate(
    val x: Int,
    val y: Int
)

enum class Orientation {
    NORTH, WEST, SOUTH, EAST
}