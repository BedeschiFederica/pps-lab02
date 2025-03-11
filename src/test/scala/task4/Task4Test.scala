package task4

import org.junit.*
import org.junit.Assert.*
import task1_4.Task4.Expr.*

class Task4Test:

  val value1: Int = 5
  val value2: Int = 10

  @Test def evaluateLiteral(): Unit =
    assertEquals(value1, evaluate(Literal(value1)))

  @Test def evaluateAddExpression(): Unit =
    assertEquals(value1 + value2, evaluate(Add(Literal(value1), Literal(value2))))

  @Test def evaluateMultiplyExpression(): Unit =
    assertEquals(50, evaluate(Multiply(Literal(5), Literal(10))))