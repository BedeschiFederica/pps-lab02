package task1_4

object Lab2 extends App:

  // Task 1, svolto da sola

  def divide(x: Double, y: Double): Double = x / y
  def divideCurried(x: Double)(y: Double): Double = x / y

  println(divide(10, 2)) // 5
  println(divideCurried(10)(2)) // 5

  val partial: Double => Double = divideCurried(10)

  println(partial(2)) // 5

  val divideCurriedAsFunction: Double => Double => Double = x => y => x / y

  println(divideCurriedAsFunction(10)(2)) // 5


  // Task 2, svolto da sola

  val positiveFunction: Int => String =
    case x if x >= 0 => "positive"
    case _ => "negative"

  def positiveMethod(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  println(positiveFunction(5)) // positive
  println(positiveFunction(-5)) // negative
  println(positiveMethod(5)) // positive
  println(positiveMethod(-5)) // negative

  val negFunction: (String => Boolean) => String => Boolean = p => !p(_)
  def negMethod(p: String => Boolean): String => Boolean = !p(_)

  val empty: String => Boolean = _ == ""
  val notEmptyFunction = negFunction(empty)
  val notEmptyMethod = negMethod(empty)

  println(notEmptyFunction("foo")) // true
  println(notEmptyFunction("")) // false
  println(notEmptyFunction("foo") && !notEmptyFunction("")) // true
  println(notEmptyMethod("foo")) // true
  println(notEmptyMethod("")) // false
  println(notEmptyMethod("foo") && !notEmptyMethod("")) // true

  def neg[A](p: A => Boolean): A => Boolean = !p(_)

  val notEmpty = neg(empty)

  println(notEmpty("foo")) // true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty("")) // true

  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2 = (x: Int, y: Int, z: Int) => x <= y && y == z
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  println(p1(1)(2)(2)) // true
  println(p2(1, 2, 2)) // true
  println(p3(3)(2)(2)) // false
  println(p4(1, 2, 3)) // false

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  def genericCompose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

  println(compose(_ - 1, _ * 2)(5)) // 9
  println(genericCompose((x: Int) => x - 1, (x: Int) => x * 2)(5)) // 9
  println(genericCompose((b: Boolean) => "a-" + b + "-b", (x: Int) => x >= 0)(5)) // a-true-b

  def composeThree[A, B, C, D](f: C => D, g: B => C, h: A => B): A => D = x => f(genericCompose(g, h)(x))

  println(composeThree((s: String) => s + "!", (x: Int) => x.toString, (x: Int) => x * 2)(3)) // "6!"


  // Task 3, svolto da sola

  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)

  def power2(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def powerTail(base: Double, exponent: Int, acc: Double): Double = exponent match
      case 0 => acc
      case _ => powerTail(base, exponent - 1, acc * base)
    powerTail(base, exponent, 1)

  println((power(2, 3), power(5, 2))) // (8.0, 25.0))
  println((power2(2, 3), power2(5, 2))) // (8.0, 25.0))

  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def reverse(n: Int, acc: Int): Int = n match
      case 0 => acc
      case _ => reverse(n / 10, acc * 10 + n % 10)
    reverse(n, 0)

  println(reverseNumber(12345)) // 54321


  // Task 4, svolto da sola

  enum Expr:
    case Literal(n: Int)
    case Add(expr1: Expr, expr2: Expr)
    case Multiply(expr1: Expr, expr2: Expr)

  object Expr:
    /**
     * Evaluates the expression.
     *
     * @param expr the expression to be evaluated
     * @return the result of the expression
     */
    def evaluate(expr: Expr): Int = expr match
      case Literal(n) => n
      case Add(expr1, expr2) => evaluate(expr1) + evaluate(expr2)
      case Multiply(expr1, expr2) => evaluate(expr1) * evaluate(expr2)

    /**
     * Shows the expression.
     *
     * @param expr the expression to be shown
     * @return the string representing the expression
     */
    def show(expr: Expr): String = expr match
      case Literal(n) => n.toString
      case Add(expr1, expr2) => s"(${show(expr1)} + ${show(expr2)})"
      case Multiply(expr1, expr2) => s"(${show(expr1)} * ${show(expr2)})"
