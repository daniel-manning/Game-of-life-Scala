package life

import scala.io.Source

object FileLoader {

  def loadBoardFromFile(url:String):Board = {
    val fileLines : Iterator[String] = Source.fromResource(url).getLines
    Board.apply(fileLines.toList.zipWithIndex.flatMap(y => y._1.zipWithIndex.map( x => Cell((x._2, y._2), if(x._1 == '.') Dead else Alive ))))
  }

}
