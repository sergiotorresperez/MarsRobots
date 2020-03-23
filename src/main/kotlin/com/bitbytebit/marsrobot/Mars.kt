package com.bitbytebit.marsrobot

data class Mars(
    val width: Int,
    val height: Int,
    val scentedCoordinates: Set<Coordinate> = emptySet()
) {

    fun contains(coordinate: Coordinate) = coordinate.x in 0..(width - 1) && coordinate.y in 0..(height - 1)

    fun isScented(coordinate: Coordinate) = scentedCoordinates.contains(coordinate)

    fun setScented(coordinate: Coordinate) = copy(scentedCoordinates = scentedCoordinates.plus(coordinate))
}