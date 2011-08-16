package jp.co.pooh.chap14
import org.scalatest.testng.TestNGSuite
import org.testng.Assert._
import org.testng.annotations._

import Element.elem
class ElementSuite extends TestNGSuite{
    @Test
	def verifyUniformElement() {
	  val ele = elem('x', 2, 3)
	  assertEquals(ele.width, 2)
	  expect(3) {ele.height}
	  intercept[IllegalArgumentException] {
	    elem('x', -2, 3)
	  }
    }
}