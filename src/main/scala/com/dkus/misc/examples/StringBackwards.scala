package com.dkus.misc.examples

/**
  * @author aschwartz on 6/7/16 (#)
  */

object StringBackwards {

  def reverse1(input: String): String = {
    var reversed: String = ""
    for (i <- 0 until input.length) {
      reversed += input.charAt(input.length - 1 - i)
    }
    reversed
  }

  def reverse2(input: String): String = {
    if (input.length > 1) {
      input.substring(input.length - 1) + reverse2(input.substring(0, input.length - 1))
    } else {
      input
    }
  }

  def main(args: Array[String]): Unit = {
    val org = "Hello!"
    val expected = "!olleH"

    val reversed1 = StringBackwards.reverse1(org)
    val reversed2 = StringBackwards.reverse2(org)
    println("Org      : " + org)
    println("reversed1: " + reversed1)
    println("reversed2: " + reversed2)
    assert(expected == reversed1)
    assert(expected == reversed2)
  }
}

