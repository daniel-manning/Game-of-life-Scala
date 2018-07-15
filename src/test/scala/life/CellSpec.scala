package life

import org.scalatest.{FlatSpec, Matchers}

class CellSpec extends FlatSpec with Matchers {
  "Cells" should "be able to be constructed" in {
    val cell = Cell((0,0), Alive)
    cell.location shouldBe (0,0)
    cell.status shouldBe Alive
  }

  it should "be able to be dead" in {
    val cell = Cell((0,0), Dead)
    cell.status shouldBe Dead
  }
}