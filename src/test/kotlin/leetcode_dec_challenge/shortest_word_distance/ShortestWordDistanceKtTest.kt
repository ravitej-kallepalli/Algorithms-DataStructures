package leetcode_dec_challenge.shortest_word_distance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ShortestWordDistanceKtTest {

    private lateinit var classUnderTest: ShortestWordDistance

    @BeforeEach
    fun setUp() {
        classUnderTest = ShortestWordDistance()
    }

    @Test
    fun test1() {
        val words = arrayOf("practice", "makes", "perfect", "coding", "makes")
        val word1 = "coding"
        val word2 = "practice"
        classUnderTest.shortestDistance(words, word1, word2)
            .also {
                assertEquals(3, it)
            }
    }

    @Test
    fun test2() {
        val words = arrayOf("a", "c", "b", "b", "a")
        val word1 = "a"
        val word2 = "b"
        classUnderTest.shortestDistance(words, word1, word2)
            .also {
                assertEquals(1, it)
            }
    }

    @Test
    fun test3() {
        val words = arrayOf("a", "a", "b", "b")
        val word1 = "a"
        val word2 = "b"
        classUnderTest.shortestDistance(words, word1, word2)
            .also {
                assertEquals(1, it)
            }
    }
}