fun main(){
    // These constants set the game perimeters
    val maxGameNumber = 100
    val minGameNumber = 0
    
    val game = TheGame()
    
    /*
     * Befor you start the game, please, remember the "Key words":
     * "yes", "no", "bigger" and "smaller"
     */
    while(game.doTouWantToPlay()){
    game.playerGuesses(minGameNumber, maxGameNumber)
    game.computerGuesses(minGameNumber,maxGameNumber)
    }
}


/**
 * this cass serialises the game.
 * The game consists of two parts.
 * In the first part of the game you mast guess the number
 * with the computer hath picked
 * In nte second part of the game the computer mast guess the number
 * with you have picked
 */
class TheGame{
    
    /**
     * This function ask the player wil him play the game
     * if the player sey "Yes" the function return "true"
     * if the player sey "No" the function return "false"
     */
    public fun doTouWantToPlay(): Boolean {
        while (true) {
            when (js("prompt(\"Do you wont to play? yes/no\")")) {
                "no" -> return false
                "yes" -> return true
                else -> js("alert(\"i don't understand you =(\")")
            }
        }
    }
    
    
    /**
     * This function is responsible for the second part of the game
     * A player enter a number. If the number is bigger or smaller
     * the function informs the payer.
     * If the player has guest the number, the function is over
     */
    public fun playerGuesses(minNumber: Int = 0, maxNumber: Int = 100){
        
        val hidingNumber: Int = (minNumber..maxNumber).random()
        
        var answer: Int  = js("+prompt(\"Guess the number: \")")
        
        while (hidingNumber != answer) {
            if (hidingNumber > answer) answer = js("+prompt(\"The number is bigger\")")
            else answer = js("+prompt(\"The number is smaller\")")
        }
        js("alert(\"You guessed it\")")
    }
    
    
    /**
     * This function is responsible for the first part of the game
     * A computer enter a number. If the number is bigger or smaller
     * the payer informs the computer.
     * If the computer has guest the number, the function is over
     */
    public fun computerGuesses(minNumber: Int = 0, maxNumber: Int = 100) {

        js("alert(\"In the game use these words to guide me: yes, bigger, smaller\")")
        var min: Int = minNumber
        var max: Int = maxNumber
        var answer: Int

        label@ while (true) {

            if (min > max) {
                js("alert(\"This is impossible!\")")
                break
            }else if (min == max) {
                js("alert(\"This is yor number: \" + min)")
                break
            }

            answer = (min..max).random()

            when (js("prompt(\"Is it yor number?: \" + answer)")) {
                "bigger" -> min = answer + 1
                "smaller" -> max = answer - 1
                "yes" -> {
                    js("alert(\"Yay, I guessed the number! =)\")")
                    break@label
                } else -> js("alert(\"i don't understand you =(\")")
            }
        }
    }
    
}
