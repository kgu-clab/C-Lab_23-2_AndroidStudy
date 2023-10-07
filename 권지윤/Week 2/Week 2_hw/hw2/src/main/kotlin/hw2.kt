fun main() {

    class Rectangle(
        var width:Int,
        var height:Int
    ){
        fun getSize(num1:Int=width,num2:Int=height){
            println("사각형의 넓이: ${width*height}")
        }
        fun getArea(num1:Int=width,num2:Int=height){
            println("사각형의 둘레: ${width+height}")
        }
    }
    print("length: ")
    var length=readln().toInt()
    print("height: ")
    var width=readln().toInt()
    var box=Rectangle(width=length,height=width)
    box.getSize()
    box.getArea()
}