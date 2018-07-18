package life

import org.scalatest.{FlatSpec, Matchers}

class FileLoaderSpec extends FlatSpec with Matchers {

  "File Loader" should "recreate board from file representation" in {
      val fileBoard:Board = FileLoader.loadBoardFromFile("i-column")
      val expectedBoard = Board(Map(((5,4),Alive), ((5,5),Alive), ((4,6),Alive), ((6,6),Alive), ((5,7),Alive), ((5,8),Alive),
        ((5,9),Alive), ((4,10),Alive), ((6,10),Alive), ((5,11),Alive), ((5,12),Alive)))


      /*Board(List(
        Cell((0,0),Dead), Cell((1,0),Dead), Cell((2,0),Dead), Cell((3,0),Dead), Cell((4,0),Dead), Cell((5,0),Dead), Cell((6,0),Dead), Cell((7,0),Dead), Cell((8,0),Dead), Cell((9,0),Dead), Cell((10,0),Dead),
        Cell((0,1),Dead), Cell((1,1),Dead), Cell((2,1),Dead), Cell((3,1),Dead), Cell((4,1),Dead), Cell((5,1),Dead), Cell((6,1),Dead), Cell((7,1),Dead), Cell((8,1),Dead), Cell((9,1),Dead), Cell((10,1),Dead),
        Cell((0,2),Dead), Cell((1,2),Dead), Cell((2,2),Dead), Cell((3,2),Dead), Cell((4,2),Dead), Cell((5,2),Dead), Cell((6,2),Dead), Cell((7,2),Dead), Cell((8,2),Dead), Cell((9,2),Dead), Cell((10,2),Dead),
        Cell((0,3),Dead), Cell((1,3),Dead), Cell((2,3),Dead), Cell((3,3),Dead), Cell((4,3),Dead), Cell((5,3),Dead), Cell((6,3),Dead), Cell((7,3),Dead), Cell((8,3),Dead), Cell((9,3),Dead), Cell((10,3),Dead),
        Cell((0,4),Dead), Cell((1,4),Dead), Cell((2,4),Dead), Cell((3,4),Dead), Cell((4,4),Dead), Cell((5,4),Alive), Cell((6,4),Dead), Cell((7,4),Dead), Cell((8,4),Dead), Cell((9,4),Dead), Cell((10,4),Dead),
        Cell((0,5),Dead), Cell((1,5),Dead), Cell((2,5),Dead), Cell((3,5),Dead), Cell((4,5),Dead), Cell((5,5),Alive), Cell((6,5),Dead), Cell((7,5),Dead), Cell((8,5),Dead), Cell((9,5),Dead), Cell((10,5),Dead),
        Cell((0,6),Dead), Cell((1,6),Dead), Cell((2,6),Dead), Cell((3,6),Dead), Cell((4,6),Alive), Cell((5,6),Dead), Cell((6,6),Alive), Cell((7,6),Dead), Cell((8,6),Dead), Cell((9,6),Dead), Cell((10,6),Dead),
        Cell((0,7),Dead), Cell((1,7),Dead), Cell((2,7),Dead), Cell((3,7),Dead), Cell((4,7),Dead), Cell((5,7),Alive), Cell((6,7),Dead), Cell((7,7),Dead), Cell((8,7),Dead), Cell((9,7),Dead), Cell((10,7),Dead),
        Cell((0,8),Dead), Cell((1,8),Dead), Cell((2,8),Dead), Cell((3,8),Dead), Cell((4,8),Dead), Cell((5,8),Alive), Cell((6,8),Dead), Cell((7,8),Dead), Cell((8,8),Dead), Cell((9,8),Dead), Cell((10,8),Dead),
        Cell((0,9),Dead), Cell((1,9),Dead), Cell((2,9),Dead), Cell((3,9),Dead), Cell((4,9),Dead), Cell((5,9),Alive), Cell((6,9),Dead), Cell((7,9),Dead), Cell((8,9),Dead), Cell((9,9),Dead), Cell((10,9),Dead),
        Cell((0,10),Dead), Cell((1,10),Dead), Cell((2,10),Dead), Cell((3,10),Dead), Cell((4,10),Alive), Cell((5,10),Dead), Cell((6,10),Alive), Cell((7,10),Dead), Cell((8,10),Dead), Cell((9,10),Dead), Cell((10,10),Dead),
        Cell((0,11),Dead), Cell((1,11),Dead), Cell((2,11),Dead), Cell((3,11),Dead), Cell((4,11),Dead), Cell((5,11),Alive), Cell((6,11),Dead), Cell((7,11),Dead), Cell((8,11),Dead), Cell((9,11),Dead), Cell((10,11),Dead),
        Cell((0,12),Dead), Cell((1,12),Dead), Cell((2,12),Dead), Cell((3,12),Dead), Cell((4,12),Dead), Cell((5,12),Alive), Cell((6,12),Dead), Cell((7,12),Dead), Cell((8,12),Dead), Cell((9,12),Dead), Cell((10,12),Dead),
        Cell((0,13),Dead), Cell((1,13),Dead), Cell((2,13),Dead), Cell((3,13),Dead), Cell((4,13),Dead), Cell((5,13),Dead), Cell((6,13),Dead), Cell((7,13),Dead), Cell((8,13),Dead), Cell((9,13),Dead), Cell((10,13),Dead),
        Cell((0,14),Dead), Cell((1,14),Dead), Cell((2,14),Dead), Cell((3,14),Dead), Cell((4,14),Dead), Cell((5,14),Dead), Cell((6,14),Dead), Cell((7,14),Dead), Cell((8,14),Dead), Cell((9,14),Dead), Cell((10,14),Dead),
        Cell((0,15),Dead), Cell((1,15),Dead), Cell((2,15),Dead), Cell((3,15),Dead), Cell((4,15),Dead), Cell((5,15),Dead), Cell((6,15),Dead), Cell((7,15),Dead), Cell((8,15),Dead), Cell((9,15),Dead), Cell((10,15),Dead),
        Cell((0,16),Dead), Cell((1,16),Dead), Cell((2,16),Dead), Cell((3,16),Dead), Cell((4,16),Dead), Cell((5,16),Dead), Cell((6,16),Dead), Cell((7,16),Dead), Cell((8,16),Dead), Cell((9,16),Dead), Cell((10,16),Dead)))*/

    fileBoard shouldBe expectedBoard
  }


}
