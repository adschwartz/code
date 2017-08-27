package testpackage1

/**
  * Created by aschwartz on 2/19/16.
  */
object NumberWords {

  def convertToWords(number:Int): String = {
    ""
  }






  def main (args: Array[String]): Unit = {

    val number = 1234

    val expected:String = "ONE THOUSAND TWO HUNDRED THIRTY FOUR"
    val actual:String = NumberWords.convertToWords(number)

    assert(expected == actual)

  }
}
