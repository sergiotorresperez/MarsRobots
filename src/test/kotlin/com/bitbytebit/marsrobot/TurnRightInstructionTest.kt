package com.bitbytebit.marsrobot

import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.*
import org.junit.Test

class TurnRightInstructionTest {

    private val instruction = TurnRightInstruction()

    @Test
    fun turnsRight_when_facingNorth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.NORTH
        )

        val expected = robot.copy(orientation = Orientation.EAST)
        val actual = instruction.processWith(robot)

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
        val actual = instruction.processWith(robot)

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
        val actual = instruction.processWith(robot)

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
        val actual = instruction.processWith(robot)

        assertEquals("Should be facing north", expected, actual)
    }


}