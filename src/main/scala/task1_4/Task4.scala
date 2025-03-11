package task1_4

object Task4 extends App:

  // 9

  enum Expr:
    case Literal(n: Int)
    case Add(expr1: Expr, expr2: Expr)
    case Multiply(expr1: Expr, expr2: Expr)

  object Expr:
    def evaluate(expr: Expr): Int = expr match
      case Literal(n) => n
