fun main() {
    val readOnlyShapes = listOf("triangle", "square", "circle");
    println(readOnlyShapes)

    val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
    val shapesLocked: List<String> = shapes
    println(shapesLocked)

    println("The first element of list is ${shapes.first()}")
    println("The last element of list is ${shapes.last()}")
    println("The number of elements in the list is ${shapes.count()}")

    if("circle" in shapes) {
        println("There is a circle in the list")
    } else {
        println("There are no circles in the list")

    }
    shapes.add("pentagon")
    println(shapes)
    shapes.remove("pentagon")
    println(shapes)

    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    val fruit = mutableSetOf("apple", "banana", "cherry", "cherry")

    println(readOnlyFruit)

    val juiceMenu = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(juiceMenu)
    println("The value of apple juice is ${juiceMenu["apple"]}")
    juiceMenu["coconut"] = 200
    println(juiceMenu)
    juiceMenu.remove("apple")
    println(juiceMenu)
    println("Menu keys ${juiceMenu.keys}")
    println("Menu values ${juiceMenu.values}")
    println("kiwi" in juiceMenu)

}