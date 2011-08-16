package jp.co.pooh.chap14
import org.scalatest.testng.TestNGSuite
import org.testng.Assert._
import org.testng.annotations._

import Element.elem
class ElementSuite extends TestNGSuite{
    @Test
	def testUniformElement() {
	  val ele = elem('x', 2, 3)
	  assertEquals(ele.width, 2)
	  assertEquals(ele.height, 3)
    }
    
    @Test {
      val expectedExceptions = 
        Array(classOf[IllegalArgumentException])
    }
    def elemShouldThrowIAE() { elem('x', -2, 3)}
}