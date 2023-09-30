/*
1번 과제 : 간단한 계산기
숫자, 연산자, 숫자를 입력 받으면 그 결과가 출력되는 프로그램

ex)
1
+
2

결과 : 3
 */

fun main(args: Array<String>) {
    val num1 = readln().toInt()
    val oper = readln()
    val num2 = readln().toInt()
    val result: Int?

    when(oper) {
        "+" -> result = num1 + num2
        "-" -> result = num1 - num2
        "*" -> result = num1 * num2
        "/" -> result = num1 / num2
        "%" -> result = num1 % num2
        else -> result = null
    }

    println("결과 : ${result}")
}