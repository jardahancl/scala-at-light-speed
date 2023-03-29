package com.rockthejvm.problems

import scala.annotation.tailrec

sealed abstract class BTree[+T] {
  def value: T
  def left: BTree[T]
  def right: BTree[T]
  def isEmpty: Boolean

  /**
    * Easy problems
    */
  def isLeaf: Boolean
  def collectLeaves: List[BTree[T]]
  def leafCount: Int

  /**
    * Medium problems
    */
  def size: Int


}

case object BEnd extends BTree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException
  override def left: BTree[Nothing] = throw new NoSuchElementException
  override def right: BTree[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true

  /**
    * Easy problems
    */
  override def isLeaf: Boolean = true
  override def collectLeaves: List[BTree[Nothing]] = List()
  override def leafCount: Int = 0

  /**
    * Medium problems
    */
  override def size: Int = 0
}

case class BNode[+T](override val value: T, override val left: BTree[T], override val right: BTree[T]) extends BTree[T] {
  override def isEmpty: Boolean = false

  /**
    * Easy problems
    */
  override def isLeaf: Boolean = left.isEmpty && right.isEmpty
  override def collectLeaves: List[BTree[T]] = {
    @tailrec
    def collectLeavesTailRec(toProcess: List[BTree[T]], leaves: List[BTree[T]]): List[BTree[T]] = {
      if (toProcess.isEmpty) leaves
      else if (toProcess.head.isEmpty) collectLeavesTailRec(toProcess.tail, leaves)
      else if (toProcess.head.isLeaf) collectLeavesTailRec(toProcess.tail, toProcess.head :: leaves)
      else {
        collectLeavesTailRec(toProcess.head.left :: toProcess.head.right :: toProcess.tail, leaves)
      }
    }
    collectLeavesTailRec(List(this), List())
  }
  override def leafCount: Int = collectLeaves.length

  /**
    * Medium problems
    */
  override val size: Int = 1 + left.size + right.size
}

object BinaryTreeProblems extends App {
  val tree = BNode(1,
    BNode(2,
      BNode(3, BEnd, BEnd),
      BNode(4,
        BEnd,
        BNode(5, BEnd, BEnd)
      ),
    ),
    BNode(6,
      BNode(7, BEnd, BEnd),
      BNode(8, BEnd, BEnd)
    )
  )

  /**
    * Easy problems
    */
  println(tree.collectLeaves)
  println(tree.leafCount)

  /**
    * Medium problems
    */
  val degenerate = (1 to 100000).foldLeft[BTree[Int]](BEnd)((tree, number) => BNode(number, tree, BEnd))
  println(degenerate.size)
}
