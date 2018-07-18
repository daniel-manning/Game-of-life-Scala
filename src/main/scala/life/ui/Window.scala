package life.ui

import java.awt.Color

import life._

import scala.swing.Swing._
import scala.swing.{Graphics2D, MainFrame, Panel, SimpleSwingApplication}
import monix.execution.Scheduler.Implicits.global
import scala.concurrent.duration._
import monix.reactive._

object Window extends SimpleSwingApplication {
  var board =  FileLoader.loadBoardFromFile("glider")

  lazy val ui: Panel = new Panel {
    background = Color.white
    preferredSize = (400, 400)

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

      board.boardState.foreach(x => {
        val (location, _) = x
        g.fillRect(offsetX + location._1 * width, offsetY + location._2 * height, drawWidth, drawHeight)
      })

    }
  }

  def top: MainFrame = new MainFrame {
    title = "Game of Life"
    contents = ui
  }

  ///////////////MONIX TASKS
  val tick = {
    Observable.interval(1.second)
      .map(x => {board = board.evolveBoard(); ui.repaint(); x})
  }

  val cancelable = tick.subscribe()

}