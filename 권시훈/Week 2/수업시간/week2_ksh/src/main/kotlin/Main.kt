fun main(args: Array<String>) {
    /*
    var name="권시훈" // kotlin은 변수타입을 추론해줌
    var age=20
    var locate: String // 변수타입을 명시적으로 선언도 가능
    val locate2: String // 상수는 val로 선언 단 초기값 없어도 가능
    val language = "kotlin"

    locate2 = "hello"
//    locate2 = language // val에 이미 값을 저장해서 안됨

    locate = "경기드림타워"

    var isNull: String? = "notNull"; // 널값을 저장가능한 변수선언법
    isNull = null;
    
    var num: Int? = null;
    num = num ?: 0 + age; // null일경우 0으로 처리
    // num = num!! + 2; // 절대 null이 아니라고 선언

    println("제 이름은 $name 입니다. 나이는 ${age}살입니다.") // 문자열 내부에 변수사용법
    println(isNull); // null 출력은 "null"
     */

    /*
    var input = readln().toInt()

    println(input)
     */
/*
    var tmpList = List<Int>(10){0} // 0값 10개짜리 List
    var tmpList2:List<Int> = listOf()

    var mutable: MutableList<Int> = mutableListOf();

    tmpList += 1 // 뒤에 추가
    // tmpList[0] = 3 // 이건 수정안됨 List는 기본적으로 immutable

    mutable[0] = 5 // 이건 수정가능

    println(tmpList)


 */
/*
    class Myclass(
        val name: String,
        var age: Int,
        val height: Double,
        val weight: Double
    ){
        fun printInfo() {
            println("name: ${this.name} age: ${this.age}")
        }
    }

    var sihun = Myclass(name = "권시훈", age = 20, height = 174.7, weight = 0.0)

    sihun.printInfo()

 */
    /*

    fun sum(a:Int, b:Int) = a + b
    fun foo(name: String) = println(name)

    fun getName(name: String = "sihun"): String{
        return "name: " + name
    }

    println(getName())

     */
    /*

    for(i in 1 .. 10) { // 1부터 10까지
        println(i)
    }

    for(i in 1 until 10){ // 1부터 9까지
        println(i)
    }

    for(i in 0 .. 10 step 2) { // 2개씩 뜀
        println(i)
    }

    for(i in 10 downTo  0)  { // 반대로
        println(i)
    }

    for(i in 10 downTo 0 step 2){ // 반대로 2개씩
        println(i)
    }

    val list = List<Int>(10){0}

    list.forEach { // list 순회
        println(it)
    }
    
    repeat(10) {// 이건 break못함 it = 0~9
        println(it)
    }

    //while(true){}
     */
    /*
    var age = 20;

    when(age) {
        20 -> println("age = 20")
        22 -> println("age = 22")
        100 -> println("???")
        else -> println("error")
    }

     */

}