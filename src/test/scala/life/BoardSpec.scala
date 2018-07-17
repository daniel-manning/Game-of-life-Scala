package life

import org.scalatest.{FlatSpec, Matchers}
import life.fixtures.BoardData._

class BoardSpec extends FlatSpec with Matchers {
  val board = Board(block)

  "board" should "when given a location look up it's cell" in {
    val cell = board.lookup((1,1))
    cell.status shouldBe Alive
  }

  it should "when given a cell be able to give a neighbourhood" in {
    val neighbourhood:List[Cell] = board.neighbourhood((0,0))
    neighbourhood.size shouldBe 8
  }

  it should "respect the cartesian coordinates of the grid when calculating the neighbourhood" in {
    val neighbourhood:List[Cell] = board.neighbourhood((0,0))
    neighbourhood.map(_.location) shouldBe List((-1,-1), (0, -1), (1, -1), (-1, 0), (1, 0), (-1, 1),(0, 1), (1, 1) )
  }

  it should "reflect the board state when returning the neighbourhood" in {
    val neighbourhood:List[Cell] = board.neighbourhood((1,1))
    neighbourhood shouldBe List( Cell((0,0), Dead), Cell((1,0), Dead), Cell((2,0), Dead),
      Cell((0,1), Dead), Cell((2,1), Alive),
      Cell((0,2), Dead), Cell((1,2), Alive), Cell((2,2), Alive))
  }

  it should "evolve a board correctly to its next state for a block" in {
    val nextBoardState:Board = board.evolveBoard()
    nextBoardState shouldBe board
  }

  it should "evolve a board correctly to its next state for a beehive" in {
    val beehiveBoard = Board(beehive)
    val nextBoardState:Board = beehiveBoard.evolveBoard()
    nextBoardState shouldBe beehiveBoard
  }

  it should "evolve a board correctly to its next state for a blinker" in {
    val beehiveBoard = Board(blinker_stage1)
    val nextBoardState:Board = beehiveBoard.evolveBoard()
    nextBoardState shouldBe Board(blinker_stage2)
  }

}