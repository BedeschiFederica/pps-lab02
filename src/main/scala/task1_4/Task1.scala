package task1_4

object Task1 extends App:

  // 2

  def divide(x: Double, y: Double): Double = x / y

  def divideCurried(x: Double)(y: Double): Double = x / y

  println(divide(10, 2))
  println(divideCurried(10)(2))

  val partial: Double => Double = divideCurried(10)

  println(partial(2))

  val divideCurriedAsFunction: Double => Double => Double = x => y => x / y

  println(divideCurriedAsFunction(10)(2))


