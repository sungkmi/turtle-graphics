package lascala.turtle

import lascala.turtle.common._

object BasicFP extends App {

  case class TurtleState(position: Position, angle: Angle, color: PenColor, penState: PenState)

  val initialTurtleState = TurtleState(initialPosition, 0.0.degree, initialColor, initialPenState)
}
