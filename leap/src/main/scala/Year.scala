case class Year(value: Int) {
  val isLeap = (value % 4 == 0, value % 100 == 0, value % 400 == 0) match {
    case (true, true, true) => true
    case (true, false, false) => true
    case _ => false
  }
}