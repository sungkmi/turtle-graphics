package lascala.turtle

package object common {

  type Distance = Double

  case class Angle(degree: Double) {
    def toRadian: Double = degree / 180 * math.Pi
  }

  implicit class AngleUnit(val angle: Double) extends AnyVal {
    def degree: Angle = Angle(angle)
  }

  sealed trait PenState
  object PenState {
    case object Up extends PenState
    case object Down extends PenState
  }

  sealed trait PenColor
  object PenColor {
    case object Black extends PenColor
    case object Red extends PenColor
    case object Blue extends PenColor
  }

  case class Position(x: Double, y: Double) {
    def move(distance: Distance, angle: Angle): Position =
      Position(x + distance * (math cos angle.toRadian), y + distance * (math sin angle.toRadian))
    override def toString(): String = f"($x%.1f, $y%.1f)"
  }

  implicit class DoubleRound2(val d: Double) extends AnyVal {
    def round2: Double =  (math rint d * 100) / 100.0 
  }

  val (initialPosition, initialColor, initialPenState) = (Position(0, 0), PenColor.Black, PenState.Down)

  def dummyDrawLine(log: String => Unit, oldPos: Position, newPos: Position, color: PenColor): Unit =
    log(s"...Draw line from $oldPos to $newPos using $color")

}
