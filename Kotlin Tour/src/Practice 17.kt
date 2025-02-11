// To test your code, you need a generator that can create random employees. Define a RandomEmployeeGenerator class
// with a fixed list of potential names (inside the class body). Configure the class with a minimum and maximum salary
// (inside the class header). In the class body, define the generateEmployee() function. Once again, the main function
// demonstrates how you can use this class.

import kotlin.random.Random

class RandomEmployeeGenerator(val minSalary: Int, val maxSalary: Int) {
    val listOfNames = listOf("Max", "John")

    fun generateEmployee() : Employee {
        return Employee(listOfNames.get(Random.nextInt(0, listOfNames.count())) , Random.nextInt(minSalary, maxSalary))
    }

}

fun main() {
    val employeeGenerator = RandomEmployeeGenerator(1, 20)

    val employee = employeeGenerator.generateEmployee()
    println(employee.name)
    println(employee.salary)
}