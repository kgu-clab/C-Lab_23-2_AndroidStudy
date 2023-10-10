fun main(args: Array<String>) {
    class Rectangle(val width: Int, val length: Int) {
        fun area() {
            println("사각형의 넓이: ${width * length}")
        }

        fun perimeter() {
            println("사각형의 둘레: ${2 * (width + length)}")
        }
    }
    print("가로길이: ")
    val width = readln().toInt()
    print("세로길이: ")
    val length = readln().toInt()

    val rectangle = Rectangle(width, length)
    rectangle.area()
    rectangle.perimeter()
}