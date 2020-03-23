package com.bitbytebit.marsrobot

import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.*
import org.junit.Test

class RobotTest {

    private val mars = Mars(5, 3)

    @Test
    fun whenInWord_returnsNotLost() {
        val robot = Robot(
            mars = mars,
            coordinate = Coordinate(0, 0),
            orientation = mock()
        )

        val actual = robot.isLost
        assertFalse("Should return is not lost", actual)
    }

    @Test
    fun whenOverflowsNorthLimit_returnsLost() {
        val robot = Robot(
            mars = mars,
            coordinate = Coordinate(0, mars.height + 1),
            orientation = mock()
        )

        val actual = robot.isLost
        assertTrue("Should return is lost", actual)
    }


    @Test
    fun whenOverflowsEastLimit_returnsLost() {
        val robot = Robot(
            mars = mars,
            coordinate = Coordinate(-1, 0),
            orientation = mock()
        )

        val actual = robot.isLost
        assertTrue("Should return is lost", actual)
    }

    @Test
    fun whenOverflowsSouthLimit_returnsLost() {
        val robot = Robot(
            mars = mars,
            coordinate = Coordinate(0, -1),
            orientation = mock()
        )

        val actual = robot.isLost
        assertTrue("Should return is lost", actual)
    }

    @Test
    fun whenOverflowsWestLimit_returnsLost() {
        val robot = Robot(
            mars = mars,
            coordinate = Coordinate(mars.width + 1, 0),
            orientation = mock()
        )

        val actual = robot.isLost
        assertTrue("Should return is lost", actual)
    }

}