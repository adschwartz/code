package com.dkus.misc.examples

/**
  * @author aschwartz on 6/8/16 (#)
  */

trait ExtraStuff {

  val factor: Double

  def factorDouble:Double = factor*2.0

}

abstract class AbstractClass(val weight: Double) {

}

class AClass(weight: Double) extends AbstractClass(weight) with ExtraStuff {

  override val factor:Double = 5

  def doubleWeight:Double = weight * 2.0

  def factorDoubleWeight:Double = doubleWeight*factorDouble
}

object run {
  def main(args: Array[String]) {
    val aClass = new AClass(2.0)
    println(aClass.factorDoubleWeight)
    println(aClass.factorDoubleWeight)
    println(aClass.factorDoubleWeight)
  }
}