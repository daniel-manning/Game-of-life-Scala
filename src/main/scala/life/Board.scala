package life

import Rules._

case class Board(boardState:Map[Location, Status]) {

  val neighbourCells = List((-1,-1), (0, -1), (1, -1), (-1, 0), (1, 0), (-1, 1), (0, 1), (1, 1))

  def lookup(location:Location):Cell = {
    //If we can't find the cell default it to dead
    val status = boardState.getOrElse(location, Dead)

    Cell(location, status)
  }

  def neighbourhood(location: (Int, Int)): Neighbourhood = {

    neighbourCells.map(neighbourhoodVector => lookup((neighbourhoodVector._1 + location._1, neighbourhoodVector._2 + location._2)))

  }

  def evolveBoard(): Board = {
    //TODO: Need to create a thin layer of dead cells around all the alive ones before we evolve state
    val whitespaceToAdd:List[Cell] = boardState.flatMap(x => neighbourhood(x._1).filter(n => !boardState.contains(n.location))).toList
    val boardWithWhiteSpace = whitespaceToAdd.foldRight(boardState)((cell, map) => map + ((cell.location, Dead)))

    //TODO: Only store alive cells in the map
    val newBoard = boardWithWhiteSpace.foldRight(Map[Location, Status]())((x:(Location, Status), y:Map[Location, Status]) => {
      val cell = Cell(x._1, x._2)
      evolveState(cell, neighbourhood = neighbourhood(cell.location)).status match {
        case Alive => y + ((x._1, Alive))
        case Dead => y
      }

    })

    Board(newBoard)
    //Board(boardState.map(cell => evolveState(cell, neighbourhood = neighbourhood(cell.location))))
  }



}
