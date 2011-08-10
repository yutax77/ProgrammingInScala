class Outer {
	class Inner {
		private def f() {println("f")}
		class InnerMost {
			f()
		}
	}
	(new Inner).f()
}
