package lascala.turtle

import scala.util.{Failure, Success, Try}

import lascala.turtle.common._
import APIwithFunctionalCore.TurtleApi._
import utest._

object APIwithFunctionalCoreTest extends TestSuite {
  val tests = this {
    'validateDistance {
      "success case" - {
        val result: Try[Double] = validateDistance("1.0")
        assertMatch(result){ case Success(d: Double) if (d - 1.0).abs < 0.00001 => }
      }
      "failure case" - {
        val result: Try[Double] = validateDistance("abc")
        assertMatch(result){ case Failure(InvalidDistance(_)) => }
      }
    }

    'exec {
      //val api = new TurtleApi()
      //api.exec("Move 100")
      //assertMatch(api.state){ case TurtleState(Position(x, y), _, _, _) if (x-100).abs < 0.00001 => } 
    }
  }
}
