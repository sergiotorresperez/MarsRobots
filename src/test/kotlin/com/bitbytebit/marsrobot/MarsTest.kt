package com.bitbytebit.marsrobot

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MarsTest {

    @Test
    fun whenNotEscented_returnsNotScented() {
        val mars = Mars(2,2)
        val actual = mars.isScented(Coordinate(0,0))
        assertFalse("Should not be scented", actual)
    }

    @Test
    fun setsEscented() {
        val mars = Mars(2,2).setScented(Coordinate(0,0))
        val actual = mars.isScented(Coordinate(0,0))
        assertTrue("Should not be scented", actual)
    }
}