fun main(args: Array<String>) {
    var fnum= readln().toInt()
    var cal= readln()[0] //char 형을 사용
    var bnum= readln().toInt()

    val calculate = numbers(num1 = fnum, oper = cal, num2 = bnum)

    when(calculate.oper){
        '+' -> println("결과: ${calculate.plus()}")
        '-' -> println("결과: ${calculate.minus()}")
        '*' -> println("결과: ${calculate.multi()}")
        '/' -> println("결과: ${calculate.divide()}")
    }

}

class numbers(
    var num1: Int,
    var oper: Char,
    var num2: Int

){
    fun plus(): Int { // 더하기
        return(num1 + num2)
    }
    fun minus(): Int { // 빼기
        if(num2>num1){ // 뒤에 나오는 수가 더 큰 경우
            return(-1*(num2-num1))
        }
        else{ // 정상적인 경우
            return(num1-num2)
        }
    }
    fun multi(): Int { // 곱하기
        return(num1*num2)
    }
    fun divide(): Float{ // 나누기
        var dnum1 = num1.toFloat() //나눗셈을 위한 형변환
        var dnum2 = num2.toFloat()
        return(dnum1/dnum2)
    }

}
