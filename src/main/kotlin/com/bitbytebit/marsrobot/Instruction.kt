package com.bitbytebit.marsrobot

interface Instruction {
    fun processWith(robot: Robot): Robot
}

class TurnLeftInstruction: Instruction {

    override fun processWith(robot: Robot): Robot {
        return robot.turnLeft()
    }

}

class TurnRightInstruction: Instruction {

    override fun processWith(robot: Robot): Robot {
        return robot.turnRight()
    }

}

class MoveForwardInstruction: Instruction {

    override fun processWith(robot: Robot): Robot {
        return robot.moveForward()
    }

}