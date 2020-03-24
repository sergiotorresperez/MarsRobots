package com.bitbytebit.marsrobot

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MarsTest {

    @Test
    fun whenInBounds_returnsContainsCoordinate() {
        val mars = Mars(2,2)

        val actual = mars.contains(Coordinate(1,1))
        assertTrue("Should return coordinate contained", actual)
    }

    @Test
    fun whenOverflowsNorthLimit_returnsDosNotContainsCoordinate() {
        val mars = Mars(2,2)

        val actual = mars.contains(Coordinate(1,2))
        assertFalse("Should return coordinate not contained", actual)
    }

    @Test
    fun whenOverflowsEastLimit_returnsDosNotContainsCoordinate() {
        val mars = Mars(2,2)

        val actual = mars.contains(Coordinate(2,0))
        assertFalse("Should return coordinate not contained", actual)
    }

    @Test
    fun whenOverflowsSouthLimit_returnsDosNotContainsCoordinate() {
        val mars = Mars(2,2)

        val actual = mars.contains(Coordinate(0,-1))
        assertFalse("Should return coordinate not contained", actual)
    }

    @Test
    fun whenOverflowsWestLimit_returnsLost() {
        val mars = Mars(2,2)

        val actual = mars.contains(Coordinate(-1, 0))
        assertFalse("Should return coordinate not contained", actual)
    }

    @Test
    fun whenNotEscented_returnsNotScented() {
        val mars = Mars(2,2)
        val actual = mars.isScented(Coordinate(0,0))
        assertFalse("Should not be scented", actual)
    }

    @Test
    fun setsEscented() {
        val mars = Mars(2,2).setScented(Coordinate(0,0))
        val actual = mars.isScented(Coordinate(0,0))
        assertTrue("Should not be scented", actual)
    }
}