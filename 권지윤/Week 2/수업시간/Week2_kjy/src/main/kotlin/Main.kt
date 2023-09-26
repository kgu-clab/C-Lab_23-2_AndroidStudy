import javax.swing.tree.FixedHeightLayoutCache

fun main(args: Array<String>) {
     var age = 22

     when(age){
          20-> println("20살")
          22-> println("당첨")
          30-> println("꽝")
          else-> println("오류")
     }

     //role1,role2,rple3,role4
     var role="role1"

     when(role){
         // "role1"-> //
               ///
     }

     var List2=List<Int>(10){1}
     //List2.forEach()

     while (true){

     }

     repeat(10){
          //10번 반복
          //break, continue불가능
     }
     /*반복문*/
     for(i in 0 .. 10 step 2){//until:<=,<   .. :<=,<=
          //step n: 한번에 n씩 증가
          //downTo n: 10부터 0까지 n씩 내려감
          println(i)
     }

     /*
     /*함수만들기*/
     fun getName(name: String="익명",/*등호 왼쪽에 값이 없으면 오른쪽*/age: Int/*매개변수인자*/): String/*리턴타입*/{
          return "jiyoon"+name
     }//괄호랑 return빼고 =로 연결해서 써도 됨

     println("${getName(name = "이름", age = 21)}")
     println("${getName("이름", 21)}")//가능
     println("${getName( age = 21)}")
     //println("${getName( 21)}")//불가능
*/
     /*
/*클래스선언*/
     class info(//줄바꿈은 가독성때문, 콤마 꼭 써야함
          var name: String,
          var age: Int,
          var height: Double,
          var weight: Double
     ){//내부에 함수 안 만들면 {}전체생략가능
          fun printInfo(){//함수
               println("제 이름은 ${name}입니다. 나이는 $age 입니다.")
          }
     }

     val jiyoon = info(name = "권지윤", age = 21,height=170.0,weight=0.0)

     println(jiyoon.age)
*/

    /* List333333333
    var tempList: List<Int> = listOf()//listOf하면 요소값이 변경안됨->Mutable
    var tempList2: MutableList<Int> = mutableListOf()

    //var일때는 mutable로 변환 가능, val일때는 불가능
    //tempList는 시작주소만 알고있음-> MutableList로 새로 할당하는건 var만 가능
    tempList+=1
    tempList+=1
    tempList+=1
    //리스트는 한번 할당하면 수정할 수 없음
    //에러---tempList[0]=2
    tempList= MutableList(9)
*/

    /*입력2222222222
    //readln()은 무조건 String으로 받음
    var input= readln().toInt()
    var input2= readln().toInt()
    println(input+input2)
*/

    /*111111111111
    var name:String = "권지윤" //:String 적는것 가능 근데 굳이 안 적어도 됨 (가독성 위해서 적는건 가능
    var age = 21
    var locate: String
    val classss="kotlin"//const같은거+바꾸면 안되는 값
    val locate2: Strin1g//가능

    locate="suji"
    locate2="good"//한 번 들어간 값이 바뀌지 않는 것
    age=33


    var Null:String?="no"//코틀린 null(전부소문자
    //타입 뒤에 물음표(널일수도 있는것/물음표 없ㅇ면 널 들어갈 수 없음
    println(Null)
    Null=null
    println(Null)

    var NullNum:Int?=22
    NullNum=NullNum!!+3//!!붙이면 연산가능하지만 널일수도 아닐수도 있는 경우에는 사용하면안됨
    //!!없이는 널인지 아닌지 알 수 없어서 연산불가능(에러
    //널일수도 있는 경우-엘비스연산자?:
    NullNum=NullNum?:0+3//==(NullNum?:0)+3
    // ->앞에 애가 널이면 0+3, 널이 아니면 저장된 값+3
    NullNum=null



    println("제 이름은 $name 입니다. 나이는 $age 입니다.")//안 띄어쓰면 변수 구분 못함
    println("제 이름은 ${name}입니다. 나이는 ${age+age/*괄호안에 연산가능*/}입니다.")
    //$출력: \$
*/
}