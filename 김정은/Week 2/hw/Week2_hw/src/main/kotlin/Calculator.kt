fun main(){
    var result: Int = 0

    print("첫번째 숫자를 입력하세요 : ")
    var num1 = readln().toInt()

    print("연산자를 입력하세요 : ")
    var cal = readln()

    print("두번째 숫자를 입력하세요 : ")
    var num2 = readln().toInt()

    when(cal){
        "+" -> result = num1+num2
        "-" -> result = num1-num2
        "*" -> result = num1*num2
        "/" -> result = num1/num2
        "%" -> result = num1%num2
        else -> println("잘못 입력하셨습니다")
    }

    println("결과 : ${result}")
}