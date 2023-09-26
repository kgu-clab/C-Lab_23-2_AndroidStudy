fun main(args: Array<String>) {


    var age = 22

    when (age) {
        20 -> println("20살")
        22 -> println("22살")
        else -> println("오류")
    }

    /*repeat(10){

    }*/


    /*var list2=List<Int>(10){1}
    list2.forEach{

    }*/

    /*for(i in 0 .. 10 step 3){
        println(i)
    }*/

    /* fun getName(age: Int, name: String = "익명"): String = "Sumin" + name

     println("${getName(22)}")*/


    /*data class info(
        private val name: String,
        val age: Int,
        val height: Double,
        val weight: Double
    ){
        fun printInfo(){
            println("My name is ${name}. Age is ${age}.")
        }
    }

    val Sumin = info(name = "sumin", age = 22, height = 172.0, weight = 1.0)
    Sumin.printInfo()*/


    /*val tempList: MutableList<Int>
    tempList = MutableList(9){0}

    println(tempList)*/


}