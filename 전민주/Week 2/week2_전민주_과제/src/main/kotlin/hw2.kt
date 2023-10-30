fun main(){
    class Rectangle(
        var width: Int,
        var height: Int
    ){
        fun getArea(): Int{
            return (width * height)
        }

        fun getRound(): Int{
            return ((width + height) * 2);
        }
    }

    val myRectangle = Rectangle(width = readln().toInt(), height = readln().toInt())
    println("사각형의 넗이 : ${myRectangle.getArea()}")
    println("사각형의 둘레 : ${myRectangle.getRound()}")
}