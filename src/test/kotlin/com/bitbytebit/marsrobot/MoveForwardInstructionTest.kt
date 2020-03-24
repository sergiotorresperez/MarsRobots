package com.bitbytebit.marsrobot

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.*
import org.junit.Test


class MoveForwardInstructionTest{

    private val instruction = MoveForwardInstruction

    @Test
    fun movesRobotForward() {
        val robot: Robot = mock()
        val expected: Robot = mock()

        whenever(robot.moveForward()).thenReturn(expected)

        val actual = instruction.processWith(robot)
        assertEquals("Should have delegated into Robot#moveForward()", expected, actual)
    }

}