abstract class Expr
case class Var(name: String) extends Expr
case class Num(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object Expr {
	def simplifyTop(expr: Expr): Expr = expr match {
		case UnOp("-", UnOp("-", e)) => e
		case BinOp("+", e, Num(0)) => e
		case BinOp("*", e, Num(1)) => e
		case _ => expr
	}
}
