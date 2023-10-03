/*
3번 과제 : 숫자 리스트
숫자를 입력받아 리스트에 저장하고, 사용자가 'exit'를 입력하면 리스트와 합계, 평균, 최대값, 최소값 출력
단, 입력받으면서 연산 금지

ex)
3
5
4
11
exit

지금까지 입력된 수 : 3 5 4 11
합계 : 23
평균 : 5.75
최대값 : 11
최소값 : 3
 */
fun main(args: Array<String>) {
    val numList: MutableList<Int> = mutableListOf()
    var input: String

    while(true) {
        input = readln()
        if(input == "exit") break
        numList += input.toInt()
    }

    print("지금까지 입력된 수 : ")
    numList.forEach{
        print("${it} ")
    }
    println()

    println("합계 : ${numList.sum()}")
    println("평균 : ${numList.average()}")
    println("최대값 : ${numList.max()}")
    println("최소값 : ${numList.min()}")
}