fun main(args: Array<String>) {
    val numList: MutableList<Int> = mutableListOf()
    while (true) {
        val input = readln()
        if (input == "exit")
            break
        val num: Int = input.toInt()
        numList.add(num)
    }
    print("지금까지 입력된 수: ")
    for (output in numList) {
        print("$output ")
    }

    val sum = numList.sum()
    val avg = numList.average()
    val max = numList.max()
    val min = numList.min()
    println("합계: $sum")
    println("평균: $avg")
    println("최댓값: $max")
    println("최솟값: $min")
}