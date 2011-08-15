package jp.co.pooh.chap14
import org.scalatest.Suite
import Element.elem
class ElementSuite extends Suite{
	def testUniformElement() {
	  val ele = elem('x', 2, 3)
	  assert(ele.width == 2)
	}
}