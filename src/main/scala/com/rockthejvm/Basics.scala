package com.rockthejvm

class Basics extends App{

    //def value
    val meaningOfLife: Int = 42

    // Int, Boolean, Char, Double, Float, Long, Short, Unit
    val aBoolean = false

    // Strings and string operations
    val aString = "I love Scala"
    val aComposedString = "I" + " " + "love" + " " + "Scala"
    val anInterpolatedString = s"The meaning of life is $meaningOfLife"
  
    // expressions = structures that can be reduced to a value
    val anExpression = 2 + 3

    // if-expression
    val ifExpression = if (meaningOfLife > 43) 56 else 999
    val chainedIfExpression = 
        if (meaningOfLife > 43) 56 
        else if (meaningOfLife < 43) 999
        else 0

    // code blocks
    val aCodeBlock = {
        // definitions
        val aLocalValue = 67

        // value of the block = value of its last expression
        aLocalValue + 3
    }

    // define functions
    def myFunction(x: Int, y: String): String = {
        y + " " + x
    }

    // recursive function
    def factorial(n: Int): Int = 
        if (n <= 0) 1
        else {
            println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
            val result = n * factorial(n-1)
            println("Computed factorial of " + n)

            result
        }
    
    // In Scala we don't use loops or iteration, we use RECURSION

    // the Unit type = no meaningful value === 'void' in other languages
    // type of side effects
    println("Hello, Scala")

    def myUnitReturningFunction(): Unit = println("Hello, Scala")

    def theUnit = ()
    






}
