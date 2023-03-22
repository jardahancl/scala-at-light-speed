package com.rockthejvm

import scala.concurrent.Future
import scala.util.Try
import scala.util.Success
import scala.util.Failure
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App{

    // lazy evaluation - usefun in infinit collections
    lazy val aLazyValue = 2
    println(aLazyValue)
    lazy val lvSideEfect = {
        println("I am lazy")
        42
    }
    // here it is used
    val eaferValue = lvSideEfect + 1


    // pseudo-collections: Option, Try
    def methodWhichCanReturnNull(): String = "Hello"
    val stringProcessing = Option(methodWhichCanReturnNull()) match {
        case Some(string) => s"I obtained valid string: $string"
        case None => "I obtained nothing" 
    }
    println(stringProcessing)

    def methodWhichCanThrowException(): String = throw new RuntimeException
    val stringProcessing2 = Try(methodWhichCanThrowException()) match {
        case Success(validValue) => s"I obtained valid string: $validValue"
        case Failure(e) => s"I obtained an exception: $e"
    }
    println(stringProcessing2)

    // Threading, asynchronious programming


    //      Implicits basics
    // #1 implicit arguments
    def aMethodWithImplicitArgs(implicit arg: Int): Int = arg + 1
    implicit val myImplicitInt = 42
    println(aMethodWithImplicitArgs)    // 43

    // #2 implicit conversions
    implicit class MyRichInterger(n: Int) {
        def isEven(): Boolean = n % 2 == 0
    }
    println(23.isEven())    // new MyRichInterger(23).isEven()



  
}
