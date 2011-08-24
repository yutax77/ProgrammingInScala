import Element.elem

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Num(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

class ExprFormatter {
	private val opGroups = 
		Array(
			Set("|", "||"),
			Set("&", "&&"),
			Set("^"),
			Set("==", "!="),
			Set("<", "<=", ">", ">="),
			Set("+", "-"),
			Set("*", "%")
		)

	private val precedence = {
		val assocs = 
			for {
				i <- 0 until opGroups.length
				op <- opGroups(i)
			} yield op -> i
		Map() ++ assocs
	}
	private val unaryPrecedence = opGroups.length
	private val fractionPrecedence = -1

	private def format(e: Expr, enclPrec: Int): Element =
		e match {
			case Var(name) =>
				elem(name)
			case Num(num) =>
				def stripDot(s: String) = 
					if(s endsWith ".0") s.substring(0, s.length - 2)
					else s
				elem(stripDot(num.toString))
			case UnOp(op, arg) =>
				elem(op) beside format(arg, unaryPrecedence)
			case BinOp("/", left, right) =>
				val top = format(left, fractionPrecedence)
				val bot = format(right, fractionPrecedence)
				val line = elem('-', top.width max bot.width, 1)
				val frac = top above line above bot
				if(enclPrec != fractionPrecedence) frac
				else elem(" ") beside frac beside elem(" ")
			case BinOp(op, left, right) =>
				val opPrec = precedence(op)
				val l = format(left, opPrec)
				val r = format(right, opPrec + 1)
				val oper = l beside elem(" " + op + " ") beside r
				if(enclPrec <= opPrec) oper
				else elem("(") beside oper beside elem(")")
		}
	def format(e: Expr): Element = format(e, 0)
}
object Expr {
	def simplifyTop(expr: Expr): Expr = expr match {
		case UnOp("-", UnOp("-", e)) => e
		case BinOp("+", e, Num(0)) => e
		case BinOp("*", e, Num(1)) => e
		case _ => expr
	}

	def simplifyAdd(e: Expr) = e match {
		case BinOp("+", x, y) if x == y =>
			BinOp("*", x, Num(2))
		case _ => e
	}

	def simplifyAll(expr: Expr): Expr = expr match {
		case UnOp("-", UnOp("-", e)) =>
			simplifyAll(e)
		case BinOp("+", e, Num(0)) =>
			simplifyAll(e)
		case BinOp("*", e, Num(1)) =>
			simplifyAll(e)
		case UnOp(op, e) =>
			UnOp(op, simplifyAll(e))
		case BinOp(op, l, r) =>
			BinOp(op, simplifyAll(l), simplifyAll(r))
		case _ => expr
	}

	def describe(e: Expr):String = (e: @unchecked) match {
		case Num(_) => "a number"
		case Var(_) => "a variable"
	}
}
