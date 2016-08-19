package lascala.turtle

import lascala.turtle.common._

object BasicOO {
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
  }
}
