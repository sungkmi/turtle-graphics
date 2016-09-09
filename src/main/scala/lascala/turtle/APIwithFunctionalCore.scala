package lascala.turtle

import lascala.turtle.common._
import scala.util.{Failure, Try}

object APIwithFunctionalCore extends App {
  import TurtleApi._

  class TurtleApi {

    var state = initialTurtleState

    def updateState(newState:TurtleState) = {
      state = newState
    }


    def exec(commandStr: String) = {
      val tokens = commandStr.split(' ').toList.map(_.trim)

      val stateR = returnR(state)

      val newStateR = tokens match {
        case List("Move", distanceStr) =>
          val distanceR = validateDistance(distanceStr)
          //lift2R(move)(distanceR)(stateR)
      }
    }
  }

  object TurtleApi {
    case class TurtleState(position: Position, angle: Angle, color: PenColor, penState: PenState)

    lazy val initialTurtleState = TurtleState(initialPosition, 0.0.degree, initialColor, initialPenState)

    def move(log: Log)(distance: Distance)(state: TurtleState) = {
      log(f"Move $distance%.1f")
      val newPosition = state.position.move(distance, state.angle)
      if (state.penState == PenState.Down) dummyDrawLine(log, state.position, newPosition, state.color)
      state.copy(position = newPosition)
    }

    def validateDistance(distanceStr: String): Try[Double] = {
      Try(distanceStr.toDouble) recoverWith {
        case e:NumberFormatException => Failure(InvalidDistance(distanceStr))
       }
    }


    sealed trait ErrorMessage extends Throwable
    case class InvalidDistance(msg: String) extends ErrorMessage
    case class InvalidAngle(msg: String) extends ErrorMessage
    case class InvalidColor(msg: String) extends ErrorMessage
    case class InvalidCommand(msg: String) extends ErrorMessage
  }
}
