package xyz.borsay.hangman.run
val theHangManHanging = arrayListOf( "  |        ",
    "  |      o ",
    "  |     /| ",
    "  |     /|\\ ",
    "  |      | ",
    " /|\\    /   ",
    " /|\\    / \\  ")
val theHangMan = arrayListOf(   "  |------|",
    "  |      | ",
    "  |        ",
    "  |        ",
    "  |        ",

    " /|\\      ",
    " /|\\      ")
/**
 * Made seperate just to keep to boring constnts away form the rest of the project
 */
fun getHangedMan(level: Int): ArrayList<String>{
    val theHangManReturned  = theHangMan
    theHangManReturned[2] = if(level > 0 ) theHangManHanging[1] else  theHangManReturned[2]
    theHangManReturned[3] =  if(level > 1) theHangManHanging[2] else theHangManReturned[3]
    theHangManReturned[3] = if(level > 2) theHangManHanging[3] else theHangManReturned[3]
    theHangManReturned[4] = if(level > 3) theHangManHanging[4] else theHangManReturned[4]
    theHangManReturned[5] = if(level > 4) theHangManHanging[5] else theHangManReturned[5]
    theHangManReturned[5] = if(level > 5) theHangManHanging[6] else theHangManReturned[5]

    return theHangManReturned
}