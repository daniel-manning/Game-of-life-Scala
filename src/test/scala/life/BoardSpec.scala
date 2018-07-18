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

  it should "evolve a board correctly to its next state for an eyelet" in {
    val eyeletBoard = FileLoader.loadBoardFromFile("eyelets")
    val evolvedBoard = eyeletBoard.evolveBoard()
    val openoBoard = FileLoader.loadBoardFromFile("openo")

    evolvedBoard shouldBe openoBoard
  }

  it should "evolve a board correctly to its next state for an openo" in {
    val eyeletBoard = FileLoader.loadBoardFromFile("openo")
    val evolvedBoard = eyeletBoard.evolveBoard()
    val openoBoard = FileLoader.loadBoardFromFile("central-I")

    evolvedBoard shouldBe openoBoard
  }

  it should "evolve a board correctly to its next state for a Pentadecathlon" in {
    val pentadecathlonBoard = FileLoader.loadBoardFromFile("central-I")
    val s1 = pentadecathlonBoard.evolveBoard()
    val s2 = s1.evolveBoard()
    val s3 = s2.evolveBoard()
    val s4 = s3.evolveBoard()
    val s5 = s4.evolveBoard()
    val s6 = s5.evolveBoard()
    val s7 = s6.evolveBoard()
    val s8 = s7.evolveBoard()
    val s9 = s8.evolveBoard()
    val s10 = s9.evolveBoard()
    val s11 = s10.evolveBoard()
    val s12 = s11.evolveBoard()
    val s13 = s12.evolveBoard()
    val s14 = s13.evolveBoard()
    val s15 = s14.evolveBoard()
    s1 should not be pentadecathlonBoard
    s2 should not be pentadecathlonBoard
    s3 should not be pentadecathlonBoard
    s4 should not be pentadecathlonBoard
    s5 should not be pentadecathlonBoard
    s6 should not be pentadecathlonBoard
    s7 should not be pentadecathlonBoard
    s8 should not be pentadecathlonBoard
    s9 should not be pentadecathlonBoard
    s10 should not be pentadecathlonBoard
    s11 should not be pentadecathlonBoard
    s12 should not be pentadecathlonBoard
    s13 should not be pentadecathlonBoard
    s14 should not be pentadecathlonBoard
    s15 shouldBe pentadecathlonBoard
  }

  it should "allow a glider to travel forever" in  {
    val gliderBoard = FileLoader.loadBoardFromFile("glider")
    var board:Board = gliderBoard
    (1 to 100).toList.foreach(x => {board = board.evolveBoard()})
    board.boardState.count(_._2 == Alive) shouldBe 5
    board.boardState.head._1._1 should be > 5
    board.boardState.head._1._2 should be > 5
  }

}