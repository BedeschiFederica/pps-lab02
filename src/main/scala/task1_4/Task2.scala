package task1_4

object Task2 extends App:

  // 3a

  val positiveFunction: Int => String =
    case x if x >= 0 => "positive"
    case _ => "negative"

  def positiveMethod(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  println("3a:")
  println(positiveFunction(5))
  println(positiveFunction(-5))
  println(positiveMethod(5))
  println(positiveMethod(-5))
  println()


  // 3b

  val negFunction: (String => Boolean) => String => Boolean = p => !p(_)
  def negMethod(p: String => Boolean): String => Boolean = !p(_)

  val empty: String => Boolean = _ == ""
  val notEmptyFunction = negFunction(empty)
  val notEmptyMethod = negMethod(empty)

  println("3b:")
  println(notEmptyFunction("foo")) // true
  println(notEmptyFunction("")) // false
  println(notEmptyFunction("foo") && !notEmptyFunction("")) // true
  println(notEmptyMethod("foo")) // true
  println(notEmptyMethod("")) // false
  println(notEmptyMethod("foo") && !notEmptyMethod("")) // true
  println()

  // 3 c

  def neg[A](p: A => Boolean): A => Boolean = !p(_)

  val notEmpty = neg(empty)

  println("3c:")
  println(notEmpty("foo")) // true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty("")) // true
  println()

  // 4

  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2 = (x: Int, y: Int, z: Int) => x <= y && y == z
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  println("4:");
  println(p1(1)(2)(2)) // true
  println(p2(1, 2, 2)) // true
  println(p3(3)(2)(2)) // false
  println(p4(1, 2, 3)) // false
  println()

  // 5

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  def genericCompose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

  println("5:")
  println(compose(_ - 1, _ * 2)(5)) // 9
  println(genericCompose((x: Int) => x - 1, (x: Int) => x * 2)(5)) // 9
  println(genericCompose((b: Boolean) => "a-" + b + "-b", (x: Int) => x >= 0)(5)) // a-true-b
  println()

  // 6

  def composeThree[A, B, C, D](f: C => D, g: B => C, h: A => B): A => D = x => f(genericCompose(g, h)(x))

  println("6:")
  println(composeThree((s: String) => s + "!", (x: Int) => x.toString, (x: Int) => x * 2)(3)) // "6!"
  println()