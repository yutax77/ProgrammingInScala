object Express extends Application {
	val f = new ExprFormatter
	val e1 = BinOp("*", BinOp("/", Num(1), Num(2)),
						BinOp("+", Var("x"), Num(1)))
	val e2 = BinOp("+", BinOp("/", Var("x"), Num(2)),
						BinOp("/", Num(1.5), Var("x")))
	val e3 = BinOp("/", e1, e2)
	def show(e: Expr) = println(f.format(e) + "\n\n")
	for(val e <- Array(e1, e2, e3)) show(e)
}
