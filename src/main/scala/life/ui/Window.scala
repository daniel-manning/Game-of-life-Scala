package life.ui

import java.awt.Color

import life.{Alive, Board, Cell, Dead}

import scala.swing.Swing._
import scala.swing.{Graphics2D, MainFrame, Panel, SimpleSwingApplication}

object Window extends SimpleSwingApplication {
  val board = Board(List( Cell((0,0), Dead), Cell((1,0), Dead), Cell((2,0), Dead), Cell((3,0), Dead),
    Cell((0,1), Dead), Cell((1,1), Alive), Cell((2,1), Alive), Cell((3,1), Dead),
    Cell((0,2), Dead), Cell((1,2), Alive), Cell((2,2), Alive), Cell((3,2), Dead),
    Cell((0,3), Dead), Cell((1,3), Dead), Cell((2,3), Dead), Cell((3,3), Dead)))

  lazy val ui: Panel = new Panel {
    background = Color.white
    preferredSize = (200, 200)

    focusable = true


    override def paintComponent(g: Graphics2D): Unit = {
      super.paintComponent(g)
      g.setColor(Color.black)

      val offsetX = 10
      val offsetY = 10

      val width:Int = 10
      val height:Int = 10

      val drawWidth:Int = 9
      val drawHeight:Int = 9

      board.boardState.foreach(x => {println(x); if(x.status == Alive) g.fillRect(offsetX + x.location._1*width, offsetY + x.location._2*height, drawWidth, drawHeight)})

    }
  }

  def top: MainFrame = new MainFrame {
    title = "Game of Life"
    contents = ui
  }
}