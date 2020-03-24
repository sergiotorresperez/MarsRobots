package com.bitbytebit.marsrobot

private val inputProcessor = InputProcessor(System.out)

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Missing input argument. Input string needs to be passed as the first argument to main()")
    } else {
        inputProcessor.process(args[0])
    }
}
