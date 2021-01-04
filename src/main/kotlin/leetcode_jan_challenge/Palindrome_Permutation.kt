package leetcode_jan_challenge

fun main(args: Array<String>) {
    PalindromePermutation().also {
        print(it.checkPalindromeByArray("AaBb//a"))
    }
}

class PalindromePermutation {

    fun checkPalindromeByArray(input: String): Boolean {
        //Assuming ASCII values
        val charCountArray = IntArray(256)

        input.forEach {
            charCountArray[it.toInt()] = ++charCountArray[it.toInt()]
        }

        //If the length is even then there will be no odd no of char.
        //If length is odd, then there will be max one odd no of char.
        var isMaxOneOddCharLimitReached = false

        charCountArray.forEach {
            if (it.rem(2) != 0) {
                if (isMaxOneOddCharLimitReached) {
                    return false
                }

                isMaxOneOddCharLimitReached = true
            }
        }
        return true
    }
}