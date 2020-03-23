package com.bitbytebit.marsrobot

import com.bitbytebit.marsrobot.Orientation.*
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.*
import org.junit.Test

class TurnLeftInstructionTest {

    private val instruction = TurnLeftInstruction()

    @Test
    fun turnsLeft_when_facingNorth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = NORTH
        )

        val expected = robot.copy(orientation = WEST)
        val actual = instruction.processWith(robot)

        assertEquals("Should be facing west", expected, actual)
    }

    @Test
    fun turnsLeft_when_facingWest() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = WEST
        )

        val expected = robot.copy(orientation = SOUTH)
        val actual = instruction.processWith(robot)

        assertEquals("Should be facing south", expected, actual)
    }

    @Test
    fun turnsLeft_when_facingSouth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = SOUTH
        )

        val expected = robot.copy(orientation = EAST)
        val actual = instruction.processWith(robot)

        assertEquals("Should be facing east", expected, actual)
    }

    @Test
    fun turnsLeft_when_facingEast() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = EAST
        )

        val expected = robot.copy(orientation = NORTH)
        val actual = instruction.processWith(robot)

        assertEquals("Should be facing north", expected, actual)
    }


}