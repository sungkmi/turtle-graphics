package lascala.turtle

import lascala.turtle.common._

object BasicOO extends App {
  class Turtle(log: String => Unit) {
    var currentPosition: Position = initialPosition
    var currentAngle: Angle = 0.0.degree
    var currentColor: PenColor = initialColor
    var currentPenState: PenState = initialPenState

    def move(distance: Distance) = {
      log(f"Move $distance%.1f")
      val newPosition = currentPosition.move(distance, currentAngle)
      if (currentPenState == PenState.Down) dummyDrawLine(log, currentPosition, newPosition, currentColor)
      currentPosition = newPosition
    }

    def turn(angle: Angle) = {
      log(f"Turn ${angle.degree}%.1f")
      currentAngle = (currentAngle.degree + angle.degree).degree
    }

    def penUp() = {
      log(f"Pen Up")
      currentPenState = PenState.Up
    }

    def penDown() = {
      log(f"Pen Down")
      currentPenState = PenState.Down
    }

    def setColor(color: PenColor) = {
      log(f"SetColor $color")
      currentColor = color
    }
  }

  def log(message: String): Unit = println(message)

  def drawTriangle(log: String => Unit): Unit = {
    val turtle = new Turtle(log)
    turtle move 100.0
    turtle turn 120.0.degree
    turtle move 100.0
    turtle turn 120.0.degree
    turtle move 100.0
    turtle turn 120.0.degree
  }

  drawTriangle(log)
}
