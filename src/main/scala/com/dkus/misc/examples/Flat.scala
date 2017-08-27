package com.dkus.misc.examples

/**
  * @author aschwartz on 6/8/16 (#)
  */
object Flat {

  def main(args: Array[String]) {
    val list = List(List("A", "B", "C"), List("D", "E"))
    println(list)
    val list2 = list.flatten
//    val list2 = list.flatMap(x => x)
    println(list2)
  }

}
