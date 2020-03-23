package com.bitbytebit.marsrobot

interface Instruction {
    fun processWith(robot: Robot): Robot
}