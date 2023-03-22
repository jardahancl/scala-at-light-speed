package com.rockthejvm

object ContextualAbstractions extends App {

    // val anOrderedList = List(2, 1, 3, 4).sorted //sort ascendingly
    
    // given descendingOrdering = Ordering.fromLessThan(_ > _) // makes the previous line sort descendingly

    // trait Combinator[A] {
    //     def combine(a: A, b: A): A
    // }

    // def combineAll[A](list: List[A])(using combinator: Combinator[A]): A = 
    //     list.reduce((a, b) => combinator.combine(a, b))
    
    // given intCombinator: Combinator[Int] = new Combinator[Int] {
    //     override def combine(a: Int, b: Int): Int = a + b
    // }

    // val theSum = combineAll(List(2, 1, 4, 3))
    // println(theSum)


    // /*
    // Given places
    // - local scope
    // - imported scope
    // - the companions of all the types involved in the call
    //     - companion of List
    //     - the companion of Int
    // */

    // extension (string: String)
    //     def greet(): String = s"Hi, my name is $string, I love Scala"
    // val daielsGreeting = "Daniel".greet() // type enrichment

  
}
