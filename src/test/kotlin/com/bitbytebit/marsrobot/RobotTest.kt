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

    @Test
    fun turnsLeft_when_facingNorth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.NORTH
        )

        val expected = robot.copy(orientation = Orientation.WEST)
        val actual = robot.turnLeft()
        assertEquals("Should be facing west", expected, actual)
    }

    @Test
    fun turnsLeft_when_facingWest() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.WEST
        )

        val expected = robot.copy(orientation = Orientation.SOUTH)
        val actual = robot.turnLeft()

        assertEquals("Should be facing south", expected, actual)
    }

    @Test
    fun turnsLeft_when_facingSouth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.SOUTH
        )

        val expected = robot.copy(orientation = Orientation.EAST)
        val actual = robot.turnLeft()

        assertEquals("Should be facing east", expected, actual)
    }

    @Test
    fun turnsLeft_when_facingEast() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.EAST
        )

        val expected = robot.copy(orientation = Orientation.NORTH)
        val actual = robot.turnLeft()

        assertEquals("Should be facing north", expected, actual)
    }

    @Test
    fun turnsRight_when_facingNorth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.NORTH
        )

        val expected = robot.copy(orientation = Orientation.EAST)
        val actual = robot.turnRight()

        assertEquals("Should be facing east", expected, actual)
    }

    @Test
    fun turnsRight_when_facingEast() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.EAST
        )

        val expected = robot.copy(orientation = Orientation.SOUTH)
        val actual = robot.turnRight()

        assertEquals("Should be facing south", expected, actual)
    }

    @Test
    fun turnsRight_when_facingSouth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.SOUTH
        )

        val expected = robot.copy(orientation = Orientation.WEST)
        val actual = robot.turnRight()

        assertEquals("Should be facing west", expected, actual)
    }

    @Test
    fun turnsRight_when_facingWest() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.WEST
        )

        val expected = robot.copy(orientation = Orientation.NORTH)
        val actual = robot.turnRight()

        assertEquals("Should be facing north", expected, actual)
    }

    @Test
    fun moveForward_when_facingNorth() {
        val robot = Robot(
            mars = Mars(2, 2),
            coordinate = Coordinate(0, 0),
            orientation = Orientation.NORTH
        )

        val expected = robot.copy(coordinate = Coordinate(0, 1))
        val actual = robot.moveForward()

        assertEquals("Should be one step north", expected, actual)
    }

    @Test
    fun moveForward_when_facingWest() {
        val robot = Robot(
            mars = Mars(2, 2),
            coordinate = Coordinate(1, 0),
            orientation = Orientation.WEST
        )

        val expected = robot.copy(coordinate = Coordinate(0, 0))
        val actual = robot.moveForward()

        assertEquals("Should be one step west", expected, actual)
    }

    @Test
    fun moveForward_when_facingSouth() {
        val robot = Robot(
            mars = Mars(2, 2),
            coordinate = Coordinate(0, 1),
            orientation = Orientation.SOUTH
        )

        val expected = robot.copy(coordinate = Coordinate(0, 0))
        val actual = robot.moveForward()

        assertEquals("Should be one step south", expected, actual)
    }

    @Test
    fun moveForward_when_facingEast() {
        val robot = Robot(
            mars = Mars(2, 2),
            coordinate = Coordinate(0, 0),
            orientation = Orientation.EAST
        )

        val expected = robot.copy(coordinate = Coordinate(1, 0))
        val actual = robot.moveForward()

        assertEquals("Should be one step east", expected, actual)
    }
}