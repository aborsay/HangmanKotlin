package xyz.borsay.hangman.run


fun getHangedMan(level: Int): ArrayList<String>{
    var theHangManHanging = arrayListOf( "  |        ",
        "  |      o ",
        "  |     /| ",
        "  |     /|\\ ",
        "  |      | ",
        " /|\\    /   ",
        " /|\\    / \\  ")
    var theHangMan = arrayListOf(   "  |------|",
        "  |      | ",
        "  |        ",
        "  |        ",
        "  |        ",

        " /|\\      ",
        " /|\\      ")

    var theHangManReturned  = theHangMan
    theHangManReturned[2] = if(level > 0 ) theHangManHanging[1] else  theHangManReturned[2]
    theHangManReturned[3] =  if(level > 1) theHangManHanging[2] else theHangManReturned[3]
    theHangManReturned[3] = if(level > 2) theHangManHanging[3] else theHangManReturned[3]
    theHangManReturned[4] = if(level > 3) theHangManHanging[4] else theHangManReturned[4]
    theHangManReturned[5] = if(level > 4) theHangManHanging[5] else theHangManReturned[5]
    theHangManReturned[5] = if(level > 5) theHangManHanging[6] else theHangManReturned[5]


    return theHangManReturned
}