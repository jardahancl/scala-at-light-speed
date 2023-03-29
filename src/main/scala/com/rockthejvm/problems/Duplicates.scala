package com.rockthejvm.problems

object Duplicates extends App{

  def duplicates(list: List[Int]): Int = {
    var sortedList = list.sorted
    def duplicatesTailRec(list: List[Int], n: Int, m: Int): Int = {
      if (list.isEmpty) return n
      else if (list.length < 2) list.head
      else if (n == m) duplicatesTailRec(list.tail.tail, list.head, list.tail.head)
      else n
    }
    duplicatesTailRec(sortedList.tail.tail, sortedList.head, sortedList.tail.head)

  }

  def duplicatesOptimal(list: List[Int]): Int = list.foldLeft(0)(_ ^ _)


  println(duplicates(List(15, 8, 62, 8, 7, 15, 12, 12, 62, 9)))
  println(duplicates(List(2047, 2046, 2, 2)))
  println(duplicatesOptimal(List(15, 8, 62, 8, 7, 15, 12, 12, 62, 9)))
  println(duplicatesOptimal(List(2047, 2046, 2, 2)))


}
