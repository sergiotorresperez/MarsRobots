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
}

data class Coordinate(
    val x: Int,
    val y: Int
)

enum class Orientation {
    NORTH, WEST, SOUTH, EAST
}