package com.dkus.misc.examples

class Companions {

  def main (args: Array[String] ): Unit = {
    Companions.lowercase("THIS")
  }


}

object Companions {
  protected def lowercase(x: String): String = x.toLowerCase
}

