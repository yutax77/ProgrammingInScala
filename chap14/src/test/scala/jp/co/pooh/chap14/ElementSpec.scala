package jp.co.pooh.chap14
import org.scalatest.Spec
import Element.elem

class ElementSpec extends Spec{
	describe("A UniformElement") {
	  it("Should have a width equal to the passed value") {
	    val ele = elem('x', 2, 3)
	    assert(ele.width === 2)
	  }
	  it("should have a height equal to the passed value") {
	    val ele = elem('x', 2, 3)
	    assert(ele.height === 3)
	  }
	  it("sould throw an IAE if passed a  negative width") {
	    intercept[IllegalArgumentException] {
	      elem('x', -2, 3)
	    }
	  }
	}
}