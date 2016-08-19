package lascala.turtle

import lascala.turtle.common._
import BasicOO._
import utest._

object BasicOOTest extends TestSuite {
  val tests = this {
    'Move {
      val turtle = new Turtle(println)
      turtle.move(1.0)

      val Position(x, y) = turtle.currentPosition
      assert((x - 1.0).abs < 0.000001)
      assert((y - 0.0).abs < 0.000001)
    }

    'Turn {
      val turtle = new Turtle(println)
      turtle.turn(90.0.degree)

      assert((turtle.currentAngle.degree - 90.0).abs < 0.000001)
    }
  }
}
