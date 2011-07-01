class Animal
class Frog extends Animal with Philosophical {
	override def toString = "green"
	override def philosophize() {
		println("It ain't easy being " + toString + "!")
	}
}
