package jp.co.pooh.chap14
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2._

object MySpec extends SpecificationWithJUnit {
  "This wonderful system" should {
    "save the world" in {
      val list = Nil
      list must beEmpty
    }
  }
}