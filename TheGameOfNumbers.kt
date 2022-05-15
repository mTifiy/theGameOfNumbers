/**
 * this cass serialises the game.
 * The game consists of two parts.
 * In the first part of the game you mast guess the number
 * with the computer hath picked
 * In nte second part of the game the computer mast guess the number
 * with you have picked
 */

class TheGameOfNumbers {
    // These constants set the game perimeters
    private val maxGameNumber = 100
    private val minGameNumber = 0

    /**
     * This function is responsible for the second part of the game
     * A player enter a number. If the number is bigger or smaller
     * the function informs the payer.
     * If the player has guest the number, the function is over
     */
    private fun playerGuesses(minNumber: Int = 0, maxNumber: Int = 100){


        val hidingNumber = (minNumber..maxNumber).random()

        var answer = enterNumber()

        while (hidingNumber != answer) {
            if (hidingNumber > answer) println("The number is bigger")
            else println("The number is smaller")
            answer = enterNumber()
        }
        println("You guessed it!\n")
    }

    /**
     * This function is responsible for the first part of the game
     * A computer enter a number. If the number is bigger or smaller
     * the payer informs the computer.
     * If the computer has guest the number, the function is over
     */
    private fun computerGuesses(minNumber: Int = 0, maxNumber: Int = 100) {


        var min = minNumber
        var max = maxNumber
        var answer: Int

        label@ while (true) {

            if (min > max) {
                println("This is impossible!\n")
                break
            }else if (min == max) {
                println("$min is your number!")
                break
            }

            answer = (min..max).random()

            when (askTheAnswer(answer)) {
                "bigger" -> min = answer + 1
                "smaller" -> max = answer - 1
                "yes" -> {
                    println("Yay, I guessed the number! =)\n")
                    break@label
                }
                else -> println("i don't understand you =(")
            }
        }
    }

    /**
     * This function return the number from the payer
     */
    private fun enterNumber(): Int {
        print("Guess the number: ")
        return readLine()!!.toInt()
    }
    /**
     * This function return the answer from the payer
     */
    private fun askTheAnswer(number: Int): String {
        println("Is it yor number: $number ? ")
        return readLine().toString()
    }

    /**
     * This function ask the player wil him play the game
     * if the player sey "Yes" the function return "true"
     * if the player sey "No" the function return "false"
     */
    private fun doTouWantToPlay(): Boolean {
        println("Do you wont to play? Yes/No ")
        while (true) {
            when (readLine().toString()) {
                "no" -> return true
                "yes" -> return false
                else -> println("i don't understand you =(")
            }
        }
    }

    companion object {
        /**
         * This function make the game
         */
        @JvmStatic
        fun main(args: Array<String>) {
            // create the object of the class
            val myGame = TheGameOfNumbers()

            while (true) {

                if (myGame.doTouWantToPlay()) break

                println("let me guess the number \nUse these words to guide me: yes, bigger, smaller")
                myGame.computerGuesses(myGame.minGameNumber, myGame.maxGameNumber)

                if (myGame.doTouWantToPlay()) break

                println("It's your turn to guess the number")
                myGame.playerGuesses(myGame.minGameNumber, myGame.maxGameNumber)
            }
        }
    }
}