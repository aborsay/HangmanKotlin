package xyz.borsay.hangman.run

import java.util.*

val wordsForHandman = linkedMapOf(Pair("white",0),
    Pair("heart",0),
    Pair("coffee",0),
    Pair("work",0),
    Pair("tech",0),
    Pair("stupid",0),
    Pair("soccer",0),
    Pair("orangutan",0),
    Pair("zebra",0),
    Pair("Lynchburg",0),
    Pair("Virginia",0),
)
var hangmanWord:String = ""

fun main() {
    startGame()
}

/**
 * Game is started here.
 */
fun startGame(){
    for(count in 0 until wordsForHandman.size){
        var whichWord: Int
        do {
            whichWord = Random().nextInt(0, wordsForHandman.size )
        }while(wordsForHandman.values.elementAt(whichWord) != 0)

        hangmanWord = wordsForHandman.keys.elementAt(whichWord).lowercase()
        wordsForHandman[hangmanWord] = wordsForHandman.values.elementAt(whichWord)+1
        printFirstLine(count)
        hangmanGame()
    }
}

/**
 * Just to move it seperated to print first line with each word.
 */
fun printFirstLine(count: Int){
    when(count){
        0 -> println("Here is your first word :)\n")
        wordsForHandman.size -> println("Ready or not, here is your last word :);)\n")
        else -> println("Now, time for the next word!!! :) \n")
    }
}

/**
 * Game is done here
 */
fun hangmanGame(){
    val guessedWord = arrayListOf<String>()

    val guessedLetters = arrayListOf<String>()

    val twoLine = "\n\n"
    val line = "__________________________________________________________________________________"

    for( i in 1..hangmanWord.length){
        guessedWord.add("_")
    }

    var guessCount = 0
    var guessCorrectWord = false

    do{

        if(guessedLetters.isNotEmpty())
            println("You have used these letters: ${ guessedLetters.joinToString(separator = ", ")}")
        getHangedMan(guessCount).forEach{ println(it) }
        println("Guess a  letter for the word \"${ guessedWord.joinToString(separator = "")}\"")
        var guessedLetter: String
        do{
            guessedLetter = readLine()?:""
            guessedLetter = guessedLetter.lowercase()
            if(guessedLetters.contains(guessedLetter))
                println("That letter has already been used!")

        }while(guessedLetters.contains(guessedLetter))
        guessedLetters.add(guessedLetter)

        if(!hangmanWord.contains(guessedLetter)) {
            guessCount++
            println("$twoLine $line  $twoLine InCorrect!")
        }else{
            for(i in hangmanWord.indices){
                if(guessedLetter == hangmanWord[i].toString()) {
                    guessedWord[i] = guessedLetter
                }
            }

            if(!guessedWord.contains("_"))
                guessCorrectWord = true
            else
                println("$twoLine $line  $twoLine  Correct!")
        }

    }while(guessCount<6 && !guessCorrectWord)

    //This is the final thing before next word is called
    if(guessCount<6)
        println(" $line $twoLine You solved the hangman with correct word - \"$hangmanWord\"!!!!!!!!!!!\n")
    else
        println("You have been hung :( \n The word was \"$hangmanWord\" $twoLine $line ")
}


