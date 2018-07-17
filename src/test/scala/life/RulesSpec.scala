package life

import life.fixtures.NeighbourhoodData._
import life.fixtures.BoardData._
import org.scalatest.{FlatSpec, Matchers}


class RulesSpec extends FlatSpec with Matchers {

  "Rules" should "when given a live cell with fewer than two live neighbors dies, as if by under population" in {
    val livingCell = Cell((1,1), Alive)
      Rules.evolveState(livingCell, fewerThanTwoNeighbours) shouldBe Cell((1,1), Dead)
  }

  it should "when given a live cell with two or three live neighbors lives on to the next generation" in {
    val livingCell = Cell((1,1), Alive)
    Rules.evolveState(livingCell, twoNeighbours) shouldBe Cell((1,1), Alive)
  }

  it should "when given a live cell with more than three live neighbors dies, as if by overpopulatio" in {
    val livingCell = Cell((1, 1), Alive)
    Rules.evolveState(livingCell, moreThanThreeNeighbours) shouldBe Cell((1, 1), Dead)
  }

  it should "when given a dead cell with exactly three live neighbors becomes a live cell, as if by reproduction" in {
    val livingCell = Cell((1, 1), Dead)
    Rules.evolveState(livingCell, threeNeighbours) shouldBe Cell((1, 1), Alive)
  }

  it should "when given a dead cell with not exactly three live neighbors stays dead" in {
    val livingCell = Cell((1, 1), Dead)
    Rules.evolveState(livingCell, twoNeighbours) shouldBe Cell((1, 1), Dead)
  }

}
