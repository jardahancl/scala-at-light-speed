package com.rockthejvm.problems

import scala.annotation.tailrec

object ListsInsertionSort extends App{

    val input = List(1, 5, 2, 7, 8, 3, 7, 3, 4, 2, 4, 5, 6, 1)

    def insertByJardac(mylist: List[Int]): List[Int] = {
        @tailrec
        def insertTailRec(remaining: List[Int], current: Int, agg_head: List[Int], agg_tail: List[Int]): List[Int] = {
            if (remaining.isEmpty && current == 42) agg_head ::: agg_tail
            else if (remaining.isEmpty && agg_tail.isEmpty) agg_head :+ current
            else if (remaining.isEmpty && !agg_head.isEmpty && current <= agg_tail.head) agg_head ::: current +: agg_tail
            else if (remaining.isEmpty && !agg_tail.isEmpty) movePosition(remaining, current, agg_head, agg_tail)
            else if (agg_tail.isEmpty) insertTailRec(remaining.tail, remaining.head, List(), agg_head :+ current)
            else if (!agg_tail.isEmpty && current <= agg_tail.head) insertTailRec(remaining.tail, remaining.head, List(), agg_head ::: current +: agg_tail)
            else movePosition(remaining, current, agg_head, agg_tail)
        }

        def movePosition(remaining: List[Int], current: Int, agg_head: List[Int], agg_tail: List[Int]) = insertTailRec(remaining, current, agg_head :+ agg_tail.head, agg_tail.tail)

        insertTailRec(mylist.tail, mylist.head, List(), List())  
    }

    println(insertByJardac(input))
  
}
