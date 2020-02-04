class PhoneNumber(provided: String) {
  lazy val number: Option[String] = {
    val PhoneNumber10 = """(\d{10})""".r

    val PhoneNumber11 = """1(\d{10})""".r

    provided.filter(_.isDigit) match {
      case PhoneNumber10(n) => Some(n)
      case PhoneNumber11(n) => Some(n)
      case _ => None
    }
  }

  lazy val areaCode: Option[String] = number.map(_.take(3))

  lazy val prettyPrint: Option[String] = {
    val PhoneNumberPrettyReady = """(\d{3})(\d{3})(\d{4})""".r

    number flatMap {
      case PhoneNumberPrettyReady(area, prefix, suffix) => Some(s"($area) $prefix-$suffix")
      case _ => None
    }
  }
}