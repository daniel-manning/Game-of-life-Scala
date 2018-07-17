package life.fixtures

import life.{Alive, Cell, Dead, Neighbourhood}

object NeighbourhoodData {

  def fewerThanTwoNeighbours:Neighbourhood = {
    List( Cell((0,0), Dead), Cell((1,0), Dead), Cell((2,0), Dead),
          Cell((0,1), Dead),                    Cell((2,1), Alive),
          Cell((0,2), Dead), Cell((1,2), Dead), Cell((2,2), Dead))
  }

  def twoNeighbours:Neighbourhood = {
    List( Cell((0,0), Dead), Cell((1,0), Dead), Cell((2,0), Dead),
          Cell((0,1), Alive),                   Cell((2,1), Alive),
          Cell((0,2), Dead), Cell((1,2), Dead), Cell((2,2), Dead))
  }

  def threeNeighbours:Neighbourhood = {
    List( Cell((0,0), Alive), Cell((1,0), Dead), Cell((2,0), Dead),
          Cell((0,1), Alive),                    Cell((2,1), Alive),
          Cell((0,2), Dead), Cell((1,2), Dead),  Cell((2,2), Dead))
  }

  def moreThanThreeNeighbours:Neighbourhood = {
    List( Cell((0,0), Alive), Cell((1,0), Dead), Cell((2,0), Dead),
          Cell((0,1), Alive),                    Cell((2,1), Alive),
          Cell((0,2), Alive), Cell((1,2), Dead), Cell((2,2), Dead))
  }


}
