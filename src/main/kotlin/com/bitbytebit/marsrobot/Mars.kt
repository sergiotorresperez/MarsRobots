package com.bitbytebit.marsrobot

data class Mars(
    val width: Int,
    val height: Int,
    val scentedCoordinates: Set<Coordinate> = emptySet()
) {

    fun isScented(coordinate: Coordinate) = scentedCoordinates.contains(coordinate)

    fun setScented(coordinate: Coordinate) = copy(scentedCoordinates = scentedCoordinates.plus(coordinate))
}