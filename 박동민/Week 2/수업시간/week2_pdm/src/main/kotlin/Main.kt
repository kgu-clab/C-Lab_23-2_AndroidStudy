fun main(args: Array<String>) {
    var age = 22

    when(age){
        20 -> println("20살")
        22 -> println("당첨")
        30 -> println("꽝")
        else -> println("오류")
    }



    // role1, role2, role3, role4
    var role = "role1"


    if (role == "role1"){

    }else if(role == "role2"){

    }



    repeat(10){

    }

    while (true){

    }

    /*
    var list2 = List<Int>(10){1}

    list2.forEach {

    }

     */

    /*
    for (i in 10 downTo 1){
        println(i)
    }
     */





    /*
    fun getName(age: Int, name: String = "dlr" ): String?{
        return "dongmin" + name
    }

    println("${getName(23)}")


     */

    /*
    class info(
        private val name: String = "jjj",
        var age: Int,
        val height: Double,
        val weight: Double
    ){
        fun printInfo(){
            println("제 이름은 ${name}입니다. 나이는 $age 입니다.")
        }

    }

    val Dongmin = info(name = "박동민", age = 24, height = 186.0, 0.0)



    Dongmin.printInfo()
     */


    /*
    val tempList: MutableList<Int>

    ///0000

    tempList = MutableList(9){9}

    println(tempList)

     */

    /*
    var input = readln().toInt()
    var input2 = readln().toInt()

    println(input + input2)
     */
    /*
    var name = "박동민"
    var age = 22
    var locate: String
    val locate2: String
    val classss = "kptlin"

    locate = "dusdhh"

    locate2 = "dusdqhh"
    //locate2 = "kk"



    var Null: String? = "no"

    println(Null)

    Null = null

    println(Null)



    val NullName: String? = null

    if (NullName == null){
        println("익명님 반갑습니다.")
    }else{
        println("${NullName}님 반갑습니다.")
    }

    println("${NullName ?: "익명"}님 반갑습니다.")


    //NullNum = NullNum!! + 3

    var NullNum: Int? = 22

    NullNum = (NullNum ?: 0) + 3

    println("null num = $NullNum")

    NullNum = null

    NullNum = (NullNum ?: 0) + 3

    println("null num = $NullNum")


    println("제 이름은 입니다. 나이는 ${age + age} 살입니다.")

     */
}