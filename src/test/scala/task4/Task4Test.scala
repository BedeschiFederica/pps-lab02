package task4

import org.junit.*
import org.junit.Assert.*
import task1_4.Task4.Expr.*

class Task4Test:

  @Test def evaluateLiteral(): Unit =
    assertEquals(5, evaluate(Literal(5)))

  @Test def evaluateAddExpression(): Unit =
    assertEquals(15, evaluate(Add(Literal(5), Literal(10))))