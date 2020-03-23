package com.bitbytebit.marsrobot

interface Instruction {
    fun processWith(robot: Robot): Robot
}

class TurnLeftInstruction: Instruction {

    override fun processWith(robot: Robot): Robot {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}