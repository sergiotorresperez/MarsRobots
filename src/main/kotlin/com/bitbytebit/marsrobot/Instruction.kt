package com.bitbytebit.marsrobot

interface Instruction {
    fun processWith(robot: Robot): Robot
}

class TurnLeftInstruction: Instruction {

    override fun processWith(robot: Robot): Robot {
        val newOrientationIdx = (robot.orientation.ordinal + 1) % Orientation.values().size
        val newOrientation = Orientation.values()[newOrientationIdx]
        return robot.copy(orientation = newOrientation)
    }

}

class TurnRightInstruction: Instruction {

    override fun processWith(robot: Robot): Robot {
        val newOrientationIdx = (Orientation.values().size + robot.orientation.ordinal - 1) % Orientation.values().size
        val newOrientation = Orientation.values()[newOrientationIdx]
        return robot.copy(orientation = newOrientation)
    }

}

class MoveForwardInstruction: Instruction {

    override fun processWith(robot: Robot): Robot {
        val newCoordinate = when (robot.orientation) {
            Orientation.NORTH -> robot.coordinate.copy(y = robot.coordinate.y + 1)
            Orientation.WEST -> robot.coordinate.copy(x = robot.coordinate.x - 1)
            Orientation.SOUTH -> robot.coordinate.copy(y = robot.coordinate.y - 1)
            Orientation.EAST -> robot.coordinate.copy(x = robot.coordinate.x + 1)
        }
        return robot.copy(coordinate = newCoordinate)
    }

}