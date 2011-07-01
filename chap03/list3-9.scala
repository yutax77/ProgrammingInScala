def formatArgs(args: Array[String]) = args.mkString("\n")
val res = formatArgs(Array("zero", "one", "two"))
assert(res == "zero\none\ntwo")
