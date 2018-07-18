package life.fixtures

import life.{Alive, Cell, Dead}

object BoardData {

  def block = Map(((1,1), Alive), ((2,1), Alive), ((1,2), Alive), ((2,2), Alive))
                    /*List( Cell((0,0), Dead), Cell((1,0), Dead), Cell((2,0), Dead), Cell((3,0), Dead),
                    Cell((0,1), Dead), Cell((1,1), Alive), Cell((2,1), Alive), Cell((3,1), Dead),
                    Cell((0,2), Dead), Cell((1,2), Alive), Cell((2,2), Alive), Cell((3,2), Dead),
                    Cell((0,3), Dead), Cell((1,3), Dead), Cell((2,3), Dead), Cell((3,3), Dead))*/

  def beehive = Map(((2,1), Alive), ((3,1), Alive), ((1,2), Alive), ((4,2), Alive), ((2,3), Alive), ((3,3), Alive))
                    /*List( Cell((0,0), Dead), Cell((1,0), Dead),  Cell((2,0), Dead),  Cell((3,0), Dead),  Cell((4,0), Dead),  Cell((5,0), Dead),
                      Cell((0,1), Dead), Cell((1,1), Dead),  Cell((2,1), Alive), Cell((3,1), Alive), Cell((4,1), Dead),  Cell((5,1), Dead),
                      Cell((0,2), Dead), Cell((1,2), Alive), Cell((2,2), Dead),  Cell((3,2), Dead),  Cell((4,2), Alive), Cell((5,2), Dead),
                      Cell((0,3), Dead), Cell((1,3), Dead),  Cell((2,3), Alive), Cell((3,3), Alive), Cell((4,3), Dead),  Cell((5,3), Dead),
                      Cell((0,4), Dead), Cell((1,4), Dead),  Cell((2,4), Dead),  Cell((3,4), Dead),  Cell((4,4), Dead),  Cell((5,4), Dead))*/

  def blinker_stage1 =  Map(((2,1), Alive), ((2,2), Alive), ((2,3), Alive))
                            /*List( Cell((0,0), Dead), Cell((1,0), Dead), Cell((2,0), Dead),  Cell((3,0), Dead), Cell((4,0), Dead),
                             Cell((0,1), Dead), Cell((1,1), Dead), Cell((2,1), Alive), Cell((3,1), Dead), Cell((4,1), Dead),
                             Cell((0,2), Dead), Cell((1,2), Dead), Cell((2,2), Alive), Cell((3,2), Dead), Cell((4,2), Dead),
                             Cell((0,3), Dead), Cell((1,3), Dead), Cell((2,3), Alive), Cell((3,3), Dead), Cell((4,3), Dead),
                             Cell((0,4), Dead), Cell((1,4), Dead), Cell((2,4), Dead),  Cell((3,4), Dead), Cell((4,4), Dead))*/

  def blinker_stage2 = Map(((1,2), Alive), ((2,2), Alive), ((3,2), Alive))
                          /*List( Cell((0,0), Dead), Cell((1,0), Dead),  Cell((2,0), Dead),  Cell((3,0), Dead),  Cell((4,0), Dead),
                             Cell((0,1), Dead), Cell((1,1), Dead),  Cell((2,1), Dead),  Cell((3,1), Dead),  Cell((4,1), Dead),
                             Cell((0,2), Dead), Cell((1,2), Alive), Cell((2,2), Alive), Cell((3,2), Alive), Cell((4,2), Dead),
                             Cell((0,3), Dead), Cell((1,3), Dead),  Cell((2,3), Dead),  Cell((3,3), Dead),  Cell((4,3), Dead),
                             Cell((0,4), Dead), Cell((1,4), Dead),  Cell((2,4), Dead),  Cell((3,4), Dead),  Cell((4,4), Dead))*/

}
