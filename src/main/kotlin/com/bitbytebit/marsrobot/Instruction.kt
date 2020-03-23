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