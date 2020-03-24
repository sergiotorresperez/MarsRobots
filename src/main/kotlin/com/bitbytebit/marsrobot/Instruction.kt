package com.bitbytebit.marsrobot

interface Instruction {
    fun processWith(robot: Robot): Robot
}

object TurnLeftInstruction: Instruction {

    override fun processWith(robot: Robot): Robot {
        return robot.turnLeft()
    }

}

object TurnRightInstruction: Instruction {

    override fun processWith(robot: Robot): Robot {
        return robot.turnRight()
    }

}

object MoveForwardInstruction: Instruction {

    override fun processWith(robot: Robot): Robot {
        return robot.moveForward()
    }

}