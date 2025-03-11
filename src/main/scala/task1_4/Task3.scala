package task1_4

object Task3 extends App:

  // 7

  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)

  def power2(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def powerTail(base: Double, exponent: Int, acc: Double): Double = exponent match
      case 0 => acc
      case _ => powerTail(base, exponent - 1, acc * base)
    powerTail(base, exponent, 1)

  println("7:")
  println((power(2, 3), power(5, 2))) // (8.0, 25.0))
  println((power2(2, 3), power2(5, 2))) // (8.0, 25.0))
  println()

  // 8

  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def reverse(n: Int, acc: Int): Int = n match
      case 0 => acc
      case _ => reverse(n / 10, acc * 10 + n % 10)
    reverse(n, 0)

  println("8:")
  println(reverseNumber(12345)) // 54321
