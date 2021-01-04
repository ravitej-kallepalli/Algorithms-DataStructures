package leetcode_jan_challenge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

//TODO: Can this be parameterized?
internal class PalindromePermutationTest {
    private lateinit var classUnderTest: PalindromePermutation

    @BeforeEach
    fun setup() {
        classUnderTest = PalindromePermutation()
    }

    @Test
    fun forValidPalindromeString_returnTrue() {
        classUnderTest.checkPalindromeByArray("AbBccbAB")
            .also { assertTrue(it) }
    }

    @Test
    fun forValidPalindromeString_returnFalse() {
        classUnderTest.checkPalindromeByArray("AaBb//a")
            .also { assertFalse(it) }
    }
}