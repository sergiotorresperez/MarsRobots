package com.bitbytebit.marsrobot

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.*
import org.junit.Test

class TurnRightInstructionTest {

    private val instruction = TurnRightInstruction

    @Test
    fun turnsRobotRight() {
        val robot: Robot = mock()
        val expected: Robot = mock()

        whenever(robot.turnRight()).thenReturn(expected)

        val actual = instruction.processWith(robot)
        assertEquals("Should have delegated into Robot#turnRight()", expected, actual)
    }


}