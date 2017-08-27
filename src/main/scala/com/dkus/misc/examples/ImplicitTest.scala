package com.dkus.misc.examples

/**
  * @author aschwartz on 6/8/16 (#)
  */
object ImplicitTest {

  def test(implicit test:String):String = test+"_"

  def test2(input:Int):Int = input

  def main(args: Array[String]) {

    // Implicit parameter:
    implicit val input:String = "Hello"
    val result = test
    println(result)


    // Implicit conversion of Java Integer to Scala Int
    val integer = new Integer(1)
    test2(integer)

  }
}
