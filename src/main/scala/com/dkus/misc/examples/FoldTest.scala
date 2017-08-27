package com.dkus.misc.examples

/**
  * @author aschwartz on 6/19/16 (#)
  */
object FoldTest {

  def foldTest: Unit = {
    val list = List(1,2,3,4)

    val foldedSum = list.foldLeft(0)((b,a) => b+a)
    println(foldedSum)

    val foldedMultiply = list.foldLeft(1)((b,a) => b*a)
    println(foldedMultiply)

    val list2 = List(5,6,7,8)

    val zipped = list2.zip(list)
    println(zipped)

  }

  def main(args: Array[String]): Unit = {
    FoldTest.foldTest
  }

}
