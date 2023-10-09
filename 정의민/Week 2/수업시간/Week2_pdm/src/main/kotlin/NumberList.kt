fun main(args: Array<String>) {
    val arr: MutableList<Int> = mutableListOf<Int>()
    while(true){
        var num = readln()
        if (num =="exit"){
            break
        }
        else{
            var Inum = num.toInt()
            arr.add(Inum)
        }
    }
//    println(arr.size) // 리스트에 원소들이 잘 들어갔나 확인

    println("지금까지 입력된 수: ${arr.joinToString(separator = " ")}") // 이 방법보다 효율적으로 대괄호를 제거할 수 있는 방법이 있나요?
    println("합계: ${arr.sum()}")
    println("평균: ${arr.average()}")
    println("최대: ${arr.max()}")
    println("최소: ${arr.min()}")

}

