fun main(args: Array<String>) {
    val operend1 = readln().toInt()
    val operator = readln()
    val operend2 = readln().toInt()
    print("결과: ")
    when (operator) {
        "+" -> println(operend1 + operend2)
        "-" -> println(operend1 - operend2)
        "*" -> println(operend1 * operend2)
        "/" ->
            if (operend2 == 0) println("Error")
            else println(operend1 / operend2)

        else -> println("Error")
    }
}