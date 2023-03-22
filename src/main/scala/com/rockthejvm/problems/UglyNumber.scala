package com.rockthejvm.problems

import scala.annotation.tailrec

object UglyNumber extends App{

    def uglyNumber(input: Int): Boolean = {
        @tailrec
        def uglyNumberTailRec(input: Int): Boolean = {
            if (input == 1) true
            else if (input % 2 == 0) uglyNumberTailRec(input / 2)
            else if (input % 3 == 0) uglyNumberTailRec(input / 3)
            else if (input % 5 == 0) uglyNumberTailRec(input / 5)
            else false
        }

        uglyNumberTailRec(input)
    }
    
    val result_pairs = List(6, 25, 100, 14, 39, 17*37).map(x => (x, uglyNumber(x)))

    def writer(number: Int, result: Boolean): Unit = {
        result match {
            case true => println(s"Number $number is an ugly number.")
            case false => println(s"Number $number is not an ugly number.")
        }
    }

    for {
        (number, result) <- result_pairs
    } yield writer(number, result)

    def nthUgly(index: Int): Int = {
        @tailrec
        def nthUglyTailRec(subindex: Int, counter: Int): Int = {
            if (subindex == index && uglyNumber(counter)) counter
            else if (uglyNumber(counter)) nthUglyTailRec(subindex + 1, counter + 1)
            else nthUglyTailRec(subindex, counter + 1)
        }

        nthUglyTailRec(1, 1)
    }

    println(nthUgly(10))
    println(nthUgly(10))

}
