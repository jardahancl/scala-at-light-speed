package com.rockthejvm

object FunctionalProgramming  extends App{
  
    class Person(name: String) {
        def apply(age: Int): Unit = println(s"I am $age years old.")
    }
    val bob = new Person("Bob")
    bob.apply(43)
    bob(43) // equivalent to bob.apply(43)

    /*
        Scala runs on the JVM
        Functional programming:
            - compose functions to create new functions
            - pass functions as arguments
            - return functions as results
        
        Conclusion: FunctionX types = Function1 to Function22
    */
    val simpleIncrementer = new Function1[Int, Int] {
        override def apply(arg: Int): Int = arg + 1
    }
    simpleIncrementer.apply(23) // 24
    simpleIncrementer(23) // 24

    // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

    val stringConcatenator = new Function2[String, String, String] {
        override def apply(arg1: String, arg2: String): String = arg1 + arg2
    }
    println(stringConcatenator("Hello ", "Joe"))
    // shorter version
    val doubler: Function1[Int, Int] = (x: Int) => 2 * x





}
