package com.dkus.misc.examples

/**
  * @author aschwartz on 6/8/16 (#)
  */
object Yield {

  case class Data(value:String)

  def main(args: Array[String]) {

    val list = List(Data("A"), Data("B"), Data("C"))
    val list2 = List(Data("D"), Data("E"))

    val results =
      for(entry1 <- list; entry2 <- list2)
        yield entry1.value+entry2.value

    println(results)
  }
}
