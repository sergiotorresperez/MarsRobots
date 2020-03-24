package com.bitbytebit.marsrobot

import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets

class InputProcessorTest {

    private val baos = ByteArrayOutputStream()
    private val utf8 = StandardCharsets.UTF_8.name()
    private val printStream = PrintStream(baos, true, utf8)

    private val inputProcessor = InputProcessor(printStream)

    @Test
    fun processesSampleInput() {
        val input =
                """
                5 3
                1 1 E
                RFRFRFRF

                3 2 N
                FRRFLLFFRRFLL

                0 3 W
                LLFFFLFLFL

                """.trimIndent()

        val expected = """
            1 1 E
            3 3 N LOST
            2 3 S
        """.trimIndent()

        inputProcessor.process(input)

        val actual = baos.toString(utf8)
        Assert.assertEquals("Sample output should match", expected, actual)
    }
}