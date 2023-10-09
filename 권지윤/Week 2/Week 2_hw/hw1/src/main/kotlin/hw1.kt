fun main() {
    //과제1
    var result = 0
    print("num1: ")
    var num1 = readln().toInt()
    print("cal: ")
    var cal = readln()
    print("num2: ")
    var num2 = readln().toInt()

    when (cal) {
        "+" -> result = num1 + num2
        "-" -> result = num1 - num2
        "*" -> result = num1 * num2
        "/" -> result = num1 / num2
    }
    println("$num1 $cal $num2 = $result")
}

