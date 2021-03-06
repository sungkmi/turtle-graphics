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

    'Pen {
      val turtle = new Turtle(println)
      turtle.penUp()
      assert(turtle.currentPenState == PenState.Up)
      turtle.penDown()
      assert(turtle.currentPenState == PenState.Down)
    }

    'SetColor {
      val turtle = new Turtle(println)
      turtle.setColor(PenColor.Blue)
      assert(turtle.currentColor == PenColor.Blue)
    }

    'DrawTriangle {
      var logged = ""
      def log(s: String): Unit = {
        logged = logged ++ s ++ "\n"
      }
      drawTriangle(log)
      val expected = """Move 100.0
...Draw line from (0.0, 0.0) to (100.0, 0.0) using Black
Turn 120.0
Move 100.0
...Draw line from (100.0, 0.0) to (50.0, 86.6) using Black
Turn 120.0
Move 100.0
...Draw line from (50.0, 86.6) to (-0.0, 0.0) using Black
Turn 120.0
"""
      assert(expected == logged)
    }

    'DrawPolygon {
      var logged = ""
      def log(s: String): Unit = {
        logged = logged ++ s ++ "\n"
      }
      drawPolygon(3)(log)
      val expected = """Move 100.0
...Draw line from (0.0, 0.0) to (100.0, 0.0) using Black
Turn 120.0
Move 100.0
...Draw line from (100.0, 0.0) to (50.0, 86.6) using Black
Turn 120.0
Move 100.0
...Draw line from (50.0, 86.6) to (-0.0, 0.0) using Black
Turn 120.0
"""
      assert(expected == logged)
    }
  }
}
