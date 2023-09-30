fun main(args: Array<String>) {

    for(i in 0 .. 10){
        println(i)
    }

    for(i in 0 until 10){
        println(i)
    }

    for(i in 0 .. 10 step 2){

    }

    for(i in 10 downTo 1){

    }

    var list2 = List<Int>(10){1}

    list2.forEach{

    }

    repeat(10){//break 와 continue 불가

    }

    while(true){

    }

    var age = 22
    when(age){
        20 -> println("스무살")
        21 -> println("당첨")
        30 -> println("꽝")
        else -> println("오류")
    }

    /*var role = "role1"

    when(role){
        "role1" ->
    }*/

    /*fun getName(name: String = "익명", age: Int): String{
        return "minju" + name
    }

    println("${getName("이름", age = 22)}")
*/
    /*data class info(
        val name: String,
        val age: Int,
        val height: Double,
        val weight: Double
    ){
        fun printInfo(){
            println("제 이름은 ${name}입니다. 나이는 ${age}입니다.")
        }
    }

    val MinJu = info(name = "전민주", age = 22, height = 163.2, weight = 55.0)

    MinJu.printInfo()*/

    /*var tempList: MutableList<Int> = mutableListOf(); // mutableList는 val로 짜기
    //val로 설정한 애는 뭔가 할당되기 전까지는 할당가능. 한 번 할당 되면 그 뒤로는 재할당 불가

    tempList += 1;
    tempList += 1;
    tempList += 1;

    tempList[0] = 3;
    println(tempList)*/

    /*var input1 = readln().toInt();
    var input2 = readln().toInt();

    println(input1 + input2)*/

    /*println("Hello World!")
    var name = "전민주" // 변수는 무조건 var
    var age = 22 // 값 추론
    var locate: String // 아직 초기화는 안 했기 때문에 명시적으로 알려줌

    val classs = "kotlin" // 상수처럼. 못 바꿈
    locate = "수지구";

    println("제 이름은 ${name}입니다. 나이는 ${age}살입니다.")

    var Null: String? = "no"
    var NullNum : Int? = 32

    //NullNum = NullNum!! + 3

    NullNum = NullNum ?: 0 + 3 // 앨비스 연산자?*/

}