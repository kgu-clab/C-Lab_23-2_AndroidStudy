fun main(){
    var list : MutableList<Int> = mutableListOf()
    while(true){
        var input = readln()
        if(input == "exit")
            break
        list += input.toInt();
    }

    var n = list.size

    fun printAllNumbers(){
        for(i in 0 until n){
            print("${list.get(i)} ")
        }
        println()
    }

    fun getSum() : Int{
        var result = 0
        for(i in 0 until n){
            result += list.get(i)
        }
        return result
    }

    fun getAverage() : Double{
        return (getSum().toDouble() / n)
    }

    fun getMax() : Int{
        var result = 0
        for(i in 0 until n){
            result = if(result < list.get(i)) list.get(i) else result
        }
        return result
    }

    fun getMin() : Int{
        var result = Int.MAX_VALUE
        for(i in 0 until n){
            result = if(result > list.get(i)) list.get(i) else result
        }
        return result
    }

    print("지금까지 입력된 수 : ")
    printAllNumbers()
    println("합계 : ${getSum()}")
    println("평균 : ${getAverage()}")
    println("최대값 : ${getMax()}")
    println("최소값 : ${getMin()}")
}