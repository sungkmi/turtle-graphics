package lascala.turtle.common

import scala.util.{Success, Try}

import utest._

object CommonTest extends TestSuite {
  val tests = this {
    'Degree {
      val f = 10.0
      assert( f.degree == Angle(f) )
    }

    'Round2 {
      assert( (3.1416.round2 - 3.14).abs < 0.000001 ) 
    }

    'Radian {
      assert((180.0.degree.toRadian - math.Pi).abs < 0.000001 ) 
    }

    'MoveMoveMove {
      val Position(x, y) = Position(0.0, 0.0).move((math sqrt 2), 45.degree)
      assert((x - 1).abs < 0.000001)
      assert((y - 1).abs < 0.000001)
    }

    "Position#toString" - {
      assert( Position(0.1, 0.1).toString == "(0.1, 0.1)" )
    }

    'retunR {
      assert(returnR("abc") == Try("abc"))
    }

    'mapR {
      assert(mapR((x:String) => x.toInt)(Try("10")) == Success(10))
    }

    'lift2R {
      assert(lift2R((a: Int) => (b: Int) => a + b)(Try(1))(Try(2)) == Success(3))
    }
  }
}
