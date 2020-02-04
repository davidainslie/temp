import Garden._

object Garden {
  import Plant._

  type Plants = String

  type Pupil = String

  val plant = Map("R" -> Radishes, "C" -> Clover, "G" -> Grass, "V" -> Violets)

  val garden: Plants => Seq[Seq[Plant]] = { plants =>
    plants.split("\n").foldLeft(Seq.empty[Seq[Plant]]) { (g, ps) =>
      g :+ ps.toList.map { p => plant(p.toString) }
    }
  }

  val defaultGarden: Plants => Garden = { plants =>
    val pupils = Seq("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry")

    Garden(pupils, garden(plants))
  }

  def apply(pupils: List[Pupil], plants: Plants): Garden = Garden(pupils, garden(plants))
}

case class Garden(pupils: Seq[Pupil], plants: Seq[Seq[Plant]]) {
  val getPlants: Pupil => Seq[Plant] = { pupil =>
    pupils.indexOf(pupil) match {
      case -1 => Seq.empty[Plant]
      case pupilIndex => plants flatMap { _.grouped(2).toSeq(pupilIndex) }
    }
  }
}

trait Plant

object Plant {
  object Radishes extends Plant

  object Clover extends Plant

  object Grass extends Plant

  object Violets extends Plant
}