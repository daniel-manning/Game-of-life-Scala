package life

import Rules._

case class Board(boardState:List[Cell]) {

  val neighbourCells = List((-1,-1), (0, -1), (1, -1), (-1, 0), (1, 0), (-1, 1),(0, 1), (1, 1) )

  def lookup(location:(Int,Int)):Cell = {
    //If we can't find the cell default it to dead
    boardState.find(_.location == location).getOrElse(Cell(location, Dead))
  }

  def neighbourhood(location: (Int, Int)): Neighbourhood = {

    neighbourCells.map(neighbourhoodVector => lookup((neighbourhoodVector._1 + location._1, neighbourhoodVector._2 + location._2)))

  }

  def evolveBoard(): Board = Board(boardState.map(cell => evolveState(cell, neighbourhood = neighbourhood(cell.location))))



}
