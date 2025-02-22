// Declare the additional data classes that are needed for this code to compile.

data class Person(val name: Name, val address: Address, val ownsAPet: Boolean = true)
data class Name ( val firstName: String, val lastName: String)
data class City(val town: String, val country: String)
data class Address(val street: String, val city: City)


fun main() {
    val person = Person(
        Name("John", "Smith"),
        Address("123 Fake Street", City("Springfield", "US")),
        ownsAPet = false
    )
}