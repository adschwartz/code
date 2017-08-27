package com.dkus.misc.examples

/**
  * @author aschwartz on 6/8/16 (#)
  */
case class CCPattern(a: String, b: Option[String])

object test {

  def check(element: CCPattern) = element.b match {
    case Some(b) => println("Got "+b)
    case _ => println("Nope")
  }

  def main(args: Array[String]) {
    val a = CCPattern("a", Some("be"))
    val b = CCPattern("c", Some("de"))
    val c = CCPattern("c", None)

    check(a)
    check(b)
    check(c)

  }
}
