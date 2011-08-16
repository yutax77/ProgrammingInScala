package jp.co.pooh.chap14
import org.scalatest.Suite
import Element.elem
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitSuite
import org.junit.Test
class ElementSuite extends JUnitSuite{
    @Test
	def testUniformElement() {
	  val ele = elem('x', 2, 3)
	  assert(ele.width === 2)
	  expect(3) {ele.height}
	  intercept[IllegalArgumentException] {
	    elem('x', -2, 3)
	  }
	}
}