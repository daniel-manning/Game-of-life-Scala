//type Location = (Int, Int)

sealed trait Status
case object Alive extends Status
case object Dead extends Status

case class Cell(location:(Int, Int), status:Status)