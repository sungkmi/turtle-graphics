package lascala.turtle

import lascala.turtle.common._
import BasicFP._
import utest._

object BasicFPTest extends TestSuite {
  val tests = this {
    'Move {
      val movedTurtleState = Turtle.move(println)(1.0)(initialTurtleState)

      val Position(x, y) = movedTurtleState.position
      assert((x - 1.0).abs < 0.000001)
      assert((y - 0.0).abs < 0.000001)
    }
  }
}
