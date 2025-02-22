// Using a when expression, update the following program so that it prints the corresponding
// actions when you input the names of game console buttons.
/*
A -> Yes
B -> No
X -> Menu
Y -> Nothing
 */

fun main() {
    val button = "B"

    println(
        when(button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> ""
        }
    )
}