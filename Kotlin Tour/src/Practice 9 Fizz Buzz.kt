// Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100 incrementally,
// replacing any number divisible by three with the word "fizz", and any number divisible by five with the word
// "buzz". Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".

fun main() {
    for ( number in 1..100) {
        if(number % 3 == 0 && number % 5 == 0) {
            println("fizzbuzz")
        } else if ( number % 3 == 0) {
            println("fizz")
        } else if ( number % 5 == 0) {
            println("buzz")
        } else {
            println(number)
        }
    }
}