case class Cell(location:(Int,Int), status:Status)

sealed trait Status
case object Alive extends Status
case object Dead extends Status