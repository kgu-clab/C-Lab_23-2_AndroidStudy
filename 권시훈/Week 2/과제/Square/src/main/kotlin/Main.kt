/*
2번 과제 : 사각형 클래스
사각형의 가로 길이와 세로 길이를 입력 받은 후, 클래스에 저장하고 클래스 내부에 생성한 함수를 통해서 넓이와 둘레를 구하는 프로그램

ex)
2
3

사각형의 넓이 : 6
사각형의 둘레 : 10
 */
fun main(args: Array<String>) {
    class Square(
        var width: Int,
        var height: Int
    ){
        fun getArea() = width * height
        fun getRound() = (width + height) * 2
    }

    var obj1 = Square(width = readln().toInt(), height = readln().toInt())

    println("사각형의 넓이 : ${obj1.getArea()}")
    println("사각형의 둘레 : ${obj1.getRound()}")
}