
fun main(){ //Doesnt require a class like Java

    //Declaring variables

    var a = 5 //Values can be changed (mutable)
    val b = 10 //Values cannot be changed (immutable)
    var c : Int //Variable with data type

    //Declaring Arrays

    val numArray  = arrayOf<Int>(1, 3, 4, 6, 88)  //Integer array
    val charArray = arrayOf('a', 'b', 'c')  //character array
    val stringArray = arrayOf("Gaga", "Kevin", "Test")  //string array

    //Printing Variables

    println("$a and $b")  //Printing strings
    println("Addition: ${a+b}")   //Print message and go to next line
    println("Addition: " + (a+b))   //Different ways to print line
    println("Unary ${++a}") //Pre increment operator
    println(a > b)  //Greater than operator

    //taking Inputs
    print("Enter Input: ")
    val inputData = readLine()  //taking input
    println("Input data: $inputData")      //Printing input data

    //If Statement

    val result = if(a == 5){    //the last statement of condition will be assigned to result
        print(a)
    }else{
        print("LOL")
        "50"    //will be assigned to result since "els will be executed"
    }
    println(result)

    //When statement

    when(a){    //kinda similar to switch case
        10-> println("10")  //if a is 10 then this print will be executed
        5-> println("5")
        6, 7, 8-> println("6 or 7 or 8")  //if a is either of the 3 then it will be executed
        11-> {
            println("11")   //Multiple statements can be executed using braces
            println("11")
        }
        in 12..99-> println("Between 12 to 99") //"in num1..num2" will execute for numbers between num1 and num 2
    }

    //For loop

    for (i in stringArray)  //prints all values of array
        println(i)

    for (i in 1..5)    //printing value in range
        println("For $i ")

    //While Loop

    var x=0
    while (x < 5){
        x++ //Or x+=1 Or x = x+1
        println("While" + x) //Or print("${x++}")
    }

    //Do while loopsd

    do {
        println("DoWhile=>X: ${x++} ")
        if (x==6) continue  //same as other languages i.e skip further statement in current iteration
        if (x==7) break     //same as other languages i.e exit loop
    }while (x<10)

    //Calling Functions

    one()   //Unit or void or function with no return type
    two(4)  //function with int parameter and return type
    three(3)    //function with undefined(not null) parameter i. Any
    three("Gagandeep")   //function with undefined(not null) parameter i. Any
    four()  //Function with default parameter
    four("Pokemon") //Passing argument to function with default parameter

    //lambda function

    val lambda: (Int) -> Unit =  {s: Int -> println(s)}
    multiply(4, 5, lambda)

    //Inline Functions

    inlineFunction {}

    //Try Catch finally

    try {
        val res = 100 / 0
        println("Result: $res")
    }catch (error: ArithmeticException){    //object: ClassOfExceptionThrown
        println(error)
    }finally {
        println("Executed finally") //not compulsory to write (will always execute if written)
    }

    //Returning values using try catch in a function
    println("Returned value: ${convert("4")}")  //Printing return value
    println("Returned value: ${convert("Gaga")}")  //Printing return value

    //Multiple Catch blocks

    val test = IntArray(3)
    try { print(test[3]) }  //will look for catch block with OutOfBoundException
    catch (error : ArithmeticException){println("Error: $error")}   //will not be executed
    catch (error : ArrayIndexOutOfBoundsException){println("Error: $error")}    //will be executed

    //Nested Try Catch Block

    var arrayOne = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    var arrayTwo = arrayOf(1, 0, 4, 0)
    try {
        for (i in arrayOne){
            try {
                println("${arrayOne[i]}/${arrayTwo[i]} = ${arrayOne[i]/arrayTwo[i]} ")
            }catch (error : ArithmeticException){
                println("Can't divide by 0")
            }
        }
    }catch (error: ArrayIndexOutOfBoundsException){
        println(error)
    }

    //try catch throw

    var z = 10
    try {
        if (z < 11) //condition on which an exception is thrown
            throw ArithmeticException("Thrown Arithmetic Exception")
    }catch (error: ArithmeticException){
        println(error)  //displaying error thrown by try block
    }

    //Null and non nullable

    var n : Int? //On removing "?" we won't be able too assign null
    n = null    //we are specifying a datatype that means it can't be null, so we use "?" to make it null

    //Unsafe and Safe Cast

    var str : Any? = null // "?" makes variable nullable, without that it cant have null values
    var strTwo : String? = str as? String
    println("Casted Value: $strTwo")

    //Elvis Operator

    var strThree : String? = null
    var strFour : String? = "GaGa"

    var lengthThree : Int = if (strThree != null) strThree.length else -1
    var lengthFour : Int = strFour?.length ?: -1    //elvis Expression of above statement

    //Collection

    //Lists are immutable by default
    var listOne = listOf("Hi", "hello", 5)  //List of type "any"
    var listTwo : List<String> = listOf<String>("Hi", "hello") //List of type string

    for (i in listOne) println("Item: $i")

    //Immutable list
    var listThree = mutableListOf<Any>("Gagan", "Loves", "things")
    listThree.add(1, "Music")  //Item can be added since its mutable, item added at index 1
    listThree.add("Painting")  //Item added in end

    //ArrayList
    var arrayListOne = arrayListOf<Any>(1, 2, "3", 4)   //are always mutable (modifiable)
    var arrayListTwo : ArrayList<Any> = arrayListOf<Any>(1, 2, "3", 4)

    for (i in arrayListTwo) println("ArrayList item: $i")
    for (i in 0 until arrayListTwo.size-1) println("ArrayList item ${arrayListTwo.get(i)}")    //Or arrayListTwo[i]

    //Maps (Key Value Pairs)
    var mapOne = mapOf<Any, Any>(1 to "One", "2" to 2, 3 to "Three")
    var mapTwo : Map<Any, String> = mapOf<Any, String>(1 to "One", "2" to "2", 3 to "Three")

    var key = mapOne.keys   //making an array of keys
    var values = mapOne.values

    for (k in key) println("Keys: $k")  //displaying keys
    for (v in values) println("Values: $v")

    //Hash Map
    var hashMapOne = hashMapOf<Any, Any>()
    hashMapOne.put(1, "1")  //method 1 to put data
    hashMapOne.put(2, "2")
    hashMapOne[3] = "Lol" //method 2 to put data
    hashMapOne[4] = "4"
    var hashMapTwo : HashMap<Int, String> = hashMapOf<Int, String>(1 to "1", 2 to "2")  //Method 3 to add data using hashMapOf()

    for (i in hashMapOne.keys)
        println("Key $i, Value ${hashMapOne[i]}")

    //Mutable Hash Map

    var mutableHashMap = mutableMapOf<Any, Any>(1 to "1", 2 to "2")
    mutableHashMap.put(3, "3")

    //Sets

    var setOne = setOf<Any>(1, 2, 3, 6, 8)  //are immutable
    for( i in setOne) println("Set Item: $i")

    //mutable sets
    var setTwo = mutableSetOf<Any>(1, 4, 6)
    setTwo.add(7)   //Allows adding of data since mutable

    //Hash set
    var hashSetOne = HashSet<Int>(4)
    var hashSetTwo = hashSetOf(1, 4, 5, 6)

    //Creating an Obect of class
    var carOne = Car(20, 240, "G4")
    println("Model: ${carOne.getModel()}")
    println("Calling Inner class: ${carOne.Wheel().wheelCount()}")

    //Data class is used to store data
    var dataClassObject = DataClass("Gagan", "Love")
    println(dataClassObject)    //such print operation will not work for other class

    //Sealed class object
    var square = Shape.Square(4.0)

    //Calling an extended function
    carOne.Test()

    //Generic methods
    var genericOne = arrayListOf(1, 4, "5")
    println(genericOne)

    //Range type variable
    var rangeVariable = 1..9
    println("Range Variable: $rangeVariable")   //will print 1..9
    for (i in rangeVariable) println("Range Value is: $i")    //will print all values between 1 to 9
    for (i in 100 downTo 90) println("DownTo Value is: $i")    //will print values from 100 to 90
    for (i in 100 until 110) println("Until Value is: $i")    //will print values from 100 to 110
    for (i in 10 until 25 step 5) println("Until, Step Value is: $i")    //will print values from 10 to 25, +5 at once

    //Regex (match pattern)
    var regenString = "test@email.com"
    var regenPattern = Regex(".com")
    var regexResult = regenPattern.containsMatchIn(regenString)
    print("Regex Result: $regexResult")

    //Calling Java from Kotlin
    JavaClass.Print()
    JavaClass.a = 10

    //Calling Kotlin from Java


}

fun one(): Unit {  //Unit return type(void return type )
    println("Function One")
}
fun two(x: Int): Int {
    println("Function Two: $x")
    return x
}
fun three(x: Any): Any{ //Parameter and return type are "var" to unspecified but not void
    println("Function Three: $x")
    return x
}
fun four(x: Any = "Monster"): Any{  //Function with default arguments
    println("Function Four: $x")
    return x
}
fun multiply(num1: Int, num2: Int, lambda: (Int) -> Unit){  //Lambda function
    lambda(num1 * num2)
}
inline fun inlineFunction(myFun:() -> Unit){    //Inline function
    myFun()
        println("Inline function code")
}
fun convert(stringVariable: String): Int {
    return try {
        stringVariable.toInt()
    }catch (error : NumberFormatException){
        0
    }
}

//Creating classes
//open prefix allows it to be inherited
open class Car(private var currentSpeed: Int, private var maxSpeed: Int, private var model: String) {
    public var testVar : Any = "testVariable"
    open public var overrideProperty : Int = 4
    init {  //has no parameter, called before constructor
        println("hihi")
    }

    inner class Wheel{
        var wheels = 4

        fun wheelCount(){
            println("Wheel Count $wheels")
        }
    }

    fun getModel ()  : String {return model}
    //must be written open to be overridden
    open fun setMaxSpeed(maxSpeed: Int){
        this.maxSpeed = maxSpeed
    }
    fun setModel(model : String){
        this.model = model
    }
    fun setCurrentSpeed(currentSpeed : Int){
        this.currentSpeed = currentSpeed
    }
}

//Parent class must be written with "open" prefix to inherit

class Ferari : Car(1, 1, "") {  //need to pass value to parent constructor

    override var overrideProperty: Int = 40

    fun getCurrentSpeed(){
        testVar = 4//accessing variable of parent
    }

    override fun setMaxSpeed(maxSpeed: Int) {//mot writing override or making parent function open will throw error
        super.setMaxSpeed(maxSpeed)
        println("Child class")
    }

}

abstract class AbstractClass{   //An abstract class cannot be instantiated
    abstract fun name() //making an abstract method require abstract prefix
}
 data class  DataClass(var stringOne: String, var stringTwo: String){   //Purely used to store data
 }

//Sealed class

//Abstract by default
//Cannot be instantiated
sealed class Shape{
    class Circle(var radius: Double)
    class Square(var length: Double)

}

fun Car.Test(){ //Creating extension of Car class (Adding additional functionality to current class)
    println("This is an extension class")
}

//Creating Generic Method
//Can be made only for Collections: ArrayList, List, Sets, Maps, hashSet
fun <T>Print (value: ArrayList<T>){
    println(value)
}