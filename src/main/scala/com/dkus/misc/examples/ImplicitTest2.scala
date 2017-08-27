/**
  * @author anders.schwartz 
  */

package object examples {

  case class Testing(x:Int)
  class ImplicitTest2(val testing: Testing = Testing(4))

  class NonImplicitClass(val testing: Int = 2)

  implicit class EnhancedTesting(private val self: ImplicitTest2) {
    def gimmeVal = self.testing
  }

  val testing = new ImplicitTest2
  testing.gimmeVal

  val anotherClass = new NonImplicitClass
  // Cannot do:
//   anotherClass.gimmeVal

}

