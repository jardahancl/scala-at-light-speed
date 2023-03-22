package com.rockthejvm.problems

import scala.annotation.tailrec

object ListsRunLengthEncoding extends App{

    val input = List(1, 1, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 6)

    def rle[T](mylist: List[T]): List[(T, Int)] = {
        @tailrec
        def rleTailRec(remaining: List[T], current: (T, Int), aggregate: List[(T, Int)]): List[(T, Int)] = {
            if (remaining.isEmpty && current._2 == 0) aggregate
            else if (remaining.isEmpty) current :: aggregate
            else if (remaining.head == current._1) rleTailRec(remaining.tail, (current._1, current._2 + 1), aggregate)
            else rleTailRec(remaining, (remaining.head, 0), current :: aggregate) 
        }

        rleTailRec(mylist.tail, (mylist.head, 1), List())  
    }

    println(rle(input))
    println(rle(List("Toy", "Toy", "Toy", "Toy", "at", "at", "at", "how", "me", "me", "this")))

  
}
