package com.bitbytebit.marsrobot

import java.io.PrintStream
import java.lang.IllegalArgumentException
import java.util.*

class InputProcessor(private val out: PrintStream) {

    private val marsFactory = MarsFactory()
    private val robotFactory = RobotFactory()
    private val instructionsFactory = InstructionsFactory()

    fun process(input: String) {
        val scanner = Scanner(input)

        var mars = marsFactory.createMars(scanner.nextLine())

        while (scanner.hasNextLine()) {
            val robot = processRobot(mars, scanner)
            out.println(robot.toString())
            mars = robot.mars
        }
    }

    private fun processRobot(mars: Mars, scanner: Scanner): Robot {
        val robot = robotFactory.createRobot(mars, scanner.nextLine())
        val instructions = instructionsFactory.createInstructions(scanner.nextLine())
        if (scanner.hasNextLine()) { scanner.nextLine() }
        return robot.processInstructions(*instructions.toTypedArray())
    }


    class MarsFactory {
        fun createMars(str: String): Mars {
            val array = str.split(" ")
            return Mars(array[0].toInt(), array[1].toInt())
        }
    }

    class RobotFactory {
        private val orientationFactory = OrientationFactory()

        fun createRobot(mars: Mars, line: String): Robot {
            val array = line.split(" ")
            return Robot(mars, Coordinate(array[0].toInt(), array[1].toInt()), orientationFactory.createOrientation(array[2]))
        }
    }

    class OrientationFactory {
        fun createOrientation(str: String): Orientation {
            return when (str) {
                "N" -> Orientation.N
                "S" -> Orientation.S
                "E" -> Orientation.E
                "W" -> Orientation.W
                else -> throw IllegalArgumentException("Cannot create orientation for $str")
            }
        }
    }

    class InstructionsFactory {
        fun createInstructions(str: String): List<Instruction> {
            return str
                .map { char -> createInstruction(char) }
                .toList()
        }

        private fun createInstruction(char: Char): Instruction {
            return when (char) {
                'L' -> TurnLeftInstruction
                'R' -> TurnRightInstruction
                'F' -> MoveForwardInstruction
                else -> throw IllegalArgumentException("Cannot create instruction for $char")
            }
        }
    }
}