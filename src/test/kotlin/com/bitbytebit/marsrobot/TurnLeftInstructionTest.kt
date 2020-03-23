package com.bitbytebit.marsrobot

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.*
import org.junit.Test

class TurnLeftInstructionTest {

    private val instruction = TurnLeftInstruction()

    @Test
    fun turnsRobotLeft() {
        val robot: Robot = mock()
        val expected: Robot = mock()

        whenever(robot.turnLeft()).thenReturn(expected)

        val actual = instruction.processWith(robot)
        assertEquals("Should have delegated into Robot#turnLeft()", expected, actual)
    }

}