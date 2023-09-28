fun main(){
    var numList: MutableList<Int> = mutableListOf()
    var input: String
    var cnt: Int = 0

    //수 입력 받기
    while(true) {
        print("숫자를 입력하세요 : (exit을 입력하면 종료합니다)")
        input = readln()
        if(input=="exit") break
        else {
            numList += input.toInt()
            cnt++
        }
    }

    //입력된 수
    println("지금까지 입력된 수 : ${numList}")

    //합계
    var sum: Int = 0
    for (i in 0 until cnt) {
        sum += numList[i]
    }
    println("합계 : ${sum}")

    //평균
    var avg: Double = sum.toDouble()/cnt
    println("평균 : ${avg}")

    //최대값
    var max: Int = numList[0]
    for(i in 1 until cnt) {
        if(max<numList[i]) max = numList[i]
    }
    println("최대값 : ${max}")

    //최소값
    var min: Int = numList[0]
    for(i in cnt-1 downTo 0) {
        if(max<numList[i]) min = numList[i]
    }
    println("최소값 : ${min}")
}