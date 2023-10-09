fun main(args: Array<String>) {

    var Width = readln().toInt()
    var Height = readln().toInt()

    val result = square(width = Width, height = Height)

    println("사각형의 넓이: ${result.aria()}")
    println("사각형의 둘레: ${result.circumference()}")

}




class square(
    var width: Int,
    var height: Int
){
    fun aria(): Int {
        return(width*height)
    }

    fun circumference(): Int {
        return((width+height)*2)
    }
}
