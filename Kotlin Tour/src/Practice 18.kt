// You have the employeeById function that gives you access to a database of employees of a company. Unfortunately,
// this function returns a value of the Employee? type, so the result can be null. Your goal is to write a function
// that returns the salary of an employee when their id is provided, or 0 if the employee is missing from the database.

data class Employee1 (val name: String, var salary: Int)

fun employeeById(id: Int) = when(id) {
    1 -> Employee1("Mary", 20)
    2 -> null
    3 -> Employee1("John", 21)
    4 -> Employee1("Ann", 23)
    else -> null
}

fun salaryById(id: Int): Int {
    return employeeById(id)?.salary ?: 0
}

fun main() {
    println((1..5).sumOf { id -> salaryById(id) })
}