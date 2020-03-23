package com.bitbytebit.marsrobot

import org.junit.Assert.*
import org.junit.Test

class MoveForwardInstructionTest{

    private val instruction = MoveForwardInstruction()

    @Test
    fun moveForward_when_facingNorth() {
        val robot = Robot(
            mars = Mars(2, 2),
            coordinate = Coordinate(0, 0),
            orientation = Orientation.NORTH
        )

        val expected = robot.copy(coordinate = Coordinate(0, 1))
        val actual = instruction.processWith(robot)

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
        val actual = instruction.processWith(robot)

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
        val actual = instruction.processWith(robot)

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
        val actual = instruction.processWith(robot)

        assertEquals("Should be one step east", expected, actual)
    }

}