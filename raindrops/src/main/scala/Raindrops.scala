object Raindrops {
  type ToFactor = String => String

  val convert: Int => String = { i =>
    val matches: PartialFunction[String, String] => ToFactor = {
      _ orElse { case s => s }
    }

    val threeFactor: ToFactor = matches {
      case s if i % 3 == 0 => s + "Pling"
    }

    val fiveFactor: ToFactor = matches {
      case s if i % 5 == 0 => s + "Plang"
    }

    val sevenFactor: ToFactor = matches {
      case s if i % 7 == 0 => s + "Plong"
    }

    val justNumber: ToFactor = matches {
      case "" => i.toString
    }

    (threeFactor andThen fiveFactor andThen sevenFactor andThen justNumber)("")
  }
}

object RaindropsThatILike {
  lazy val rainMap = Map(
    3 -> "Pling",
    5 -> "Plang",
    7 -> "Plong"
  )

  def convert(n: Int): String = rainMap.keys.filter(n % _ == 0).map(rainMap).mkString match {
    case "" => n.toString
    case plxng => plxng
  }
}
