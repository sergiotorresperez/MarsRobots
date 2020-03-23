package com.bitbytebit.marsrobot

data class Robot(
    val mars: Mars,
    val coordinate: Coordinate,
    val orientation: Orientation
) 

data class Coordinate(
    val x: Int,
    val y: Int
)

enum class Orientation {
    NORTH, EAST, SOUTH, WEST
}