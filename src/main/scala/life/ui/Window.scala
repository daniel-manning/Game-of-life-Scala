package life.ui

import java.awt.Color

import scala.swing.Swing._
import scala.swing.{Graphics2D, MainFrame, Panel, SimpleSwingApplication}

object Window extends SimpleSwingApplication {
  lazy val ui = new Panel {
    background = Color.white
    preferredSize = (200, 200)

    focusable = true


    override def paintComponent(g: Graphics2D) = {
      super.paintComponent(g)
      g.setColor(Color.black)
      g.fillRect(10, 10, 10, 10)
    }
  }

  def top = new MainFrame {
    title = "Game of Life"
    contents = ui
  }
}