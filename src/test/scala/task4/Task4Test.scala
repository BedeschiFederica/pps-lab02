package task4

import org.junit.*
import org.junit.Assert.*
import task1_4.Task4.Expr.*

class Task4Test:

  val value1: Int = 5
  val value2: Int = 10
  val value3: Int = 3
  val leftPar = "("
  val rightPar = ")"
  val plus = " + "
  val times = " * "

  @Test def evaluateLiteral(): Unit =
    assertEquals(value1, evaluate(Literal(value1)))

  @Test def evaluateAddExpression(): Unit =
    assertEquals(value1 + value2, evaluate(Add(Literal(value1), Literal(value2))))

  @Test def evaluateMultiplyExpression(): Unit =
    assertEquals(value1 * value2, evaluate(Multiply(Literal(value1), Literal(value2))))

  @Test def evaluateComplexExpression(): Unit =
    assertEquals(value1 * value2 + value3, evaluate(Add(Multiply(Literal(value1), Literal(value2)), Literal(value3))))

  @Test def showLiteral(): Unit =
    assertEquals(value1.toString, show(Literal(value1)))

  @Test def showAddExpression(): Unit =
    assertEquals(leftPar + value1 + plus + value2 + rightPar, show(Add(Literal(value1), Literal(value2))))

  @Test def showMultiplyExpression(): Unit =
    assertEquals(leftPar + value1 + times + value2 + rightPar, show(Multiply(Literal(value1), Literal(value2))))

  @Test def showComplexExpression(): Unit =
    assertEquals(leftPar + leftPar + value1 + times + value2 + rightPar + plus + value3 + rightPar,
      show(Add(Multiply(Literal(value1), Literal(value2)), Literal(value3))))