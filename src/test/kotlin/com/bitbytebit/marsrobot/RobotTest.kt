package com.bitbytebit.marsrobot

import com.bitbytebit.marsrobot.Orientation.N
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verifyZeroInteractions
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.*
import org.junit.Test

class RobotTest {

    @Test
    fun turnsLeft_when_facingNorth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = N
        )

        val expected = robot.copy(orientation = Orientation.W)
        val actual = robot.turnLeft()
        assertEquals("Should be facing west", expected, actual)
    }

    @Test
    fun turnsLeft_when_facingWest() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.W
        )

        val expected = robot.copy(orientation = Orientation.S)
        val actual = robot.turnLeft()

        assertEquals("Should be facing south", expected, actual)
    }

    @Test
    fun turnsLeft_when_facingSouth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.S
        )

        val expected = robot.copy(orientation = Orientation.E)
        val actual = robot.turnLeft()

        assertEquals("Should be facing east", expected, actual)
    }

    @Test
    fun turnsLeft_when_facingEast() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.E
        )

        val expected = robot.copy(orientation = N)
        val actual = robot.turnLeft()

        assertEquals("Should be facing north", expected, actual)
    }

    @Test
    fun turnsRight_when_facingNorth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = N
        )

        val expected = robot.copy(orientation = Orientation.E)
        val actual = robot.turnRight()

        assertEquals("Should be facing east", expected, actual)
    }

    @Test
    fun turnsRight_when_facingEast() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.E
        )

        val expected = robot.copy(orientation = Orientation.S)
        val actual = robot.turnRight()

        assertEquals("Should be facing south", expected, actual)
    }

    @Test
    fun turnsRight_when_facingSouth() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.S
        )

        val expected = robot.copy(orientation = Orientation.W)
        val actual = robot.turnRight()

        assertEquals("Should be facing west", expected, actual)
    }

    @Test
    fun turnsRight_when_facingWest() {
        val robot = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = Orientation.W
        )

        val expected = robot.copy(orientation = N)
        val actual = robot.turnRight()

        assertEquals("Should be facing north", expected, actual)
    }

    @Test
    fun moveForward_when_facingNorth() {
        val robot = Robot(
            mars = Mars(2, 2),
            coordinate = Coordinate(0, 0),
            orientation = N
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
            orientation = Orientation.W
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
            orientation = Orientation.S
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
            orientation = Orientation.E
        )

        val expected = robot.copy(coordinate = Coordinate(1, 0))
        val actual = robot.moveForward()

        assertEquals("Should be one step east", expected, actual)
    }

    @Test
    fun doesNotLeaveScent_whenMovingInsideBounds() {
        val startCoordinate = Coordinate(0, 0)
        val robot = Robot(
            mars = Mars(2, 2),
            coordinate = startCoordinate,
            orientation = N
        )

        val marsAfterMovement = robot.moveForward().mars
        val actual = marsAfterMovement.isScented(startCoordinate)
        assertFalse("Coordinate should not be escented", actual)
    }

    @Test
    fun makesRobotLost_andMakesCoordinateScented_whenMovingOutOfBounds() {
        val mars = Mars(1, 1)
        val coordinate = Coordinate(0, 0)
        val robot = Robot(
            mars = mars,
            coordinate = coordinate,
            orientation = Orientation.N
        )

        val expected = robot.copy(
            coordinate = Coordinate(0, 1),
            isLost = true,
            mars = mars.setScented(coordinate))
        val actual = robot.moveForward()

        assertEquals("Should be lost", expected, actual)
    }

    @Test
    fun whenMovingFromScentedCoordinateToInvalidCoordinate_robotDoesNotMove() {
        val startCoordinate = Coordinate(0, 0)

        val robot = Robot(
            mars = Mars(5, 3).setScented(startCoordinate),
            coordinate = startCoordinate,
            orientation = Orientation.S
        )

        val actual = robot.moveForward()
        assertEquals("Robot should have not moved", robot, actual)
    }

    @Test
    fun whenMovingFromScentedCoordinateToValidCoordinate_robotDoesMove() {
        val startCoordinate = Coordinate(0, 0)

        val robot = Robot(
            mars = Mars(5, 3).setScented(startCoordinate),
            coordinate = startCoordinate,
            orientation = N
        )

        val expected = robot.copy(coordinate = Coordinate(0, 1))
        val actual = robot.moveForward()
        assertEquals("Robot should have moved", expected, actual)
    }

    @Test
    fun whenStartingFromOutOfBounds_movementIsAllowed_andRobotDoesNotBecomeLost() {

        val robot = Robot(
            mars = Mars(5, 3),
            coordinate = Coordinate(-1, -1),
            orientation = Orientation.S,
            isLost = false
        )

        val expected = robot.copy(
            coordinate = Coordinate(-1, -2),
            isLost = false
        )
        val actual = robot.moveForward()
        assertEquals("Robot should have moved", expected, actual)
    }

    @Test
    fun processesInstructions() {
        val robot0 = Robot(
            mars = mock(),
            coordinate = mock(),
            orientation = N
        )

        val robot1: Robot = robot0.copy(coordinate = mock())
        val robot2: Robot = robot1.copy(coordinate = mock())

        val instruction0: Instruction = mock()
        val instruction1: Instruction = mock()

        whenever(instruction0.processWith(robot0)).thenReturn(robot1)
        whenever(instruction1.processWith(robot1)).thenReturn(robot2)

        val actual = robot0.processInstructions(instruction0, instruction1)
        assertEquals("Robot should have processed all the instructions", robot2, actual)
    }

}