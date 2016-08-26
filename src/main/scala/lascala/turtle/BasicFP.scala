package lascala.turtle

import lascala.turtle.common._

object BasicFP extends App {

  case class TurtleState(position: Position, angle: Angle, color: PenColor, penState: PenState)

  lazy val initialTurtleState = TurtleState(initialPosition, 0.0.degree, initialColor, initialPenState)

  object Turtle {
    def move(log: Log)(distance: Distance)(state: TurtleState) = {
      log(f"Move $distance%.1f")
      val newPosition = state.position.move(distance, state.angle)
      if (state.penState == PenState.Down) dummyDrawLine(log, state.position, newPosition, state.color)
      state.copy(position = newPosition)
    }
  }
}
