package com.dkus.misc.examples.ninetynine

import com.dkus.misc.examples.ninetynine.artihmetic.S99Int

import scala.collection.mutable

/**
  * @author aschwartz on 6/8/16 (#)
  */

// http://aperiodic.net/phil/scala/s-99/

object Qs {

  def P02: Unit = {
    println(penultimate(List(1, 1, 2, 3, 5, 8)))
  }

  def penultimate(list: List[Int]): Int = {
    //    list(list.length-2)
    list.init.last

  }

  //  P07 (**) Flatten a nested list structure.
  //  Example:
  //    scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  //  res0: List[Any] = List(1, 1, 2, 3, 5, 8)

  def P07: Unit = {
    val input = List(List(1, 1), 2, List(3, List(5, 8)))
    println("input=  " + input)
    val output = flatten(input)
    println("output= " + output)
  }

  def flatten(list: List[Any]): List[Any] = {
    val traversedList = new mutable.ListBuffer[Any]()
    traverse(list, traversedList)
    traversedList.toList
  }

  def traverse(any: Any, traversedList: mutable.ListBuffer[Any]): Unit = {
    any.asInstanceOf[AnyRef] match {
      case v: Number => traversedList += v
      case list: List[Any] => list.foreach(traverse(_, traversedList))
    }
  }

  //  P14 (*) Duplicate the elements of a list.
  //    Example:
  //    scala> duplicate(List('a, 'b, 'c, 'c, 'd))
  //  res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

  def P14(): Unit = {
    val org = List('a, 'b, 'c, 'c, 'd)

    val duplicated = org.flatMap(a => List(a, a))
    println(duplicated)

  }

  //  P17 (*) Split a list into two parts.
  //    The length of the first part is given. Use a WindowTuple for your result.
  //  Example:
  //
  //    scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  def P17(): Unit = {
    val splitPos = 3
    val org = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

    val result = org.splitAt(splitPos)

  }

  //  P19 (**) Rotate a list N places to the left.
  //    Examples:
  //    scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
  //
  //  scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //  res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
  def P19(): Unit = {
    val pos = 3
    val org = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

    val posAdj = (org.length + pos % org.length) % org.length
    val rotated = org.drop(posAdj) ++ org.take(posAdj)

    println(posAdj)
    println(rotated)
  }

  //  P31 (**) Determine whether a given integer number is prime.
  //    scala> 7.isPrime
  //  res0: Boolean = true

  def P31(): Unit = {
    //    import arithmetic.S99Int

    val s7 = new S99Int(7)
    println(s7.isPrime)

    val s8 = new S99Int(8)
    println(s8.isPrime)
  }

  def main(args: Array[String]) {
    //    P02
    //    P07
    //    P31
    //    P14
    P19
  }
}
