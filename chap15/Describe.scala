object Describe {
	def describe(x: Any) = x match {
		case 5 => "five"
		case true => "truth"
		case "hello" => "hi!"
		case Nil => "the empty list"
		case _ => "something else"
	}

	def tupleDemo(expr: Any) =
		expr match {
			case (a, b, c) => println("matched " + a + b + c)
			case _ =>
		}
}

