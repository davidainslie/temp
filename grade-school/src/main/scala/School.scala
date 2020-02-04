import scala.collection.SortedMap

class School {
  // Yuck! Var! But that's because of the requested API.
  var db: SortedMap[Int, Seq[String]] = SortedMap.empty[Int, Seq[String]]

  val add: (String, Int) => School = (name, grade) => {
    db += grade -> (db.getOrElse(grade, Seq.empty[String]) :+ name)
    this
  }

  val grade: Int => Seq[String] = grade =>
    db.getOrElse(grade, Seq.empty[String])

  def sorted: SortedMap[Int, Seq[String]] = {
    db = db.mapValues(_.sorted)
    db
  }
}