package com.dkus.misc.examples

/**
  * @author aschwartz on 6/9/16 (#)
  */
object Lists {

  def append() = {

    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    val element = 0

    var appended = List.empty[Any]

    println("works only for list:")
    appended = list1 ::: list2
    println(s"$list1 ::: $list2 = " + appended)

    appended = element :: list1
    println(s"$element :: $list1 = " + appended)

    println("")

    println("works for all traversables:")
    appended = list1 ++ list2
    println(s"$list1 ++ $list2 = " + appended)


    appended = element +: list1
    println(s"$element +: $list1 = " + appended)

    appended = list1 :+ element
    println(s"$list1 :+ $element = " + appended)

    println("")
    println("--------------")

    appended = list1 :: list2
    println(s"$list1 :: $list2 =  " + appended)
  }


  def main(args: Array[String]): Unit = {
    append()
  }

}
