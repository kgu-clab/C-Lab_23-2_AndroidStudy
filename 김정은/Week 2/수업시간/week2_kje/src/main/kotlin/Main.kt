fun main(args: Array<String>) {
    /* 출력 */
//    print("Hello World!")
//    println("a")    //ln 붙이면 줄바꿈

    /* 변수 생성, 출력 */
    var name: String = "김정은"    //name은 string값, 이미 대입한 경우는 타입 명시할 필요 없음(명시해도 문제는 없음)
    var age = 22    //age는 int값
    var locate: String  //타입 명시, 값 대입 안 한 경우
//    locate = 32 //에러, String에 int값 대입한 경우
    val classs = "kotlin"   //val-const와 같음, 불변
//    classs = "java"     //불가능
    val classs2: String
    classs2 = "java"    //한 번만 할당가능하기 때문에 타입 정하고 값 대입해도 상관없음, 값 변경 불가능

//    println(name)
//    println("제 이름은 ${name}입니다. 나이는 ${age+age}살입니다") // $ 출력을 원하면 \$

    /* null 대입 */
    var Null: String? = "no"    //타입 뒤에 ? 붙이면 null 대입가능
    Null = null

    var NullNum: Int? = 22
//    NullNum += 2    //연산 불가능
    NullNum = NullNum!! + 3   //느낌표 두 개->null이 아니라고 컴파일러에게 알려줌, 절대 null이 아닌 경우에면 사용, null인 경우에 종료됨
    NullNum = (NullNum ?: 0) + 3  //엘비스 연산자, null이면 0, null이 아니면 3 반환, null값이면 ?: 우측값, null이 아니면 좌측값


    /* 입력받기 */
//    var input = readln()    //readln은 입력값을 다 String으로 받음
//    var input2 = readln().toInt()   // .toInt사용하면 Int값으로 입력받음


    /* 리스트 */
//    var tempList = List<Int>(10){5}     //길이가 10칸인 배열을 5로 초기화
    var tempList: MutableList<Int> = mutableListOf()    //Int 타입 리스트 생성, MutableList여야 리스트 값 변경 가능
    val tempList2: MutableList<Int> = mutableListOf()   //val 사용가능, 값 변환 가능, 객체 치환 불가능
//    tempList2 = MutableList(9){9}    //불가능
    tempList += 1   //리스트에 1을 넣음
    tempList[0] = 4     //MutableList이므로 값 변환 가능
//    println(tempList)

    val tempList3: MutableList<Int?>
    tempList3 = MutableList(9){null}

    /* 클래스 */
    class info(
        val name: String,  //생성자 자동 생성
        val age: Int,
    ){
        fun printInfo(){
            println("제 이름은 ${name}입니다. 나이는 ${age}입니다")
        }
    }
    var jungEun = info(name = "김정은", age = 21)  //클래스 객체 생설
//    println(jungEun.age)
//    jungEun.printInfo()

    /* 함수 */
    fun getName(name: String = "익명", age: Int): String{  //String값을 리턴하는 함수, 매개변수 값 없는 경우 기본값 사용
        return "JungEun" + name
    }
    fun getName2(name: String = "익명", age: Int): String = "JungEun" + name     //위의 코드와 같은 기능, = 뒤의 값 바로 반환

    println("${getName(age=21)}")     //반환된 값 출력됨, 매개변수 값 대입

    /* 반복문 */
    for (i in 0 until 10){      //for(변수 in 숫자 until 숫자) 0-10까지 출력
        println(i)
    }
//    for (i in 0 .. 10 step 2){}   //2씩 증가, until 대신 .. 이면 마지막값 포함 X
//    for (i in 10 downTo 1){}   //감소

    /* for-each */
    var list2 = List<Int>(10){1}
    list2.forEach{}

    /* while문 동일 */

    /* repeat */
    repeat(10){}    //중괄호 내부 10번 반복, break/continue 불가능

    /* when */
    var a = 22
    when(a){
        20 -> print("20살")      //a가 20인 경우 실행
        22 -> print("22살")      //a가 22인 경우 실행
        else -> println("오류")
    }

    var role = "role1"
    when(role){
        "role1" -> println("")
        "role2" -> println("")
        "role3" -> println("")
        else -> println("")
    }
}