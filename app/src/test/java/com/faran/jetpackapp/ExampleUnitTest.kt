package com.faran.jetpackapp

import android.util.Log
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import java.lang.StringBuilder

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

   /* @Test
    fun testReverseString() {
        //Given
        val input = "Welcome to Sydney"
        val output = "Sydney to Welcome"

        //then
        val result = reverseString()

        //assert
        assertEquals(output, result)
    }

    fun reverseString(): String {
        val input = "Welcome to Sydney"
        var output: StringBuilder = StringBuilder()
        val splitWords = input.split(" ")

        for (i in splitWords.size -1 downTo 0) {
            val reverseString = splitWords[i]
            output.append(reverseString)
            output.append(" ")
        }
        return output.toString().trimEnd()
    }*/
}