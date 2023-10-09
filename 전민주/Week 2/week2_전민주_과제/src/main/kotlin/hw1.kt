fun main(){

    var number1 = readln().toInt()
    var op = readln()
    var number2 = readln().toInt()

    var result: Int = 0
    when(op){
        "+" -> result = number1 + number2
        "-" -> result = number1 - number2
        "*" -> result = number1 * number2
        "/" -> result = number1 / number2
    }

    println("결과 : ${result}")

}