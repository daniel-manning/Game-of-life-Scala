package life

import scala.io.Source

object FileLoader {

  def loadBoardFromFile(url:String):Board = {
    val fileLines : Iterator[String] = Source.fromResource(url).getLines
    val a = fileLines.toList.zipWithIndex.flatMap(y => y._1.zipWithIndex.map( x => {
      Cell((x._2, y._2), if(x._1 == '.') Dead else Alive)
    }))

    val map:Map[Location, Status] = a.foldRight(Map[Location, Status]())((x, y) => {
      x.status match {
        case Alive => y + ((x.location, Alive))
        case Dead => y
      }
    })

    Board(map)
  }

}
