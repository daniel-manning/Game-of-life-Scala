import org.scalatest.{FlatSpec, Matchers}
import BoardData._
class BoardSpec extends FlatSpec with Matchers {
  val board = new Board(block)

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


}
