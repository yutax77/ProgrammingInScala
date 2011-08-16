package jp.co.pooh.chap14
import org.scalatest.testng.TestNGSuite
import org.testng.Assert._
import org.testng.annotations._
import Element.elem
import org.scalatest.prop.Checkers
import org.scalacheck.Prop._
class ElementSuite extends TestNGSuite with Checkers{
    @Test
	def verifyUniformElement() {
	  val ele = elem('x', 2, 3)
	  assertEquals(ele.width, 2)
	  expect(3) {ele.height}
	  intercept[IllegalArgumentException] {
	    elem('x', -2, 3)
	  }
    }
    
    @Test
    def testUniformElement() {
      check((w: Int) => w > 0 ==> (elem('x', w, 3).width == w))
      check((h: Int) => h > 0 ==> (elem('x', 2, h).height == h))
    }
}