fun main(){
    class Rectangle(
        var width: Int,
        var height: Int
    ) {
        //넓이 계산
        fun calArea(num1: Int = width, num2: Int = height) {
            var area = num1 * num2
            println("사각형의 넓이 : ${area}")
        }
        //둘레 계산
        fun calSize(num1: Int = width, num2: Int = height) {
            var size = 2 * (num1 + num2)
            println("사각형의 둘레 : ${size}")
        }
    }
    var width: Int = readln().toInt()
    var height: Int = readln().toInt()

    var rectangle = Rectangle(width,height)

    rectangle.calArea()
    rectangle.calSize()
}