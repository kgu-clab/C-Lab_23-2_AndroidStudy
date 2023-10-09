fun main(args: Array<String>) {
//    3번 과제 : 숫자 리스트
    var numList = arrayListOf<Int>()
    var size:Int=0
    while (true){
        var answer=readln()
        if (answer.equals("exit"))
            break
        numList.add(answer.toInt())
        size++
    }
    print("\n지금까지 입력된 수: ")
    var sum:Int=0
    var max:Int=numList.get(0)
    var min:Int=numList.get(0)
    for (i in 0 until size)
    {
        sum+=numList.get(i)
        if (numList.get(i)>max)
            max=numList.get(i)
        if (numList.get(i)<min)
            min=numList.get(i)
        print(numList.get(i))
        print(" ")

    }
    println("\n합계: ${sum}\n" +
            "평균: ${sum/size}\n" +
            "최댓값: ${max}\n" +
            "최솟값: ${min}")
}