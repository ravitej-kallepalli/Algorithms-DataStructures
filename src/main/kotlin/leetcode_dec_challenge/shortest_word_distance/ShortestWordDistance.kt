package leetcode_dec_challenge.shortest_word_distance

import kotlin.math.abs
import kotlin.math.min

/**
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1
 **/
fun main(args: Array<String>) {

    val inputWords = arrayOf("a", "c", "b", "b", "a")
    val word1 = "a"
    val word2 = "b"

    val shortestWordDistance = ShortestWordDistance()

    shortestWordDistance.shortestDistance(inputWords, word1, word2)
        .also { println("Shortest distance between $word1 and $word2 -> $it") }
}

class ShortestWordDistance {
    fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
        var word1Pos = -1
        var word2Pos = -1

        var currentMin = words.size

        words.forEachIndexed { index, curWord ->
            if (curWord == word1) {
                word1Pos = index
            }

            if (curWord == word2) {
                word2Pos = index
            }

            //If both positions are known then verify if it contributes to shortest distance.
            if (word1Pos != -1 && word2Pos != -1) {
                currentMin = min(abs(word1Pos - word2Pos), currentMin)
            }
        }

        return currentMin
    }
}

